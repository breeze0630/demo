package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.configuration.MqProducerCallBack;
import com.example.configuration.TopicExchangeQueueConfig;
import com.example.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@RestController
@Slf4j
public class SendController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MqProducerCallBack mqFanoutCallBack;

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("work/{id}")
    public String work(@PathVariable("id") String id){
        User user = User.builder()
                .name("Topic" + id)
                .build();
        String msg = JSONObject.toJSONString(user);
        CorrelationData correlationData = new CorrelationData("id_" + System.currentTimeMillis() + "");
        rabbitTemplate.setConfirmCallback(mqFanoutCallBack);
        rabbitTemplate.convertAndSend(TopicExchangeQueueConfig.TEST_TOPIC_EXCHANGE,"one",msg, message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return message;
        },correlationData);
        return msg;
    }

    @GetMapping("work/d/{id}")
    public String workD(@PathVariable("id") String id){
        User user = User.builder()
                .name("Topic" + id)
                .build();
        String msg = JSONObject.toJSONString(user);
        CorrelationData correlationData = new CorrelationData("id_" + System.currentTimeMillis() + "");
        rabbitTemplate.setConfirmCallback(mqFanoutCallBack);
        rabbitTemplate.convertAndSend(TopicExchangeQueueConfig.TEST_TOPIC_EXCHANGE,"four",msg, message -> {
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return message;
        },correlationData);
        return msg;
    }

    @GetMapping("producer/{id}")
    public String producer(@PathVariable("id") String id) {
        boolean status = streamBridge.send("rabbitChannel1-out-0", MessageBuilder.withPayload(id)
                .setHeader("routingKey","first")
                .build());
        log.info("send.status:{}",status);
        return String.valueOf(status);
    }
}
