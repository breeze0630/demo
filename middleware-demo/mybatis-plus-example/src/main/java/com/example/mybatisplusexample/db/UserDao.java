package com.example.mybatisplusexample.db;

import com.example.mybatisplusexample.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@DS("${db1}")
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int id){
        return userMapper.selectById(id);
    }

}
