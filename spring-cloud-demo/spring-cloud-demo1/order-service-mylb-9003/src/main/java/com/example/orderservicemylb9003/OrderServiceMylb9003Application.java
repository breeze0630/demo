package com.example.orderservicemylb9003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderServiceMylb9003Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMylb9003Application.class, args);
    }

}
