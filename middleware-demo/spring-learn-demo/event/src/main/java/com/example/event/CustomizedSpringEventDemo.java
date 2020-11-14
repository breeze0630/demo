package com.example.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 自定义监听器：
 * 1、自定义Event ，一般直接继承 {@link ApplicationEvent} 即可
 * 2、自定义Listener, 可以实现 {@link ApplicationListener}
 * 3、注册事件 addListener
 * */
public class CustomizedSpringEventDemo {
    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        //注册事件, 注册事件可以先于refresh(), 也可以晚于 refresh(),如果要监听 refresh 相关的事件，应先注册
        applicationContext.addApplicationListener(new MyStringEventListener());
        applicationContext.refresh();

        //先refresh 才能推送事件
        applicationContext.publishEvent(new MyStringEvent("hello 1"));
        applicationContext.publishEvent(new MyStringEvent2("hello 2"));
        applicationContext.publishEvent(new MyStringEvent3("hello 3"));

        applicationContext.close();
    }
}
