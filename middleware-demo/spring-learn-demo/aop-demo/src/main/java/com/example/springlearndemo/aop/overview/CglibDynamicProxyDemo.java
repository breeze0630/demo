package com.example.springlearndemo.aop.overview;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB 示例
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {
        //确保classLoad 是当前使用的


        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        Enhancer enhancer = new Enhancer();
        Class configSuperClass = DefaultEchoService.class;
        enhancer.setSuperclass(configSuperClass);
        // 指定拦截接口
        enhancer.setInterfaces(new Class<?>[] {EchoService.class});
        enhancer.setUseFactory(false);
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
        enhancer.setCallback(new MethodInterceptor(){
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long startTime = System.currentTimeMillis();
//                String result = (String)method.invoke(o,args);
                String result = (String) methodProxy.invokeSuper(o,args);
                long costTime = System.currentTimeMillis()- startTime;
                System.out.println("echo [CGLIB提升] 方法执行时间: " + costTime + " ms.");
                return result;
            }
        });
//        Object proxy =  Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                if(EchoService.class.isAssignableFrom(method.getDeclaringClass())){
//                    ProxyEchoService echoService = new ProxyEchoService(new DefaultEchoService());
//                    return echoService.echo((String)args[0]);
//                }
//                return null;
//            }
//        });

        EchoService echoService = (EchoService) enhancer.create();
        echoService.echo("Hello,World!");
    }
}
