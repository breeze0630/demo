package com.breeze.sample.seata.stockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableWebMvc
public class StockServiceApplication

{

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TransactionPropagationInterceptor());
//        WebMvcConfigurer.super.addInterceptors(registry);
//    }

    //    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new TransactionPropagationInterceptor());
//        super.addInterceptors(registry);
//    }
}
