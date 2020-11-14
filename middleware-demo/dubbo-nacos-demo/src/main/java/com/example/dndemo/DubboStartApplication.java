package com.example.dndemo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DubboStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboStartApplication.class,args);
    }
}
