package com.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件监听支持层级传递，Listener 可以监听到原本监听的事件的子类事件，
 * */
public class MyStringEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyStringEvent(String source) {
        super(source);
    }
}
