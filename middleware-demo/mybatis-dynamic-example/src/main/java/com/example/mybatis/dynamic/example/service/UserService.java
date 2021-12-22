package com.example.mybatis.dynamic.example.service;

import com.example.mybatis.dynamic.example.domain.User;
import com.example.mybatis.dynamic.example.domain.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;


    public User getById(int id){
        return userMapper.selectById(id);
    }

    public void updateById(User user){
        userMapper.updateById(user);
    }
}
