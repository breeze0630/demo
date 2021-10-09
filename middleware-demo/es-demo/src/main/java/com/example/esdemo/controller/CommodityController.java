package com.example.esdemo.controller;

import com.example.esdemo.dto.Commodity;
import com.example.esdemo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;
    @GetMapping("get")
    public Object getCommodity(String name){
      return   commodityService.getByName(name);
    }

    @GetMapping("getAll")
    public Object getAll( ){
        return   commodityService.getAll();
    }
    @GetMapping("pageQuery")
    public Object  pageQuery(Integer pageNo, Integer pageSize, String name){
        return commodityService.pageQuery(pageNo,pageSize,name);
    }

    @PostMapping("add")
    public Object getCommodity(@RequestBody Commodity commodity){
        return   commodityService.save(commodity);
    }

    @PostMapping("delete")
    public void delete(@RequestBody Commodity commodity){
        commodityService.delete(commodity);
    }

    @PostMapping("deleteAll")
    public void deleteAll( ){
        commodityService.deleteAll();
    }
}
