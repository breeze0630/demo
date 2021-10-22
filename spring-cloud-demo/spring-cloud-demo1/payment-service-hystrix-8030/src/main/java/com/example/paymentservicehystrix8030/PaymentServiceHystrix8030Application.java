package com.example.paymentservicehystrix8030;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class PaymentServiceHystrix8030Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceHystrix8030Application.class, args);
    }

}
