package com.example.scheduledemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloWorld {
    @GetMapping("api/{info}")
    public Object helloWorld(@PathVariable("info") String info){
        String hello = "hello "+ info;
        log.info(hello);
        return hello;
    }
}
