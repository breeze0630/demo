package com.example.mybatisplusexample.mapper;

import com.example.mybatisplusexample.db.User;
import com.github.yulichang.base.MPJBaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MPJBaseMapper<User> {

}
