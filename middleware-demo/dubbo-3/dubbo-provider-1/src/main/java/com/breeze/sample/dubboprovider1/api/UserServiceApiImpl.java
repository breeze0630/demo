package com.breeze.sample.dubboprovider1.api;

import com.breeze.sample.dubbosampleapi.api.UserServiceApi;
import com.breeze.sample.dubbosampleapi.base.Result;
import com.breeze.sample.dubbosampleapi.dto.UserDto;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
@DubboService
public class UserServiceApiImpl implements UserServiceApi {

    @Override
    public Result<UserDto> saveUser(UserDto req) {
        return null;
    }

    @Override
    public Result<UserDto> getUserById(Long id) {
        return null;
    }

    @Override
    public Result<UserDto> updateUser(UserDto req) {
        return null;
    }
}
