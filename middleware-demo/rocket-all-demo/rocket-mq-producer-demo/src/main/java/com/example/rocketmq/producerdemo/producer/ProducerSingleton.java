package com.example.rocketmq.producerdemo.producer;

import org.apache.rocketmq.client.apis.*;
import org.apache.rocketmq.client.apis.producer.Producer;
import org.apache.rocketmq.client.apis.producer.ProducerBuilder;
import org.apache.rocketmq.client.apis.producer.TransactionChecker;

/**
 * @auther: liubiao
 * @date: 2024-11-04
 */
public class ProducerSingleton {
    private static volatile Producer PRODUCER;
    private static volatile Producer TRANSACTIONAL_PRODUCER;
    private static final String ACCESS_KEY = null;
    private static final String SECRET_KEY = null;
    private static final String ENDPOINTS = "localhost:8081";

    private ProducerSingleton() {
    }

    private static Producer buildProducer(TransactionChecker checker, String... topics) throws ClientException {
        ClientServiceProvider provider = ClientServiceProvider.loadService();
        SessionCredentialsProvider sessionCredentialsProvider = new StaticSessionCredentialsProvider(ACCESS_KEY, SECRET_KEY);
        ClientConfiguration clientConfiguration = ClientConfiguration.newBuilder().setEndpoints(ENDPOINTS).setCredentialProvider(sessionCredentialsProvider).build();
        ProducerBuilder builder = provider.newProducerBuilder().setClientConfiguration(clientConfiguration).setTopics(topics);
        if (checker != null) {
            builder.setTransactionChecker(checker);
        }

        return builder.build();
    }

    public static Producer getInstance(String... topics) throws ClientException {
        if (null == PRODUCER) {
            Class var1 = ProducerSingleton.class;
            synchronized(var1) {
                if (null == PRODUCER) {
                    PRODUCER = buildProducer((TransactionChecker)null, topics);
                }
            }
        }

        return PRODUCER;
    }

    public static Producer getTransactionalInstance(TransactionChecker checker, String... topics) throws ClientException {
        if (null == TRANSACTIONAL_PRODUCER) {
            Class var2 = org.apache.rocketmq.client.java.example.ProducerSingleton.class;
            synchronized(org.apache.rocketmq.client.java.example.ProducerSingleton.class) {
                if (null == TRANSACTIONAL_PRODUCER) {
                    TRANSACTIONAL_PRODUCER = buildProducer(checker, topics);
                }
            }
        }

        return TRANSACTIONAL_PRODUCER;
    }
}
