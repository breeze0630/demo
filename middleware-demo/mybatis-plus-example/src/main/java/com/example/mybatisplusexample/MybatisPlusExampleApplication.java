package com.example.mybatisplusexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.mybatisplusexample.mapper")
public class MybatisPlusExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusExampleApplication.class, args);
    }

}
