package com.example.jdbc.jdbcdemo.service.impl;

import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;
import com.example.jdbc.jdbcdemo.biz.mapper.UserInfoNewMapper;
import com.example.jdbc.jdbcdemo.biz.mapper2.UserInfoNewMapper2;
import com.example.jdbc.jdbcdemo.configswtich.ConfigSwitch;
import com.example.jdbc.jdbcdemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoNewMapper userInfoNewMapper;

    @Resource
    private UserInfoNewMapper2 userInfoNewMapper2;

    @Override
    public List<UserInfo> getAllUser() {
        if(ConfigSwitch.sqlSwitch)
             return userInfoNewMapper.selectAll();
        else
            return userInfoNewMapper2.selectAll();
    }
}
