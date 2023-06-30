package com.example.mybatisplusexample.conf;

import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Objects;
import java.util.Properties;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/6/30
 */
@Component
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

    private void encrypt(Object object) throws Throwable {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            NeedEncrypt needEncrypt = field.getAnnotation(NeedEncrypt.class);
            if (needEncrypt != null) {
                String value = (String)field.get(object);
                String result = Base64.getEncoder()
                        .encodeToString(value.getBytes(StandardCharsets.UTF_8));
                field.set(object,result);
            }
        }


    }
}
