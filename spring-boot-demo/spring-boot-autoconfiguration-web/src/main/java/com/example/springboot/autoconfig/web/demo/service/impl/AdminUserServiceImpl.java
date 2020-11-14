package com.example.springboot.autoconfig.web.demo.service.impl;

import com.example.springboot.autoconfig.web.demo.entity.AdminUser;
import com.example.springboot.autoconfig.web.demo.mapper.AdminUserMapper;
import com.example.springboot.autoconfig.web.demo.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {

}
