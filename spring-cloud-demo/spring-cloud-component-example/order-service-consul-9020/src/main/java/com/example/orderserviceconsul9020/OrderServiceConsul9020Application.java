package com.example.orderserviceconsul9020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceConsul9020Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceConsul9020Application.class, args);
    }

}
