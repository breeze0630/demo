package com.example.paymentservicehystrix8030.service.impl;

import com.example.apicommons.domain.common.CommonResult;
import com.example.paymentservicehystrix8030.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public CommonResult<String> serviceOk(int id) {
        String s = "服务 payment-service id:" + id + "  ,serviceOk. ";
        log.info(s);
        return new CommonResult<>(s);
    }

    @Override
    @HystrixCommand(fallbackMethod = "serviceTimeoutHandle"
    ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public CommonResult<String> serviceTimeout(int id) {
        int timeoutNum = 2;

        try {
            TimeUnit.SECONDS.sleep(timeoutNum);
        } catch (InterruptedException e) {
            log.error("e:{}",e);
        }
        String s = "服务 : "+ Thread.currentThread().getName() +" payment-service id:" + id + "  ,serviceOk 耗时(秒):" +  timeoutNum;
        log.info(s);
        return new CommonResult<>(s);
    }

    public CommonResult<String> serviceTimeoutHandle(int id) {
        String s = "服务 : "+ Thread.currentThread().getName() +" payment-service id:" + id + "  ,serviceTimeOut 系统繁忙.超时"   ;
        log.info(s);
        return new CommonResult<>(s);
    }
}
