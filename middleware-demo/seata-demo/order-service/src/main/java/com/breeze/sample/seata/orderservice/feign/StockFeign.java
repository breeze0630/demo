package com.breeze.sample.seata.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther: liubiao
 * @date: 2024-12-12
 */
@FeignClient(value = "stock-service",fallbackFactory = StockFallback.class)
public interface StockFeign {

    @GetMapping("/stock/reduct")
     String reduct(@RequestParam("productId") Long productId);
}
