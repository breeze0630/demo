package com.example.jdbc.jdbcdemo.service.impl;

import com.example.jdbc.jdbcdemo.biz.dto.PushStringEvent;
import com.example.jdbc.jdbcdemo.service.SpringEventPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SpringEventPushServiceImpl implements SpringEventPushService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String pushEvent(String info) {

        PushStringEvent event = new PushStringEvent("event");
        event.setInfo(info);
        applicationContext.publishEvent(event);
        return "success";
    }
}
