package com.example.cloudstreamrabbitmqprovider8040.service.impl;

import com.example.cloudstreamrabbitmqprovider8040.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: liubiao
 * @date: 2021/10/31 17:58
 * @Description:
 */
@EnableBinding(Source.class) // 定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;


    @Override
    public String send() {
        String message = "本次内容："+ UUID.randomUUID().toString();
        log.info("消息体：{}",message);
        output.send(MessageBuilder.withPayload(message).build());
        return message;
    }
}
