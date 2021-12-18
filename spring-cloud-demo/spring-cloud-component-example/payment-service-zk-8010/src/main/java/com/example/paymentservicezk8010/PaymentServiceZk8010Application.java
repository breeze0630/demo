package com.example.paymentservicezk8010;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceZk8010Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceZk8010Application.class, args);
    }

}
