package com.example.jdbc.jdbcdemo.service.impl;

import com.example.jdbc.jdbcdemo.biz.bean.Info;
import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;
import com.example.jdbc.jdbcdemo.biz.mapper.InfoMapper;
import com.example.jdbc.jdbcdemo.biz.mapper.UserInfoNewMapper;
import com.example.jdbc.jdbcdemo.biz.mapper2.UserInfoNewMapper2;
import com.example.jdbc.jdbcdemo.configswtich.ConfigSwitch;
import com.example.jdbc.jdbcdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoNewMapper userInfoNewMapper;

    @Resource
    private UserInfoNewMapper2 userInfoNewMapper2;

    @Resource
    private InfoMapper infoMapper;

    @Override
    @Transactional
    public List<UserInfo> getAllUser() {
        log.info("getAllUser");
        if (ConfigSwitch.sqlSwitch) {
            return userInfoNewMapper.selectAll();
        } else {
            return userInfoNewMapper2.selectAll();
        }
    }

    @Override
    @Transactional
    public List<UserInfo> selectByName(String name) {
        List<UserInfo> userInfos =  userInfoNewMapper.selectByName("%"+name + "%",11);
        List<UserInfo> userInfos1 = userInfoNewMapper.selectByName("%"+name + "%",11);
        return userInfos;
    }


    @Override
    @Transactional
    public void deleteUser(String name){
        try {
            Thread.currentThread().sleep(10000);

            userInfoNewMapper.deleteByName(name);
            log.info("aaaa");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void insert(Info info) {
        infoMapper.insert(info);
    }
}
