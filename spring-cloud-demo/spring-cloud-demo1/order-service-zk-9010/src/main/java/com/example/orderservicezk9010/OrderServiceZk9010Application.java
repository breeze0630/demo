package com.example.orderservicezk9010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderServiceZk9010Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceZk9010Application.class, args);
    }

}
