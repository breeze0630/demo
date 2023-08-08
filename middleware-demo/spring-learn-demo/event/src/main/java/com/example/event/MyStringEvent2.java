package com.example.event;

/**
 * 事件监听支持层级传递，Listener 可以监听到原本监听的事件的子类事件，
 * */
public class MyStringEvent2 extends MyStringEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MyStringEvent2(String source) {
        super(source);
    }
}
