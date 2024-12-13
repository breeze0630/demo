package com.breeze.sample.seata.orderservice.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @auther: liubiao
 * @date: 2024-12-12
 */
@Slf4j
@Component
public class StockFallback implements FallbackFactory<StockFeign> {

    @Override
    public StockFeign create(Throwable cause) {
        return new StockFeign() {
            @Override
            public String reduct(Long productId) {
                return "调用库存失败";
            }
        };
    }

//    @Override
//    public String reduct(Long productId) {
//        return "调用库存失败";
//    }
}
