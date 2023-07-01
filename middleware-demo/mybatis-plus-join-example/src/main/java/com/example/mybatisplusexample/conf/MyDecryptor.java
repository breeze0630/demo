package com.example.mybatisplusexample.conf;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.sql.Statement;
import java.util.*;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/6/30
 */
@Component
@Intercepts({ @Signature(method = "handleResultSets",type = ResultSetHandler.class,args = Statement.class)})
public class MyDecryptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        Object  res = invocation.proceed();

        if(Objects.isNull(res)){
            return res;
        }

        if(res instanceof ArrayList){
            ArrayList resList = (ArrayList) res;
            if(CollectionUtils.isNotEmpty(resList) && needToDe(resList.get(0)) ){
                for( Object resObj : resList){
                    decrypt(resObj);
                }
            }
        }else {
            if(needToDe(res)){
                decrypt(res);
            }
        }
        return res;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }

    private void decrypt(Object object) throws Throwable {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            NeedDecrypt needEncrypt = field.getAnnotation(NeedDecrypt.class);
            if (needEncrypt != null) {
                String value = (String)field.get(object);
                try {
                    if(Objects.isNull(value))
                    {
                        continue;
                    }
                    byte[] asBytes = Base64.getDecoder().decode(value);
                    String result = new String(asBytes, StandardCharsets.UTF_8);
                    field.set(object,result);
                } catch (Exception e) {
                    throw new RuntimeException("decrypt fail!", e);
                }
            }
        }
    }

    private boolean needToDe(Object obj){
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            NeedDecrypt needEncrypt = field.getAnnotation(NeedDecrypt.class);
            if( Objects.nonNull(needEncrypt) ){
                return true;
            }
            continue;
        }
        return false;
    }
}
