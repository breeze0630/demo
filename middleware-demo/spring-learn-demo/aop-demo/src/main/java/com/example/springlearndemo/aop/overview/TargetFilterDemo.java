package com.example.springlearndemo.aop.overview;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TargetFilterDemo {

    public static void main(String[] args) throws ClassNotFoundException {
        String targetClassName = "com.example.springlearndemo.aop.overview.EchoService";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> targetClass = classLoader.loadClass(targetClassName);

        //String echo(String message);
        //Spring 反射工具类
        Method method = ReflectionUtils.findMethod(targetClass,"echo",String.class);
        System.out.println(method);


        // 查找 throws 类型为 NullPointException 的 方法
        // 其他诸如 参数类型，method.getParameterTypes()
        ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                System.out.println("仅抛出 NullPointException 的方法为：" + method);
            }
        }, new ReflectionUtils.MethodFilter() {
            @Override
            public boolean matches(Method method) {
                Class[] exceptionTypes = method.getExceptionTypes();
//                return exceptionTypes.length == 1 && NullPointerException.class.equals(exceptionTypes[0]);
                return Arrays.stream(exceptionTypes).allMatch(e -> NullPointerException.class.equals(e));
            }
        });


    }
}
