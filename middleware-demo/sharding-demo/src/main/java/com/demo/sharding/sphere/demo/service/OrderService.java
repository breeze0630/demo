package com.demo.sharding.sphere.demo.service;

import com.demo.sharding.sphere.demo.entity.Order;

import java.util.List;

/**
 * @auther: liubiao
 * @date: 2024-11-22
 */
public interface OrderService {

   int saveOne(Order order);

   int batchSaveOrder(List<Order> order);
}
