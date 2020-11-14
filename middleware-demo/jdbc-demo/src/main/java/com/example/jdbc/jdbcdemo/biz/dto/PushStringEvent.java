package com.example.jdbc.jdbcdemo.biz.dto;

import org.springframework.context.ApplicationEvent;

public class PushStringEvent extends ApplicationEvent {

    String info;

    public PushStringEvent(Object source) {
        super(source);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "PushTestEvent{" +
                "info='" + info + '\'' +
                '}';
    }
}
