package com.example.scheduledemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@Slf4j
public class Job1 {
    @Bean("executor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(8);
        //最大核心线程数
        executor.setMaxPoolSize(16);
        //队列中等待被调度的任务数
        executor.setQueueCapacity(8);
        //
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        return executor;
    }

    @Scheduled(cron = "0/2 * * * * ?")
//    @Async
//            (value = "executor")
    public void exeucte(){

        log.info("job:{},thread:{}",this.getClass().getName(),Thread.currentThread().getName());
        System.nanoTime();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
