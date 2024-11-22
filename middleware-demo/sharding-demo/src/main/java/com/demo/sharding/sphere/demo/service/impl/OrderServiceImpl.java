package com.demo.sharding.sphere.demo.service.impl;

import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.mapper.OrderMapper;
import com.demo.sharding.sphere.demo.service.ExampleService;
import com.demo.sharding.sphere.demo.service.OrderService;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: liubiao
 * @date: 2024-11-22
 */
@Slf4j
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public int saveOne(Order order) {
        return orderMapper.insertOne(order);
    }

    @Override
    public int batchSaveOrder(List<Order> orderList) {

        orderMapper.insertOne(orderList.get(0));

        return 0;
    }
}
