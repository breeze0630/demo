package com.example.mybatisplusexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MybatisPlusExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusExampleApplication.class, args);
    }

}
