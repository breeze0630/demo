package com.breeze.sample.seata.stockservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.breeze.sample.seata.stockservice.entity.StockTbl;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
public interface StockService extends IService<StockTbl> {
    String reduct(Long productId);

}
