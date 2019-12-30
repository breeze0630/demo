package com.example.jdbc.jdbcdemo.service.impl;

import com.example.jdbc.jdbcdemo.biz.dto.PushStringEvent;
import com.example.jdbc.jdbcdemo.service.SpringEventPushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpringEventPushServiceImpl implements SpringEventPushService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public String pushEvent(String info) {

        log.info("pushEvent info:{}",info);
        for(int i = 0 ; i < 100 ; i++){
            PushStringEvent event = new PushStringEvent("event");
            event.setInfo(String.valueOf(i));
            applicationContext.publishEvent(event);
/*
            try {
                Thread.currentThread().sleep(100);
            }catch (Exception e){

            }
*/
        }

        return "success";
    }
}
