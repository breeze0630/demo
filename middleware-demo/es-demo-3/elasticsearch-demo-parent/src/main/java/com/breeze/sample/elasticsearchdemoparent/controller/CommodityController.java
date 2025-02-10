package com.breeze.sample.elasticsearchdemoparent.controller;

import com.breeze.sample.elasticsearchdemoparent.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2024-12-23
 */
@RestController
@RequestMapping("commodity")
public class CommodityController {


    @Autowired
    private CommodityMapper commodityMapper;


    @GetMapping("/getList")
    public Object getList(){

        return String.valueOf("ok");

    }
}
