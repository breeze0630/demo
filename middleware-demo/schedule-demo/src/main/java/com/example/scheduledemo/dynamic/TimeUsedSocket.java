package com.example.scheduledemo.dynamic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TimeUsedSocket {

//    @Scheduled(cron = "* * * * * *")
    public static void send(){
        log.info("send...");
    }
}
