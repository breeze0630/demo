package com.example.rocketmq.producerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class RocketMqProducerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketMqProducerDemoApplication.class, args);
	}

}
