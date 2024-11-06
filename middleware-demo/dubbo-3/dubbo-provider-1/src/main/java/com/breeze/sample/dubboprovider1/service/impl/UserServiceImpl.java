package com.breeze.sample.dubboprovider1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breeze.sample.dubboprovider1.domain.User;
import com.breeze.sample.dubboprovider1.service.UserService;
import com.breeze.sample.dubboprovider1.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author lb
* @description 针对表【user】的数据库操作Service实现
* @createDate 2024-10-28 11:26:36
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




