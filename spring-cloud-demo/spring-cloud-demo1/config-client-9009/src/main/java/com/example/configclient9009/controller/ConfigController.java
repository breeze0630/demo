package com.example.configclient9009.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liubiao
 * @date: 2021/10/30 21:54
 * @Description:
 */
@RestController
@RequestMapping("/config")
@Slf4j
@RefreshScope
public class ConfigController {

    @Value("${order.info}")
    String orderInfo;

    @GetMapping("/getOrderInfo")
    public Object getOrderInfo(){
        log.info("getOrderInfo:{}",orderInfo);
        return orderInfo;
    }
}
