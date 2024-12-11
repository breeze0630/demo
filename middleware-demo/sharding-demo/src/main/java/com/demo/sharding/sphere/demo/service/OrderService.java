package com.demo.sharding.sphere.demo.service;

import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.vo.OrderVo;

import java.util.List;

/**
 * @auther: liubiao
 * @date: 2024-11-22
 */
public interface OrderService {

   int saveOne(Order order);

   List<OrderVo> getList();
   int batchSaveOrder(List<Order> order);
}
