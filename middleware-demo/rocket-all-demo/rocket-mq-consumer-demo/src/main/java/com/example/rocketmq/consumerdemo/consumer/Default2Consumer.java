package com.example.rocketmq.consumerdemo.consumer;

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
public class Default2Consumer {

    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("msg_group_default_consumer2");

    @PostConstruct
    public void init(){
        try {
            consumer.setNamesrvAddr("localhost:9876");
            consumer.subscribe("topic2", "*");
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
                                                                ConsumeConcurrentlyContext context) {
                   log.info("{} Receive 2 New Messages: {}", Thread.currentThread().getName(), msgs);
                   /* msgs.forEach( k->{
                        if(k.getTopic().equals("topic2")){
                            throw new RuntimeException();
                        }
                    });*/
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });

            consumer.start();
            log.info("DefaultConsumer init success..");
        }catch (Exception E){
            log.error("DefaultConsumer init failed....");
        }

    }

    @PreDestroy
    public void close(){
        consumer.shutdown();
    }

}
