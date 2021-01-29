package com.example.scheduledemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

/*@Configuration
@Slf4j
public class Job2 {

    @Scheduled(cron = "0/2 * * * * ?")
    @Async
//            (value = "executor")
    public void exeucte(){
        log.info("job:{},thread:{}",this.getClass().getName(),Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}*/
