package com.example.mybatis.dynamic.example.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.dynamic.example.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper{

    User selectById(@Param("id") int id);

    int updateById(@Param("id") int id,@Param("age") int age);
}
