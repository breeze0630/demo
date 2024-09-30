package com.example.mybatisplusexample.controller;

import com.alibaba.fastjson.JSON;
import com.example.mybatisplusexample.domain.req.QueryReq;
import com.example.mybatisplusexample.domain.vo.UserDetailVo;
import com.example.mybatisplusexample.service.AddressInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private AddressInfoService addressInfoService;


    @GetMapping("list")
    public List<UserDetailVo> getList(QueryReq queryReq){
        log.info("list.param:{}", JSON.toJSONString(queryReq));
        return addressInfoService.getList(queryReq);
    }

}
