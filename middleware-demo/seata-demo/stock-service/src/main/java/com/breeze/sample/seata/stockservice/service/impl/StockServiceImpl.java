package com.breeze.sample.seata.stockservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breeze.sample.seata.stockservice.entity.StockTbl;
import com.breeze.sample.seata.stockservice.mapper.StockTblMapper;
import com.breeze.sample.seata.stockservice.service.StockService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import io.seata.tm.api.transaction.Propagation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
@Service
@Slf4j
public class StockServiceImpl extends ServiceImpl<StockTblMapper, StockTbl> implements StockService {

    @Override
//    @GlobalTransactional
    public String reduct(Long productId) {
        log.info("调用库存:{}",productId);
         StockTbl stockTbl = this.getById(productId);
         stockTbl.setCount(stockTbl.getCount()-1);
         this.updateById(stockTbl);
        return "ok";
    }
}
