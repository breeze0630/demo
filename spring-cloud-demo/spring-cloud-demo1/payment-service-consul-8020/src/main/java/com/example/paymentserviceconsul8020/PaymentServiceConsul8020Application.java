package com.example.paymentserviceconsul8020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceConsul8020Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceConsul8020Application.class, args);
    }

}
