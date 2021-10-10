package com.example.paymentservicezk8011;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceZk8011Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceZk8011Application.class, args);
    }

}
