package com.example.rocketmq.consumerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = "com.example.rocketmq.consumerdemo")
public class RocketMqConsumerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketMqConsumerDemoApplication.class, args);
	}

}
