package com.example.orderservicefeignhystrix9006.service;

import com.example.apicommons.domain.common.CommonResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * feign 调用失败时，回调对应的方法，所以要实现 FeignClient
 */
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
