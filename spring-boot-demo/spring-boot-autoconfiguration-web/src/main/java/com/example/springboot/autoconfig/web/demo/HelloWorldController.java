package com.example.springboot.autoconfig.web.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class HelloWorldController {

    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping
    @ResponseBody
    public String helloWorld(){
        return "Hello,World!";
    }

    @RequestMapping("setv")
    public String setV(String key,String value){
        log.info("key:{},value:{}",key,value);
        redisTemplate.opsForValue().set(key,value);
        return "success";

    }
    @RequestMapping(value = "getv")
    public Object getV(String key){
        return redisTemplate.opsForValue().get(key);
    }
}
