package com.breeze.sample.dubboprovider1.mapper;

import com.breeze.sample.dubboprovider1.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import javax.management.MXBean;

/**
* @author lb
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-28 11:26:36
* @Entity com.breeze.sample.dubboprovider1.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




