package com.example.paymentservicesentinel8060;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServiceSentinel8060Application {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceSentinel8060Application.class, args);
	}

}
