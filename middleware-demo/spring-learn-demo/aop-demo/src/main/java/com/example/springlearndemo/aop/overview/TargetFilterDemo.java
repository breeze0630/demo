package com.example.springlearndemo.aop.overview;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class TargetFilterDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "com.example.springlearndemo.aop.overview.EchoService";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> targetClass = classLoader.loadClass(targetClassName);

        //String echo(String message);
        //Spring 反射工具类
        Method method = ReflectionUtils.findMethod(targetClass,"echo",String.class);
        




    }
}
