package com.example.jdbc.jdbcdemo.biz.mapper2;

import com.example.jdbc.jdbcdemo.anno.SecondaryMapper;
import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;

import java.util.List;

/**
 * 查询所有数据
 */
@SecondaryMapper
public interface UserInfoNewMapper2 {

    /**
     * 查询所有数据
     */
    List<UserInfo> selectAll();

}
