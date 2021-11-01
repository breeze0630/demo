package com.example.paymentservicenacos8050;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceNacos8050Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceNacos8050Application.class, args);
    }

}
