package com.example.paymentserviceeureka8002.controller;

import com.alibaba.fastjson.JSON;
import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author: liubiao
 * @date: 2021/10/9 12:45
 * @Description:
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    String serverPort;
    @PostMapping("add")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment){
        log.info("PaymentController.savePayment:{}", JSON.toJSONString(payment));
        return new CommonResult<>(200,"成功",payment);
    }

    @GetMapping("get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") int id){
        log.info("PaymentController.getPayment:{}", JSON.toJSONString(id));
        return new CommonResult<>(200,"成功",new Payment(id));
    }
    @GetMapping("getInfo/{id}")
    public CommonResult getInfo(@PathVariable("id") int id){
        log.info("PaymentController.getInfo:{}", JSON.toJSONString(id));
        return new CommonResult<>(200,"成功","payment-service  server.port："+serverPort+" "+ UUID.randomUUID());
    }
}
