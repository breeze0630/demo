package com.example.rocketmq.producerdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
@Slf4j
public class SyncConsumer {

    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("msg_group_demo_consumer");

    @PostConstruct
    public void init(){
        try {
            consumer.setNamesrvAddr("localhost:9876");
            consumer.subscribe("TopicA", "*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                   log.info("{} Receive New Messages: {}", Thread.currentThread().getName(), msgs);
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            consumer.start();
            log.info("SyncConsumer init success..");
        }catch (Exception E){
            log.error("SyncConsumer init failed....");
        }

    }

    @PreDestroy
    public void close(){
        consumer.shutdown();
    }

}
