package com.example.springboot.autoconfig.web.demo.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.autoconfig.web.demo.entity.AdminUser;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@DS("master")
public interface AdminUserMapper extends BaseMapper<AdminUser> {

}
