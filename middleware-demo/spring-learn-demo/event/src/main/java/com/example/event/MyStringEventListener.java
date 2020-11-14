package com.example.event;

import org.springframework.context.ApplicationListener;

/**
 * 自定义监听器
 * */
public class MyStringEventListener implements ApplicationListener<MyStringEvent> {

    @Override
    public void onApplicationEvent(MyStringEvent event) {
        System.out.printf("[线程 %s] 监听到事件: %s \n",Thread.currentThread().getName(),event);
    }
}
