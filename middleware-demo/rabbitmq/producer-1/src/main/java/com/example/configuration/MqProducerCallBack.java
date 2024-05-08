package com.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@Component
@Slf4j
public class MqProducerCallBack implements RabbitTemplate.ConfirmCallback{

    /**
     * ack
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        /**
         * correlationData：对象内部只有一个 id 属性，用来表示当前消息的唯一性。
         * ack：消息投递到broker 的状态，true表示成功。
         * cause：表示投递失败的原因。
         */
        if (!ack) {
            log.error("消息发送异常!");
        } else {
            log.info("发送者已经收到确认，correlationData={} ,ack={}, cause={}", correlationData.getId(), ack, cause);
        }
    }
}
