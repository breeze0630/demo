package com.breeze.sample.seata.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breeze.sample.seata.orderservice.entity.OrderTbl;
import com.breeze.sample.seata.orderservice.feign.StockFeign;
import com.breeze.sample.seata.orderservice.mapper.OrderTblMapper;
import com.breeze.sample.seata.orderservice.service.OrderService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderTblMapper, OrderTbl> implements OrderService {

    @Autowired
    private StockFeign stockFeign;
    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    @GlobalLock
    public OrderTbl placeOrder(Long productId) {
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setAccountId(productId);
        orderTbl.setMoney(new BigDecimal(Math.random()));
        this.save(orderTbl);
        String res =  stockFeign.reduct(productId);

        log.info("调用库存:{}",res);
        if("ok".equals(res)){
            throw new RuntimeException();
        }
        return orderTbl;
    }
}
