package com.example.paymentservicehystrix8030.controller;

import com.example.apicommons.domain.common.CommonResult;
import com.example.paymentservicehystrix8030.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("payment/hystrix/ok/{id}")
    public CommonResult serviceOk(@PathVariable("id") int id){
        return paymentService.serviceOk(id);
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public CommonResult serviceTimeout(@PathVariable("id")int id){
        return paymentService.serviceTimeout(id);
    }
}
