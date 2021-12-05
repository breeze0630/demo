package com.example.paymentservicesentinel8060.controller;

import com.example.apicommons.domain.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
public class HotKeyController {

    @GetMapping("hotkeyByGet")
    public CommonResult hotkey(@RequestParam("key1") String key1
            , @RequestParam("key2") String key2){
        log.info("key1:{},key2:{}",key1,key2);
        return new CommonResult( " return key1:"+ key1+", key2:"+key2 +" , UUID:"+
                UUID.randomUUID() + " , thread:"+ Thread.currentThread().getName());
    }
}
