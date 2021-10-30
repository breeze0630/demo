package com.example.configclient9008;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient9008Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient9008Application.class, args);
    }

}
