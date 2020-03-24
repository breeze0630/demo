package com.example.jdbc.jdbcdemo.api;

import com.example.jdbc.jdbcdemo.service.SpringEventPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("springEventApi")
public class SpringEventApi {


    @Autowired
    private SpringEventPushService stringEventPushService;

    @RequestMapping("push")
    public Object pushEvent(String info) {

        return stringEventPushService.pushEvent(info);
    }
}
