package com.example.orderserviceopenfeign9004.service;

import com.example.apicommons.domain.Payment;
import com.example.apicommons.domain.common.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentFeignClient {

    @PostMapping("payment/add")
    public CommonResult<Payment> savePayment(@RequestBody Payment payment);

    @GetMapping("payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") int id);

    @GetMapping("payment/getInfo/{id}")
    public CommonResult getInfo(@PathVariable("id") int id);

}
