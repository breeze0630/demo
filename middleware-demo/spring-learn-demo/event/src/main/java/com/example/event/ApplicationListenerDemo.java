package com.example.event;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 *
 * {@link org.springframework.context.ApplicationListener}
 * @Description
 * @Date: 2020/9/13 18:57
 * @Create by external_ll@163.com
 **/

//@EnableAsync
//使用 EnableAsync 时需要注意配置 TaskExecution
public class ApplicationListenerDemo implements ApplicationEventPublisherAware {

    public static void main(String[] args) {
//        GenericApplicationContext applicationContext = new GenericApplicationContext();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ApplicationListenerDemo.class);

        // 基于spring 接口向上下文注册事件,如果要监听 refresh 相关的事件，应先注册
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("ApplicationListener - 接收到spring 事件：" + event);
                if(event instanceof PayloadApplicationEvent){
                    println("ApplicationListener - 接收到spring 事 payload<T>:" + ((PayloadApplicationEvent<?>) event).getPayload());
                }
            }
        });
        applicationContext.refresh();

        applicationContext.start();

        applicationContext.close();
    }


    @EventListener
    public void onApplicationRefreshEvent(ContextRefreshedEvent event){
        println("ApplicationEvent - 接收到spring ContextRefreshedEvent" );
    }

    @EventListener
    @Async
    public void onApplicationEventRefreshAsync(ContextRefreshedEvent event){
        println("ApplicationEvent - 接收到spring ContextRefreshedEvent");
    }


    @EventListener
    public void onApplicationStartedEvent(ContextStartedEvent event){
        println("ApplicationEvent - 接收到spring ContextStartedEvent");
    }

    @EventListener
    public void onApplicationclosedEvent(ContextClosedEvent event){
        println("ApplicationEvent - 接收到spring ContextClosedEvent" );
    }

    private static void println(Object printable){
        System.out.printf("[线程：%s] : %s\n",Thread.currentThread().getName(),printable);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new ApplicationEvent("hello 1") {
        });
        applicationEventPublisher.publishEvent("hello 2");
        applicationEventPublisher.publishEvent(new MyPayloadApplicationEvent(this,"hello 3"));

    }


    static class MyPayloadApplicationEvent<String> extends PayloadApplicationEvent<String>{

        public MyPayloadApplicationEvent(Object source, String payload) {
            super(source, payload);
        }
    }
}
