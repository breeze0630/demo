package com.example.springlearndemo.annotation;

import org.springframework.context.annotation.Bean;

//@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "hello,world";
    }

}
