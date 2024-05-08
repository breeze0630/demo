package com.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024/2/29
 */
@Component
@Slf4j
public class ConProcess {

    @Bean
    public Consumer<String> getMessage(){
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                log.info("收到消息：{}",s);
            }
        };
    }

}
