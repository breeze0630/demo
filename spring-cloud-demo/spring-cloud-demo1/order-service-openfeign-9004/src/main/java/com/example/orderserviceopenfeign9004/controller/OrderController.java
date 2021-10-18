package com.example.orderserviceopenfeign9004.controller;

import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import com.example.orderserviceopenfeign9004.service.PaymentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    private PaymentFeignClient paymentFeignClient;


    @GetMapping("/getpayment/{id}")
    public Object getPaymentById( @PathVariable("id") int id){
        log.info("getPaymentById:{}",id);
        return paymentFeignClient.getPayment(id);
    }

    @GetMapping("get/{id}")
    public Object getOrder(@PathVariable("id")int id){
        return new CommonResult<>("id="+id);
    }

    @GetMapping("/getPayment2/{id}")
    public Object getpayment1( @PathVariable("id") int id){
        log.info("getPayment2:{}",id);
        return paymentFeignClient.getInfo(id);
    }

}
