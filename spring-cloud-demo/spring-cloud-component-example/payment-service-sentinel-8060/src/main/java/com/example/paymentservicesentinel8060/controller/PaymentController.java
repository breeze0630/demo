package com.example.paymentservicesentinel8060.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class PaymentController {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private AtomicInteger atomicInteger2 = new AtomicInteger(0);

    @GetMapping("/get/1")
    @SentinelResource(value = "hello",blockHandler = "helloBlockHandler")
    public Object getId(){
        atomicInteger.addAndGet(1);
        return "get:" + UUID.randomUUID() +  ":" +1;
    }
//    @SentinelResource(value = "hello",fallback = "helloBlockHandler")
    @GetMapping("/getInfo/1")
    @SentinelResource(value = "hello",blockHandler = "inner",blockHandlerClass = HelloBlockHandler.class)
    public Object getInfo(){
        atomicInteger2.addAndGet(1);
        return "getInfo:" + UUID.randomUUID() +  ":" + 1;
    }

    //这里参数必须是 BlockException 类型的异常，否则不进此handler
    public Object helloBlockHandler(BlockException be){
        return "异常终止!!!";
    }

//    @SentinelResource("hello")
    @GetMapping("/get1")
    public Object get1(){
        return atomicInteger.get();
    }

//    @SentinelResource("hello")
    @GetMapping("/get2")
    public Object get2(){
        return atomicInteger2.get();
    }
}
