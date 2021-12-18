package com.example.configclient9009;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient9009Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient9009Application.class, args);
    }

}
