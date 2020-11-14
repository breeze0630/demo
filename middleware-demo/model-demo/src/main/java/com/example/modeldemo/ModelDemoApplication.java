package com.example.modeldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 通过枚举决定执行具体的实现
 * */
@SpringBootApplication
public class ModelDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModelDemoApplication.class, args);
    }

}
