package com.example.paymentservicehystrix8030.service.impl;

import com.example.apicommons.domain.common.CommonResult;
import com.example.paymentservicehystrix8030.service.PaymentService;
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
    public CommonResult<String> serviceTimeout(int id) {
        int timeoutNum = 3;

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("e:{}",e);
        }
        String s = "服务 payment-service id:" + id + "  ,serviceOk 耗时(秒):" +  timeoutNum;
        log.info(s);
        return new CommonResult<>(s);
    }
}
