package com.breeze.sample.seata.orderservice.controller;

import com.breeze.sample.seata.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("placeOrder")
    public Object placeOrder(Long productId){
        return orderService.placeOrder(productId);
    }
}
