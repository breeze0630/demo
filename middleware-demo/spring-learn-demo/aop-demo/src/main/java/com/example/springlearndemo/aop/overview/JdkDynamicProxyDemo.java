package com.example.springlearndemo.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理示例
 * */
public class JdkDynamicProxyDemo {

    public static void main(String[] args) {
        //确保classLoad 是当前使用的

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy =  Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(EchoService.class.isAssignableFrom(method.getDeclaringClass())){
                    ProxyEchoService echoService = new ProxyEchoService(new DefaultEchoService());
                    return echoService.echo((String)args[0]);
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello,World!");
    }
}
