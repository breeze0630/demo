package com.example.orderservicefeignhystrix9006.service;

import com.example.apicommons.domain.common.CommonResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaymentFeignClientHandle implements PaymentFeignClient{
    @Override
    public CommonResult serviceOK(int id) {
        return new CommonResult("  PaymentFeignClientHandle.serviceOK ,id = " + id +",UUID = " + UUID.randomUUID() );
    }

    @Override
    public CommonResult serviceTimeout(int id) {
        return new CommonResult("  PaymentFeignClientHandle.serviceTimeout  ,id = " + id +" ,UUID = " + UUID.randomUUID() );
    }
}
