package com.example.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * {@link org.springframework.context.ApplicationListener}
 * @Description
 * @Date: 2020/9/13 18:57
 * @Create by external_ll@163.com
 **/

@EnableAsync
public class ApplicationListenerDemo {

    public static void main(String[] args) {
//        GenericApplicationContext applicationContext = new GenericApplicationContext();

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ApplicationListenerDemo.class);

        // 基于spring 接口向上下文注册事件
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("ApplicationListener - 接收到spring 事件：" + event);
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
}
