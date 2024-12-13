package com.breeze.sample.seata.stockservice.controller;

import com.breeze.sample.seata.stockservice.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
@RestController
@RequestMapping("stock")
public class StockController {

    @Autowired
    private StockService stockService;
    @GetMapping("reduct")
    public Object reduct(Long productId){
        return stockService.reduct(productId);
    }
}
