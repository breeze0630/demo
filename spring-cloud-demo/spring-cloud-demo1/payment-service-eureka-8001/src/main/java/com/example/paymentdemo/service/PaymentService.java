package com.example.paymentdemo.service;

import com.example.apicommons.domain.Payment;

/**
 * @author: liubiao
 * @date: 2021/10/9 11:59
 * @Description:
 */
public interface PaymentService {

    /**
     * 保存支付订单
     * @param payment
     * @return
     */
    Payment savePayment(Payment payment);
}
