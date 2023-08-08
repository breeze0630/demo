package com.example.springboot.autoconfig.web.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.autoconfig.web.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@DS("slave")
public interface UserMapper extends BaseMapper<User> {

    List<User> selectAllByUserId(@Param("userId") int userId);

}
