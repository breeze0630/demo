package com.example.dndemo.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDubbo
        (scanBasePackages = "com.example.dndemo")
//@EnableDubboConfig
public class DubboConfig {

    private String port;

    private String address;
}
