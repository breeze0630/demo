package com.example.jdbc.jdbcdemo.biz.mapper;

import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 查询所有数据
 */
@Mapper
public interface UserInfoNewMapper {

    /**
     * 查询所有数据
     */
    List<UserInfo> selectAll();

    int deleteByName(@Param("name")String name);

    int updateByName(@Param("name") String name,@Param("newAge") int age);

    List<UserInfo> selectByName(
            @Param("name")
                    String name,int age);
}
