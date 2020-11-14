package com.example.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @Description
 * @Date: 2020/9/20 22:08
 * @Create by external_ll@163.com
 **/
public class hierarchySpringEventPropagateDemo {

    public static void main(String[] args) {

        //1. 创建 parent context 应用上下文
        AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();

        parentContext.setId("parent-context");

        parentContext.register(MyListener.class);

        //2、 创建 current context 应用上下文
        AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();

        currentContext.setId("current-context");

        currentContext.register(MyListener.class);

        currentContext.setParent(parentContext);

        parentContext.refresh();

        currentContext.refresh();

        parentContext.close();

        currentContext.close();
    }


    static class MyListener implements ApplicationListener<ContextRefreshedEvent>
    {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.printf(" 监听到 Spring 应用上下文 [ id: %s] 的 ContextRefreshedEvent \n",event.getApplicationContext().getId());
        }
    }
}
