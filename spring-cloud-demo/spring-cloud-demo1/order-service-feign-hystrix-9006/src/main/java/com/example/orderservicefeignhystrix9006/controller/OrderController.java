package com.example.orderservicefeignhystrix9006.controller;

import com.example.apicommons.domain.common.CommonResult;
import com.example.orderservicefeignhystrix9006.service.PaymentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liubiao
 * @date: 2021/10/24 11:57
 * @Description:
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private PaymentFeignClient paymentFeignClient;


    @GetMapping("/serviceOk/{id}")
    public Object getPaymentById( @PathVariable("id") int id) {
        log.info("getPaymentById:{}", id);
        return paymentFeignClient.serviceOK(id);
    }

    @GetMapping("/timeout/{id}")
    public Object timeout(@PathVariable("id") int id){
        log.info("timeout:{}",id);
        return paymentFeignClient.serviceTimeout(id);
    }
}
