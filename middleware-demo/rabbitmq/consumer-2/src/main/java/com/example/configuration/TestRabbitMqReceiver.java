package com.example.configuration;

import com.alibaba.fastjson.JSON;
import com.example.dto.User;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;



/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@Component
@Slf4j
public class TestRabbitMqReceiver {

    /**
     * 监听队列
     * @param msg
     * @param channel
     * @param message
     * @throws IOException
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "TEST_TOPIC_QUEUE_A"),
                    exchange = @Exchange(value = "TEST_TOPIC_EXCHANGE",type = "topic"),//绑定交换机 //默认直连 direct
                    key = {"one"}
            )
    })
    public void testWorkTopic1(String msg, Channel channel, Message message) throws IOException {
        try {
            log.info("小富收到消息：", msg);
            User user = JSON.parseObject(msg, User.class);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("进入one____________" + user);
            log.info("WWWWWWWWWWWW__________" + message.getMessageProperties().getDeliveryTag());
            log.info("CCCCCCCCCCCCC__________" + message.getMessageProperties().getRedelivered());
            //TODO 具体业务
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                log.info("消息已重复处理失败,拒绝再次接收！");
                // 拒绝消息，requeue=false 表示不再重新入队，如果配置了死信队列则进入死信队列
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                log.info("消息即将再次返回队列处理！");
                // requeue为是否重新回到队列，true重新入队
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "TEST_TOPIC_QUEUE_A"),
                    exchange = @Exchange(value = "TEST_TOPIC_EXCHANGE",type = "topic"),//绑定交换机 //默认直连 direct
                    key = {"one"}
            )
    })
    public void testWorkTopic11(String msg, Channel channel, Message message) throws IOException {
        try {
            log.info("小富收到消息11：", msg);
            User user = JSON.parseObject(msg, User.class);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("进入one11____________" + user);
            log.info("WWWWWWWWWWWW11__________" + message.getMessageProperties().getDeliveryTag());
            log.info("CCCCCCCCCCCCC11__________" + message.getMessageProperties().getRedelivered());
            //TODO 具体业务
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                log.info("消息已重复处理失败,拒绝再次接收！");
                // 拒绝消息，requeue=false 表示不再重新入队，如果配置了死信队列则进入死信队列
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                log.info("消息即将再次返回队列处理！");
                // requeue为是否重新回到队列，true重新入队
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "TEST_TOPIC_QUEUE_B"),
                    exchange = @Exchange(value = "TEST_TOPIC_EXCHANGE",type = "topic"),//绑定交换机 //默认直连 direct
                    key = {"two"}
            )
    })
    public void testWorkTopic2(String msg, Channel channel, Message message) throws IOException {
        try {
            log.info("小富收到消息：", msg);
            User user = JSON.parseObject(msg, User.class);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("进入two____________" + user);
            log.info("WWWWWWWWWWWW__________" + message.getMessageProperties().getDeliveryTag());
            log.info("CCCCCCCCCCCCC__________" + message.getMessageProperties().getRedelivered());
            //TODO 具体业务
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                log.info("消息已重复处理失败,拒绝再次接收！");
                // 拒绝消息，requeue=false 表示不再重新入队，如果配置了死信队列则进入死信队列
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                log.info("消息即将再次返回队列处理！");
                // requeue为是否重新回到队列，true重新入队
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }
/*
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "TEST_TOPIC_QUEUE_C"),
                    exchange = @Exchange(value = "TEST_TOPIC_EXCHANGE",type = "topic"),//绑定交换机 //默认直连 direct
                    key = {"three","one"}
            )
    })
    public void testWorkTopic3(String msg, Channel channel, Message message) throws IOException {
        try {
            log.info("小富收到消息：", msg);
            User user = JSON.parseObject(msg, User.class);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            log.info("进入three____________" + user);
            log.info("WWWWWWWWWWWW__________" + message.getMessageProperties().getDeliveryTag());
            log.info("CCCCCCCCCCCCC__________" + message.getMessageProperties().getRedelivered());
            //TODO 具体业务
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                log.info("消息已重复处理失败,拒绝再次接收！");
                // 拒绝消息，requeue=false 表示不再重新入队，如果配置了死信队列则进入死信队列
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } else {
                log.info("消息即将再次返回队列处理！");
                // requeue为是否重新回到队列，true重新入队
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }*/

}
