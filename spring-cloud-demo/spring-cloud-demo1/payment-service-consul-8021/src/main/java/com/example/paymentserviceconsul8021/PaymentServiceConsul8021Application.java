package com.example.paymentserviceconsul8021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceConsul8021Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceConsul8021Application.class, args);
    }

}
