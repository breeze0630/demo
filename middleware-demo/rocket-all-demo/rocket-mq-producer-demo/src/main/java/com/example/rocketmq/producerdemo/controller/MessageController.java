package com.example.rocketmq.producerdemo.controller;

import com.example.rocketmq.producerdemo.dto.MessageDTO;
import com.example.rocketmq.producerdemo.producer.SyncProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SyncProducer syncProducer;


    @GetMapping(value = "/send")
    public String send(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);
        syncProducer.sendMsg(messageDTO);
        return "success";
    }
}
