package com.example.mybatisplusexample.controller;

import com.example.mybatisplusexample.db.AddressInfo;
import com.example.mybatisplusexample.db.User;
import com.example.mybatisplusexample.mapper.AddressInfoMapper;
import com.example.mybatisplusexample.mapper.UserMapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    UserMapper userMapper;

    @Autowired
    private AddressInfoMapper addressInfoMapper;

    @GetMapping("save")
    public Object savePass(){
        AddressInfo addressInfo = new AddressInfo();

        addressInfo.setAddress("ddd");
        addressInfo.setPassword("123456");
        addressInfoMapper.insert(addressInfo);
        return addressInfo;
    }



    @GetMapping("get/{id}")
    public Object getUser(@PathVariable("id") int id){
        return addressInfoMapper.selectById(id);
    }

    @GetMapping("get1/{id}")
    public Object get1(@PathVariable("id") int id){
        MPJLambdaWrapper<AddressInfo> lambdaWrapper = new MPJLambdaWrapper<AddressInfo>()
                .selectAll(AddressInfo.class)
                .leftJoin(User.class,User::getId, AddressInfo::getUserId);

        List<AddressInfo> addressList = addressInfoMapper.selectJoinList(AddressInfo.class,lambdaWrapper);
        return addressList;
    }



}
