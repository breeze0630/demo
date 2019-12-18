package com.example.jdbc.jdbcdemo.biz.mapper;

import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserInfoNewMapper  {

    List<UserInfo> selectAll();
}
