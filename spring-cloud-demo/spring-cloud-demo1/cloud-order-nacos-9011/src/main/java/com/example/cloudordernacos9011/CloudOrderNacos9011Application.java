package com.example.cloudordernacos9011;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudOrderNacos9011Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudOrderNacos9011Application.class, args);
    }

}
