package com.example.configuration;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@Component
public class TopicExchangeQueueConfig {

    public final static String TEST_TOPIC_QUEUE_A = "TEST_TOPIC_QUEUE_A";
    public final static String TEST_TOPIC_QUEUE_B = "TEST_TOPIC_QUEUE_B";
    public final static String TEST_TOPIC_QUEUE_C = "TEST_TOPIC_QUEUE_C";
    public final static String TEST_TOPIC_EXCHANGE = "TEST_TOPIC_EXCHANGE";
    public final static String TEST_TOPIC_QUEUE_D = "TEST_TOPIC_QUEUE_D";

    @Bean
    public Queue topicQueueA() {
        Queue queue = new Queue(TEST_TOPIC_QUEUE_A);
        queue.getArguments().put("x-dead-letter-exchange", "dlx_exchange");
        queue.getArguments().put("x-dead-letter-routing-key", "dlx_a");
        return queue;
    }

    @Bean
    public Queue topicQueueD() {
        Queue queue = new Queue(TEST_TOPIC_QUEUE_D);
        queue.getArguments().put("x-dead-letter-exchange", "dlx_exchange_d");
        queue.getArguments().put("x-dead-letter-routing-key", "dlx_d");
        return queue;
    }

    @Bean
    public Queue topicQueueB() {
        return new Queue(TEST_TOPIC_QUEUE_B);
    }

    @Bean
    public Queue topicQueueC() {
        Queue queue = new Queue(TEST_TOPIC_QUEUE_C);
        /**
         * queue.getArguments().put() 设置死信队列
         * x-dead-letter-exchange  死信队列的交换机名
         * x-dead-letter-routing-key 死信队列的路由
         *
         * 也可以用 QueueBuilder 来构建，比较方便
         * QueueBuilder.durable("TEST_TOPIC_QUEUE_C")
         * .deadLetterExchange("死信交换机名").deadLetterRoutingKey("死信队列的路由")
         */

        return queue;
    }

    //死信队列
    @Bean
    public Queue topicQueueADlx() {
        return QueueBuilder.durable("dlx_queue_a").build();
    }
    @Bean
    public Queue topicQueueDDlx() {
        return QueueBuilder.durable("dlx_queue_d").build();
    }

    @Bean("topicExchange")
    public TopicExchange topicExchange() {
        return new TopicExchange(TEST_TOPIC_EXCHANGE);
    }

    // 死信交换机
    @Bean("dlxExchange")
    public DirectExchange dlxExchange() {
        DirectExchange dlxExchange = new DirectExchange("dlx_exchange");
        return dlxExchange;
    }

    @Bean("dlxExchangeD")
    public TopicExchange dlxExchangeD() {
        TopicExchange dlxExchange = new TopicExchange("dlx_exchange_d");
        return dlxExchange;
    }

    // 死信队列绑定死信交换机
    @Bean
    public Binding topicExchangeBindingADlx(Queue topicQueueADlx, @Qualifier("dlxExchange") DirectExchange dlxExchange) {
        return BindingBuilder.bind(topicQueueADlx).to(dlxExchange).with("dlx_a");
    }

    @Bean
    public Binding topicExchangeBindingDDlx(Queue topicQueueDDlx, @Qualifier("dlxExchangeD") TopicExchange dlxExchange) {
        return BindingBuilder.bind(topicQueueDDlx).to(dlxExchange).with("dlx_d");
    }
    @Bean
    public Binding topicExchangeBindingA(Queue topicQueueA, @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueA).to(topicExchange).with("one");
    }

    @Bean
    public Binding topicExchangeBindingD(Queue topicQueueD, @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueD).to(topicExchange).with("four");
    }

    @Bean
    public Binding topicExchangeBindingB(Queue topicQueueB, @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueB).to(topicExchange).with("two");
    }

    @Bean
    public Binding topicExchangeBindingC(Queue topicQueueC, @Qualifier("topicExchange") TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueueC).to(topicExchange).with("three");
    }
}
