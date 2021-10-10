package com.example.order.controller;

import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author: liubiao
 * @date: 2021/10/9 13:59
 * @Description:
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${service.payment.getPayment}")
    private String getPaymentUrl;

    @GetMapping("/getpayment/{id}")
    public Object getPaymentById( @PathVariable("id") long id){
        log.info("getPaymentById:{}",id);
        log.info("getPaymentById:{}",getPaymentUrl);
        return restTemplate.getForObject(getPaymentUrl+"/"+id, Payment.class);
    }

    @GetMapping("get/{id}")
    public Object getOrder(@PathVariable("id")int id){
        return new CommonResult<>("id="+id);
    }

    @GetMapping("getDis")
    public Object getDis(){
        return discoveryClient.getInstances("payment-service");
    }
}
