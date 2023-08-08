package com.example.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  1、对  {@link SimpleApplicationEventMulticaster} 设置 TaskExecutor，可以实现异步广播
 *  2、
 * */
public class AsyncEventHandlerDemo {
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        //注册事件, 注册事件可以先于refresh(), 也可以晚于 refresh(),如果要监听 refresh 相关的事件，应先注册
        applicationContext.addApplicationListener(new MyStringEventListener());
        applicationContext.refresh();

        ApplicationEventMulticaster applicationEventMulticaster = applicationContext.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
        if(applicationEventMulticaster instanceof  SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = (SimpleApplicationEventMulticaster) applicationEventMulticaster;
            ExecutorService taskExecutor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-spring-thread-pool-"));
            simpleApplicationEventMulticaster.setTaskExecutor(taskExecutor);

            //添加ContextClosed 事件 ,用于关闭上面使用的线程池,否则主程序不会关闭

            applicationEventMulticaster.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
                @Override
                public void onApplicationEvent(ContextClosedEvent event) {
                    if(!taskExecutor.isShutdown()){
                        taskExecutor.shutdown();
                    }
                }
            });

            applicationEventMulticaster.addApplicationListener(new ApplicationListener<MyStringEvent>() {
                @Override
                public void onApplicationEvent(MyStringEvent event) {
                    throw new  RuntimeException("故意抛出异常");
                }
            });

            /**
             * 同步推送时：异常处理后，后面的业务逻辑能正常执行，其实用try-catch 也是可以处理，只是不够优雅,并且如果事件调用的地方多，冗余的异常处理代码会很多
             * */
            simpleApplicationEventMulticaster.setErrorHandler( e->{
                System.err.println("当异常出现时，异常原因:"+e.getMessage());
            });


        }



        //先refresh 才能推送事件
        applicationContext.publishEvent(new MyStringEvent("hello 1"));

        applicationContext.close();
    }
}
