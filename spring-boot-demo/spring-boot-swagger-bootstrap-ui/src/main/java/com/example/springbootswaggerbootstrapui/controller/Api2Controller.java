package com.example.springbootswaggerbootstrapui.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootswaggerbootstrapui.dto.Test3Data;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liubiao
 * @date: 2021/5/7 16:44
 * @Description:
 */
@RestController
@RequestMapping("/api2")
@Api(tags = "首页模块")
@Slf4j
public class Api2Controller {

    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperation(value = "api2 接口1")
    @GetMapping("/test1")
    public ResponseEntity<String> test1(@RequestParam(value = "name")String name){
        return ResponseEntity.ok("Hi:"+name);
    }

    @GetMapping("/test2")
    public ResponseEntity<String> test2(){
        return ResponseEntity.ok("Hi:");
    }

    @PostMapping("/test3")
    public ResponseEntity<String> test3(@RequestBody Test3Data data){
        log.info(JSON.toJSONString(data));
        return ResponseEntity.ok("Hi:"+ JSON.toJSONString(data));
    }
}
