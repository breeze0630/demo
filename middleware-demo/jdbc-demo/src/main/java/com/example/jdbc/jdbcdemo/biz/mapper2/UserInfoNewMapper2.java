package com.example.jdbc.jdbcdemo.biz.mapper2;

import com.example.jdbc.jdbcdemo.anno.SecondaryMapper;
import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;

import java.util.List;

@SecondaryMapper
public interface UserInfoNewMapper2 {

    List<UserInfo> selectAll();

}
