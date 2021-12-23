package com.example.mybatisdynamicexample2.domain.service;

import com.example.mybatisdynamicexample2.domain.User;
import com.example.mybatisdynamicexample2.domain.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User selectById(int id){
        return userMapper.selectById(id);
    }

    public int updateById(User user){
         return userMapper.updateById(user);
    }
}
