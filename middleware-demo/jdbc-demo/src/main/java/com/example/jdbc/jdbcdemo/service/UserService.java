package com.example.jdbc.jdbcdemo.service;

import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;

import java.util.List;

public interface UserService {

    /**
     * 查询所有数据
     */
    List<UserInfo> getAllUser();

    List<UserInfo> selectByName(String name);
}
