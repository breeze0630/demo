package com.example.mybatisplusexample.conf;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.github.yulichang.wrapper.MPJAbstractWrapper;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/6/30
 */
@Component
@Slf4j
@Intercepts({ @Signature(method = "setParameters",type = ParameterHandler.class,args = PreparedStatement.class)})
public class MyEncryptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        if(invocation.getTarget() instanceof ParameterHandler){
            ParameterHandler parameterHandler = (ParameterHandler)invocation.getTarget();
            Field paramterField = parameterHandler.getClass().getDeclaredField("parameterObject");
            paramterField.setAccessible(true);
            Object parameterObject = paramterField.get(parameterHandler);
            if(Objects.nonNull(parameterObject)  && parameterObject instanceof Object){
                encrypt(parameterObject);
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }

    private void encrypt(Object object) {
        try {
            Class<?> clazz = object.getClass();
            if (object instanceof Map) {
                /* 这里是为了处理在mybatis中出现同一个引用，多次传参导致的多次加密bug，
                 * 其多次传参是因为mybatis 会在构建参数时，将参数自动追加一个名为 paramXXX 的参数
                 * org.apache.ibatis.reflection.ParamNameResolver.getNamedParams
                 *
                 * 例如 updateById , 传入的参数对象名为 et , 在内部构建参数时，会 追加一个 名为 param1 的参数，其引用的也是 et 的对象引用
                 */
                HashSet<Object> hashSet = new HashSet<>();

                for (Map.Entry<String, Object> entry : ((Map<String, Object>) object).entrySet()) {
                    Object entryValue = entry.getValue();
                    if (entryValue == null) {
                        continue;
                    } else {
                        hashSet.add(entryValue);
                    }
                }
                for (Object entryValue : hashSet) {

                    // 参数为AbstractWrapper 、 一般指类型为 LambdaWrapper 和  QueryWrapper 的参数
                    if (entryValue instanceof AbstractWrapper) {
                        AbstractWrapper lambdaQueryWrapper = (AbstractWrapper) entryValue;
                        Map<String, Object> valuePairs = lambdaQueryWrapper.getParamNameValuePairs();
                        Class<?> entityClazz = lambdaQueryWrapper.getEntityClass();
                        // 拿不到实体类型的不处理，因为这里是根据注解来的，没有实体类，何来注解
                        if (entityClazz == null) {
                            continue;
                        }
                        String sqlSegment = lambdaQueryWrapper.getExpression().getSqlSegment();
                        encryptBySqlSegment(sqlSegment, valuePairs, entityClazz);
                        //处理 sqlSet
                        if(entryValue instanceof LambdaUpdateWrapper) {
                            String sqlSet = ((LambdaUpdateWrapper) entryValue).getSqlSet();
                            encryptSqlSet(sqlSet,valuePairs,entityClazz);
                            Object dataEntity = ((LambdaUpdateWrapper) entryValue).getEntity();
                            encryptObj(dataEntity.getClass(),dataEntity);
                        }
                    }
                    else if (entryValue instanceof MPJAbstractWrapper) {
                        //   支持参数为MPJAbstractWrapper 场景 ， 类似于 AbstractWrapper
                        MPJAbstractWrapper lambdaQueryWrapper = (MPJAbstractWrapper) entryValue;
                        Map<String, Object> valuePairs = lambdaQueryWrapper.getParamNameValuePairs();
                        Class<?> entityClazz = lambdaQueryWrapper.getEntityClass();
                        // 拿不到实体类型的不处理，因为这里是根据注解来的，没有实体类，何来注解
                        if (entityClazz == null) {
                            continue;
                        }
                        String sqlSegment = lambdaQueryWrapper.getExpression().getSqlSegment();
                        encryptBySqlSegment(sqlSegment, valuePairs, entityClazz);
                        //处理 sqlSet

                    }
                    else {
                        encryptByEntity(entryValue);
                    }
                }
            } else {
                //保存，更新等操作
                encryptObj(clazz, object);
            }
        } catch (Exception e) {

        }
    }

    private void encryptSqlSet(String sqlSet, Map<String, Object> valuePairs, Class<?> entityClazz) {
        List<String> sqlList = Arrays.stream(sqlSet.split(",")).toList();
        Field[] fields = entityClazz.getDeclaredFields();
        for (Field field : fields) {
            NeedEncrypt needEncrypt = field.getAnnotation(NeedEncrypt.class);
            if (Objects.nonNull(needEncrypt)  && needEncrypt.columnValue() != null) {
                String columnName = needEncrypt.columnValue() + "=";
                for(String sql : sqlList){
                    //需要加密 有条件包含了需加密字段的
                    if(sql.contains(columnName)) {
                        //需要匹配 #{ew.paramNameValuePairs.MPGENVAL1}
                        String[] param = sql.split("=");
//                        String paramName = param[0];
                        String paramName = param[1];
                        paramName = paramName.substring( paramName.lastIndexOf(".")+1,paramName.length()- 1 );
                        String paramValue2 = Base64Encrypt.encrypt(String.valueOf(valuePairs.get(paramName)));
                        valuePairs.put(paramName,paramValue2);
                    }
                }
            }
        }
    }

    /**
     * 对参数为实体对象的场景操作
     * @param clazz
     * @param object
     */
    private void encryptObj(Class<?> clazz,Object object) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (Objects.nonNull(field)) {
                    field.setAccessible(true);
                    //根据是否存在 @NeedEncrypt 注解判断是否需要加密
                    NeedEncrypt needEncrypt = field.getAnnotation(NeedEncrypt.class);
                    if (needEncrypt != null) {
                        String value = (String) field.get(object);
                        if (Objects.isNull(value)) {
                            continue;
                        }
                        //具体的加密逻辑,如果增加了不同的算法，那么可以在这里进行处理
                        String result = Base64Encrypt.encrypt(value);
                        field.set(object, result);
                    }
                }
            } catch (InaccessibleObjectException e) {

            } catch (Exception e) {
                System.out.println("处理失败:{}");
            }
        }
    }

    /**
     * 参数为 Wrapper 的兜底场景
     * @param entryValue
     */
        private void encryptByEntity(Object entryValue) {
        Class<?> entryClazz = entryValue.getClass();
        Field[] fields = entryClazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (Objects.nonNull(field)) {
                    field.setAccessible(true);
                    //根据是否存在 @NeedEncrypt 注解判断是否需要加密
                    NeedEncrypt needEncrypt = field.getAnnotation(NeedEncrypt.class);
                    if (needEncrypt != null && field.get(entryValue) != null) {
                        String value = (String) field.get(entryValue);
                        if (Objects.isNull(value)) {
                            continue;
                        }
                        //具体的加密逻辑,如果增加了不同的算法，那么可以在这里进行处理
                        String result = Base64Encrypt.encrypt(value);
                        field.set(entryValue, result);
                    }
                }
            } catch (InaccessibleObjectException e) {
            } catch (Exception e) {
                System.out.println("处理失败:{}");
            }
        }
    }

    /**
     * 参数为 Wrapper 的 场景
     * @param sqlSegment
     * @param valuePairs
     * @param entityClazz
     */
    private void encryptBySqlSegment(String sqlSegment, Map<String, Object> valuePairs,Class<?> entityClazz) {
        if(StringUtils.isNotBlank(sqlSegment)) {
            List<String> sqlList = Arrays.stream(sqlSegment.split(" AND ")).toList();
            Field[] fields = entityClazz.getDeclaredFields();

            String regex = "#\\{ew.paramNameValuePairs.MPGENVAL" + "\\d+" + "}";
            for (Field field : fields) {
                NeedEncrypt needEncrypt = field.getAnnotation(NeedEncrypt.class);
                if (Objects.nonNull(needEncrypt)  && needEncrypt.columnValue() != null) {
                    String columnName = needEncrypt.columnValue() + " ";
                    for(String sql : sqlList){
                        //需要加密 有条件包含了需加密字段的
                        if(sql.contains(columnName)) {
                            //需要匹配 #{ew.paramNameValuePairs.MPGENVAL1}
                            Pattern pattern = Pattern.compile(regex);
                            Matcher matcher = pattern.matcher(sql);
                            while (matcher.find()) {
                                String group = matcher.group();
                                String paramName = group.substring( group.lastIndexOf(".")+1,group.length()- 1 );
                                String paramValue = String.valueOf(valuePairs.get(paramName));
                                String paramValue2 =Base64Encrypt.encrypt(paramValue);
                                valuePairs.put(paramName,paramValue2);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isNeed(Field field ,Object obj){
        try {
            NeedEncrypt needEncrypt = field.getAnnotation(NeedEncrypt.class);
            if (needEncrypt != null) {
                String value = (String) field.get(obj);
                return Objects.isNull(value);
            }
        }catch ( Exception e){

        }

        return false;

    }
}
