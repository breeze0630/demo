package com.example.orderservicefeignhystrix9006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
public class OrderServiceFeignHystrix9006Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceFeignHystrix9006Application.class, args);
    }

}
