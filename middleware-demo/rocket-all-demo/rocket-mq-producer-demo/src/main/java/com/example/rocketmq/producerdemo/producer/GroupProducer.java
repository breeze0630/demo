package com.example.rocketmq.producerdemo.producer;

import com.example.rocketmq.producerdemo.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.*;
import org.apache.rocketmq.client.apis.message.Message;
import org.apache.rocketmq.client.apis.producer.Producer;

import org.apache.rocketmq.client.apis.producer.SendReceipt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;


/**
 * 异步消息
 * */
@Service
@Slf4j
public class GroupProducer {

    Producer producer = null;
    ClientServiceProvider provider = null;
    @Value("${rocketmq.topic.endpoint}")
    private String topicEndPoint ;

    @Value("${rocketmq.topic.name:group-topic-2024-11-04}")
    private String topicName;
    @PostConstruct
    public void init(){
        try {


            provider =  ClientServiceProvider.loadService();
            log.info("endpoint:{}",topicEndPoint);
            log.info("topicName:{}",topicName);

//            ClientConfigurationBuilder builder = ClientConfiguration.newBuilder().setEndpoints(topicEndPoint);
//            ClientConfiguration configuration = builder.build();
            // 初始化Producer时需要设置通信配置以及预绑定的Topic。
            ClientServiceProvider provider = ClientServiceProvider.loadService();
            ClientConfigurationBuilder builder = ClientConfiguration.newBuilder().setEndpoints(topicEndPoint);
            ClientConfiguration configuration = builder.build();
            // 初始化Producer时需要设置通信配置以及预绑定的Topic。
             producer = provider.newProducerBuilder()
                    .setTopics(topicName)
                    .setClientConfiguration(configuration)
                    .build();

            log.info("GroupProducer init success");
        }catch (Exception e){
            log.error("e:{},{}","GroupProducer init failed",e);
        }

    }


    public void send(MessageDTO dto){
        try {
            // 普通消息发送。
            Message message =  provider.newMessageBuilder()
                    .setTopic(topicName)
                    // 设置消息索引键，可根据关键字精确查找某条消息。
                    .setKeys("messageKey")
                    // 设置消息Tag，用于消费端根据指定Tag过滤消息。
                    .setTag("messageTag")
//                    .setMessageGroup("group1-1")
                    // 消息体。
                    .setBody(dto.getMsg().getBytes(StandardCharsets.UTF_8))
                    .build();
            try {
                // 发送消息，需要关注发送结果，并捕获失败等异常。
                SendReceipt sendReceipt = producer.send(message);
                log.info("Send message successfully, messageId={}", sendReceipt.getMessageId());
            } catch (ClientException e) {
                log.error("Failed to send message", e);
            }
//            }
        }catch (Exception e){

            log.error("e:{}",e);
        }

    }

}
