package com.example.mybatisplusexample.db;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.mybatisplusexample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@DS("${db1}")
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User getUser(){
        return userMapper.selectById(1);
    }

}
