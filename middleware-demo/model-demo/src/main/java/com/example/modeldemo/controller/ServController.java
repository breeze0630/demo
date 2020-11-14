package com.example.modeldemo.controller;


import com.example.modeldemo.service.enumt.ServiceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
@Slf4j
public class ServController  {

    @RequestMapping("getByName")
    public void getByName(String name,String info){
        log.info("------------------------START-----------------------------");
        log.info("name:{},info:{}",name,info);
        ServiceEnum serviceEnum =  ServiceEnum.getByName(name);
        serviceEnum.outputInfo(info);
        log.info("------------------------END-----------------------------");
    }
}
