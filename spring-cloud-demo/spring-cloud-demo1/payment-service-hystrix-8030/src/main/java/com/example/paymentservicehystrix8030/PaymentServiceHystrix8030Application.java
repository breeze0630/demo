package com.example.paymentservicehystrix8030;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentServiceHystrix8030Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceHystrix8030Application.class, args);
    }

}
