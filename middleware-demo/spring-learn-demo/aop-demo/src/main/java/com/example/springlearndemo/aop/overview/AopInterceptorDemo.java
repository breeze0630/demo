package com.example.springlearndemo.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopInterceptorDemo {

    public static void main(String[] args) {
        //确保classLoad 是当前使用的

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy =  Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(EchoService.class.isAssignableFrom(method.getDeclaringClass())){
                    //将开始时间改为通过拦截器完成，实际此处可以通过加载容器中BeforeInterceptor 的实现类，这里方便测试直接使用匿名内部类
                    BeforeInterceptor beforeInterceptor = (proxy1,method1,args1) -> {
                        Long time = System.currentTimeMillis();
                        System.out.println("before  当前时间 : " + time);
                        return time;
                    };

                    Long startTime = 0L;
                    Long endTime = 0L ;
                    Object result = null;
                    EchoService echoService;
                    try {
                        startTime =  (Long)beforeInterceptor.before(proxy,method,args);
                        echoService = new DefaultEchoService();
                        result = echoService.echo((String)args[0]);

                        AfterInterceptor afterInterceptor = (proxy1,method1,args1,result1) -> {
                            Long time = System.currentTimeMillis();
                            System.out.println("afterReturn  当前时间 : " + time);
                            return time;
                        };
                        endTime = (Long)afterInterceptor.after(proxy,method,args,result);

                    }finally {
                        FinallyInterceptor finallyInterceptor = new TimeFinallyInterceptor(startTime,endTime);
                        long costTime = (Long)finallyInterceptor.finalize(proxy,method,args,result);

                        System.out.println("echo 方法执行时间: " + costTime + " ms.");

                    }
                    return result;
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello,World!");
    }
}

class TimeFinallyInterceptor implements FinallyInterceptor{

    private Long startTime;

    private Long endTime;

    public TimeFinallyInterceptor(Long startTime, Long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object afterReturn) {
        return endTime - startTime;
    }
}
