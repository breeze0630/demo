package com.example.orderserviceopenfeign9004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceOpenfeign9004Application {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceOpenfeign9004Application.class, args);
    }

}
