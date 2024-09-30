package com.example.mybatisplusexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class MybatisPlusJoinExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusJoinExampleApplication.class, args);
    }

}
