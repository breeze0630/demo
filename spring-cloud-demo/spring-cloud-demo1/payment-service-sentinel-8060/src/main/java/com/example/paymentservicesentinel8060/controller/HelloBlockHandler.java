package com.example.paymentservicesentinel8060.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class HelloBlockHandler {

    /**
     * 外置类的 BlockHandler 必须用静态方法
     * @param be
     * @return
     */
    public static Object inner(BlockException be){
        return "结束了...";
    }
}
