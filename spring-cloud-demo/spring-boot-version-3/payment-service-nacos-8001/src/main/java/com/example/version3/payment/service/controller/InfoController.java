package com.example.version3.payment.service.controller;

import com.example.apicommons.domain.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("info")
@Slf4j
public class InfoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("getInfo")
    public Object getInfo(){
        String str = "端口:"+serverPort;
        return str;
    }


    @GetMapping("get/{id}")
    public Object getOrder(@PathVariable("id")int id){
        return new CommonResult<>("id="+id);
    }
}
