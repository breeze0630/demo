package com.example.orderservicemylb9003.controller;

import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import com.example.orderservicemylb9003.config.MyLoadBalancerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
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

    @Autowired
    private MyLoadBalancerClient myLoadBalancerClient;

    @Value("${service.payment.getPayment}")
    private String getPaymentUrl;

    @Value("${service.payment.getPayment2}")
    private String getPaymentUrl2;

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

    @GetMapping("/getPayment2/{id}")
    public Object getpayment1( @PathVariable("id") long id){
        log.info("getPayment2:{}",id);
        log.info("getPayment2:{}",getPaymentUrl2);

        ServiceInstance serviceInstance =  myLoadBalancerClient.instances(discoveryClient.getInstances("PAYMENT-SERVICE"));

        return restTemplate.getForObject(serviceInstance.getUri()+"/payment/getInfo/"+id, String.class);
    }

    @GetMapping("getDis")
    public Object getDis(){
        return discoveryClient.getInstances("payment-service");
    }
}
