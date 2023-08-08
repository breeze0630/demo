package com.example.orderservicefeignhystrix9006.service;

import com.example.apicommons.domain.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *  FeignClient.value 支持 ${param's name}
 *
 * @author: liubiao
 * @date: 2021/10/24 11:59
 * @Description:
 */
@Component
@FeignClient(value = "${service.name.1}",fallback = PaymentFeignClientHandle.class)
public interface PaymentFeignClient {


    @GetMapping("/payment/hystrix/ok/{id}")
    public CommonResult serviceOK(@PathVariable("id") int id);


    @GetMapping("/payment/hystrix/timeout/{id}")
    public CommonResult serviceTimeout(@PathVariable("id")int id);
}
