package com.example.paymentdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.apicommons.domain.Payment;
import com.example.paymentdemo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: liubiao
 * @date: 2021/10/9 11:57
 * @Description:
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment savePayment(Payment payment){
        log.info("PaymentServiceImpl.savePayment:{}", JSON.toJSONString(payment));

        log.info("PaymentServiceImpl.savePayment successed");
        return payment;
    }
}
