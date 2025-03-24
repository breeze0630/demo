//package com.breeze.sample.nettydemo.netty.client;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @auther: liubiao
// * @date: 2025-03-24
// */
//@RestController
//public class SendApi {
//
//    @Autowired
//    private NettyClientConfiguration nettyClientConfiguration;
//    @GetMapping("/send/{num}")
//    public Object send(@PathVariable("num") String num){
//        nettyClientConfiguration.send(num);
//        return "success";
//    }
//}
