package com.example.paymentservicehystrix8030.service;

import com.example.apicommons.domain.common.CommonResult;

public interface PaymentService {

    public CommonResult<String> serviceOk(int id);

    public CommonResult<String> serviceTimeout(int id);


}
