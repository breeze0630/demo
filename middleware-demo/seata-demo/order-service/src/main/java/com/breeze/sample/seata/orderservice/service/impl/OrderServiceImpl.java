package com.breeze.sample.seata.orderservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breeze.sample.seata.orderservice.entity.OrderTbl;
import com.breeze.sample.seata.orderservice.feign.StockFeign;
import com.breeze.sample.seata.orderservice.mapper.OrderTblMapper;
import com.breeze.sample.seata.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.seata.spring.annotation.GlobalLock;
import org.apache.seata.spring.annotation.GlobalTransactional;
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
    public OrderTbl placeOrder(Long productId) {
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setAccountId(productId);
        orderTbl.setMoney(new BigDecimal(Math.random()));
        this.save(orderTbl);
        String res =  stockFeign.reduct(productId);

        log.info("调用库存:{}",res);
        try {
            Thread.sleep(20_000);
        }catch (Exception e){

        }

        if("ok".equals(res)){
            throw new RuntimeException();
        }
        return orderTbl;
    }
}
