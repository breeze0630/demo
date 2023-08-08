package com.example.springboot.autoconfig.web.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.autoconfig.web.demo.entity.User;
import com.example.springboot.autoconfig.web.demo.mapper.UserMapper;
import com.example.springboot.autoconfig.web.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
