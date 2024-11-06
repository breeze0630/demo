package com.example.rocketmq.consumerdemo.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.apis.ClientConfiguration;
import org.apache.rocketmq.client.apis.ClientServiceProvider;
import org.apache.rocketmq.client.apis.consumer.ConsumeResult;
import org.apache.rocketmq.client.apis.consumer.FilterExpression;
import org.apache.rocketmq.client.apis.consumer.FilterExpressionType;
import org.apache.rocketmq.client.apis.consumer.PushConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
@Slf4j
public class Default3Consumer {

    @Value("${rocketmq.topic.endpoint:localhost:8081}")
    private String topicEndPoint ;

    @Value("${rocketmq.topic.name:group-topic-2024-11-04}")
    private String topicName;

    PushConsumer consumer = null;
    @Value("${rocketmq.consumer.name:consumer-1}")
    private String consumerGroup ;


    @PostConstruct
    public void init(){
        try {
             ClientServiceProvider provider = ClientServiceProvider.loadService();

            ClientConfiguration clientConfiguration = ClientConfiguration.newBuilder()
                    .setEndpoints(topicEndPoint)
                    .build();
            FilterExpression filterExpression = new FilterExpression("*", FilterExpressionType.TAG);

            PushConsumer pushConsumer = provider.newPushConsumerBuilder()
                    .setClientConfiguration(clientConfiguration)
                    // Set the consumer group name.
                    .setConsumerGroup(consumerGroup)
                    // Set the subscription for the consumer.

                    .setSubscriptionExpressions(Collections.singletonMap(topicName, filterExpression))
                    .setMessageListener(messageView -> {
                        // Handle the received message and return consume result.
                        log.info("Consume message={}", messageView);
                        return ConsumeResult.SUCCESS;
                    })
                    .build();
            log.info("DefaultConsumer init success..");
        }catch (Exception E){
            log.error("DefaultConsumer init failed....");
        }
    }
}
