package com.example.rocketmq.producerdemo2.producer;

import com.example.rocketmq.producerdemo2.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

/**
 * @auther: liubiao
 * @date: 2024-11-05
 */
@Configuration
public class SendTask {

    @Autowired
    private GroupProducer groupProducer;
    @Scheduled(fixedDelay = 2000)
    public void sendText(){

        Random random = new Random();
        int size = random.nextInt(30);
        int index = 0;
        while (index < size) {
            groupProducer.send(new MessageDTO("test", "tag", "hello num " + index));
            index++;
        }
    }
}
