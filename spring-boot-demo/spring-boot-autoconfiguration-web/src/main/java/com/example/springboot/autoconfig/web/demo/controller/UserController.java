package com.example.springboot.autoconfig.web.demo.controller;


import com.example.springboot.autoconfig.web.demo.entity.User;
import com.example.springboot.autoconfig.web.demo.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @GetMapping("getById1")
    public Object getById(Integer id){
        return userMapper.selectById(id);
    }
    @GetMapping("updateById")
    public Object update(Integer id ,String name){
        User user = userMapper.selectById(id);
        user.setUserName(name);
        return userMapper.updateById(user);
    }

}

