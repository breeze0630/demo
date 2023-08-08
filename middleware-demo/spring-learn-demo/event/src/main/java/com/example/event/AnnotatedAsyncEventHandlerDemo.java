package com.example.event;

import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 *  1、使用 {@link EventListener} 注解时，可以不需要调用 addApplicationListener() ，
 *  如果同时调用了 addApplicationListener(),那么触发顺序为  {@link EventListener} > addApplicationListener()
 *
 *
 * */
@EnableAsync
public class AnnotatedAsyncEventHandlerDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotatedAsyncEventHandlerDemo.class);


        //注册事件, 注册事件可以先于refresh(), 也可以晚于 refresh(),如果要监听 refresh 相关的事件，应先注册
        applicationContext.refresh();
//        applicationContext.addApplicationListener(new MyStringEventListener());

/*        ApplicationEventMulticaster applicationEventMulticaster = applicationContext.getBean(AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME, ApplicationEventMulticaster.class);
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
        }*/



        //先refresh 才能推送事件
        applicationContext.publishEvent(new MyStringEvent("hello 1"));

        applicationContext.close();
    }
    @Bean(name = AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
    public Executor taskExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("my-annotated-thread-pool-"));
        return executorService;
    }
    /**
     * 用注解 可以不用完整的提供一个listener class，
     * 启动类上要搭配  {@link EnableAsync},否则不生效
     *
     * {@link Async} 指定value 是为了解决 “No qualifying bean of type 'org.springframework.core.task.TaskExecutor' available” 的DEBUG 异常，不指定value 仅添加 Bean 依然无法处理
     *
     * */
    @Async(AsyncExecutionAspectSupport.DEFAULT_TASK_EXECUTOR_BEAN_NAME)
    @EventListener
    public void onMySpringEvent(MyStringEvent event){
        System.out.printf("@EventListener onMySpringEvent[线程 %s] 监听到事件: %s \n",Thread.currentThread().getName(),event);
    }





}
