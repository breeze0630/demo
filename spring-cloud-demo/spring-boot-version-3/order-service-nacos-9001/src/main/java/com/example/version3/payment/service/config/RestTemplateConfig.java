package com.example.version3.payment.service.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     * 因为这里没有使用 ribbon,所以需要引入 spring-cloud-starter-loadbalancer
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate( ){
        return new RestTemplate();
    }
}
