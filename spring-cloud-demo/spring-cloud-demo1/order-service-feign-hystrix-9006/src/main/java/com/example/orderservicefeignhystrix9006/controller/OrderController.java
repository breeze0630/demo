package com.example.orderservicefeignhystrix9006.controller;

import com.example.apicommons.domain.common.CommonResult;
import com.example.orderservicefeignhystrix9006.service.PaymentFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: liubiao
 * @date: 2021/10/24 11:57
 * @Description:
 */
@RestController
@RequestMapping("order")
@Slf4j
@DefaultProperties(defaultFallback = "defaultTimeout_fallback",commandProperties ={
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1050")
    }
)
public class OrderController {

    @Resource
    private PaymentFeignClient paymentFeignClient;


    @Value("${info:infoA:infoB}")
    private String info;

    //测试参数默认值，以第一个分号分割 k-v
    @GetMapping("/info")
    public Object info( ) {
        //return infoA:infoB
        log.info("info:{}", info);
        return info;
    }

    @GetMapping("/serviceOk/{id}")
//    @HystrixCommand
    public Object getPaymentById( @PathVariable("id") int id) {
        log.info("getPaymentById:{}", id);
        return paymentFeignClient.serviceOK(id);
    }

    @GetMapping("/timeout/{id}")
    @HystrixCommand(
            fallbackMethod = "timeout_fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2050")
    }
    )
    public Object timeout(@PathVariable("id") int id){
        log.info("timeout:{}",id);
        return paymentFeignClient.serviceTimeout(id);
    }

    public String timeout_fallback(@PathVariable("id") int id){
        return "timeout_fallback.... timeout 超时,id = " + id;
    }

    @GetMapping("/timeout2/{id}")
    @HystrixCommand
    public Object timeout2(@PathVariable("id") int id){
        log.info("timeout2:{}",id);
        return paymentFeignClient.serviceTimeout(id);
    }

    public String defaultTimeout_fallback(){
        return "defaultTimeout_fallback.... timeout2 超时,UUID = "+ UUID.randomUUID() ;
    }


}
