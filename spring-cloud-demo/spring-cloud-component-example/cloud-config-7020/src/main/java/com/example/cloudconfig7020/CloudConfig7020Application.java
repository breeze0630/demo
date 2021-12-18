package com.example.cloudconfig7020;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfig7020Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfig7020Application.class, args);
    }

}
