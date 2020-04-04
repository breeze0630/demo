package com.example.dncddemo.controller;

import com.example.dndemo.service.InfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Reference
    InfoService infoService;
    @RequestMapping("printInfo")
    public String printInfo(String info){
       return infoService.printInfo(info);
    }
}
