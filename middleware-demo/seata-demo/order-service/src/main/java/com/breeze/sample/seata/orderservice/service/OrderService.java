package com.breeze.sample.seata.orderservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breeze.sample.seata.orderservice.entity.OrderTbl;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
public interface OrderService extends IService<OrderTbl> {
    OrderTbl placeOrder(Long productId);

}
