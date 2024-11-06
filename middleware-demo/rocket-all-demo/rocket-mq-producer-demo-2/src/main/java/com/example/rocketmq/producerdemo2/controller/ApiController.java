package com.example.rocketmq.producerdemo2.controller;

import com.example.rocketmq.producerdemo2.msg.Resources;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiController {

    @GetMapping("info")
    public String info(String msg){
      log.info(msg);
        String name = Resources.getMessage(msg);
        log.info(name);
        return name + " " + msg;
    }
}
