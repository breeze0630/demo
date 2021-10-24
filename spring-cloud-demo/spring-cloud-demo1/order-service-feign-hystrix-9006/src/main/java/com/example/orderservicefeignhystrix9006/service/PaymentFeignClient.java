package com.example.orderservicefeignhystrix9006.service;

import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: liubiao
 * @date: 2021/10/24 11:59
 * @Description:
 */
@Service
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignClient {



    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult serviceOK(@PathVariable("id") int id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommonResult serviceTimeout(@PathVariable("id")int id);
}
