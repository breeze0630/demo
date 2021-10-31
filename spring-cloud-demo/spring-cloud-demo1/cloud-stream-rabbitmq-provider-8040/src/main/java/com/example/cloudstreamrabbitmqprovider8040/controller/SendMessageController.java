package com.example.cloudstreamrabbitmqprovider8040.controller;

import com.example.cloudstreamrabbitmqprovider8040.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liubiao
 * @date: 2021/10/31 20:09
 * @Description:
 */
@RestController
@RequestMapping("message")
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
