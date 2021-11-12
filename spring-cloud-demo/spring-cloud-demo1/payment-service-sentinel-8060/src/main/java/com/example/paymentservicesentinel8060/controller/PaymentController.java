package com.example.paymentservicesentinel8060.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class PaymentController {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private AtomicInteger atomicInteger2 = new AtomicInteger(0);

    @GetMapping("/get/{id}")
    @SentinelResource(value = "hello",fallback = "helloBlockHandler")
    public Object getId(@PathVariable("id") int id){
        atomicInteger.addAndGet(1);
        return "get:" + UUID.randomUUID() +  ":" + id;
    }
    @SentinelResource(value = "hello",fallback = "helloBlockHandler")
    @GetMapping("/getInfo/{id}")
    public Object getInfo(@PathVariable("id") int id){
        atomicInteger2.addAndGet(1);
        return "getInfo:" + UUID.randomUUID() +  ":" + id;
    }

    public Object helloBlockHandler(FlowException be){
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
