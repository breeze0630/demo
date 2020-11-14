package com.example.rocketmq.producerdemo.controller;

import com.example.rocketmq.producerdemo.dto.MessageDTO;
import com.example.rocketmq.producerdemo.producer.AsyncProducer;
import com.example.rocketmq.producerdemo.producer.SyncProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private SyncProducer syncProducer;


    @Autowired
    private AsyncProducer asyncProducer;

    @GetMapping(value = "/send")
    public String send(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);
        syncProducer.sendMsg(messageDTO);
        return "success";
    }

    @GetMapping(value = "/sendAsync")
    public String sendAsync(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);
        asyncProducer.send(messageDTO);
        return "success";
    }
}
