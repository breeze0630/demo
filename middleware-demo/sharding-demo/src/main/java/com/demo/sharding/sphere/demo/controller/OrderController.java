package com.demo.sharding.sphere.demo.controller;

import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2024-11-22
 */
@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("saveOne")
    public Object saveOne(@RequestBody Order order){
      return  orderService.saveOne(order);
    }

}
