package com.example.cloudordernacos9011.controller;

import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String userServiceUrl;

    @GetMapping("getLocalInfo")
    public Object getLocalInfo(){
        return "local:" + UUID.randomUUID();
    }

    @GetMapping("get/{id}")
    public Object getId(@PathVariable("id") int id){
        return restTemplate.getForObject(userServiceUrl +"/info/get/"+id, CommonResult.class);
    }
    @GetMapping("getInfo")
    public Object getInfo(){
        return restTemplate.getForObject(userServiceUrl +"/info/getInfo", String.class);
    }
}
