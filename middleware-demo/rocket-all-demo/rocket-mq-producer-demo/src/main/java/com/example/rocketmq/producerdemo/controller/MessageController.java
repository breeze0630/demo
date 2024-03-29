package com.example.rocketmq.producerdemo.controller;

import com.example.rocketmq.producerdemo.dto.MessageDTO;
import com.example.rocketmq.producerdemo.producer.AsyncProducer;
import com.example.rocketmq.producerdemo.producer.DelayProducer;
import com.example.rocketmq.producerdemo.producer.SyncProducer;
import com.example.rocketmq.producerdemo.producer.TransactionMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private SyncProducer syncProducer;


    @Autowired
    private AsyncProducer asyncProducer;

    @Autowired
    private DelayProducer delayProducer;

    @Autowired
    private TransactionMessageProducer transactionMessageProducer;

    @Value("${test}")
    private String test;
    @GetMapping(value = "/send")
    public String send(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);

        syncProducer.sendMsg(messageDTO);
        return "send is success";
    }

    @GetMapping(value = "/send1")
    public String send1(String topic,String tag ) throws Exception{
        String message ="";
        while (message.length()<=1024*1024*4){
            message+="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        }
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);

        syncProducer.sendMsg(messageDTO);
        return "send is success";
    }

    @GetMapping(value = "/sendList")
    public String sendList(String topic,String tag,String message ) throws Exception{
        List<MessageDTO> messageDTOList = Arrays.asList(
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message),
                new MessageDTO(topic,tag,message)
        );

        syncProducer.sendMsgQueue(messageDTOList);
        return "send is success";
    }
    @GetMapping(value = "/sendAsync")
    public String sendAsync(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);
        asyncProducer.send(messageDTO);
        return "sendAsync is success";
    }

    @GetMapping(value = "/sendDelay")
    public String sendDelay(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);
        delayProducer.send(messageDTO);
        return "sendDelay is successed";
    }

    @GetMapping(value = "/sendTransactionMsg")
    public String sendTransactionMsg(String topic,String tag,String message) throws Exception{
        MessageDTO messageDTO = new MessageDTO(topic,tag,message);
        transactionMessageProducer.send(messageDTO);
        return "sendTransactionMsg is successed";
    }

}
