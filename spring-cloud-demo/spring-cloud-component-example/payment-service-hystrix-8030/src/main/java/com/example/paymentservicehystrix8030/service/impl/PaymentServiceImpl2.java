package com.example.paymentservicehystrix8030.service.impl;

import com.example.apicommons.domain.common.CommonResult;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PaymentServiceImpl2 {


    @HystrixCommand(fallbackMethod = "serviceTimeoutHandle"
            ,commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    })
    public CommonResult<String> serviceTimeout(int id) {
        log.info("serviceTimeout in services");
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
