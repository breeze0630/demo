package com.example.orderservicemylb9003.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liubiao
 * @date: 2021/10/9 14:30
 * @Description:
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    //这个不能放开，否则走的就是默认的balance
//    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }
}
