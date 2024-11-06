package com.breeze.sample.dubbosampleapi.api;

import com.breeze.sample.dubbosampleapi.base.Result;
import com.breeze.sample.dubbosampleapi.dto.UserDto;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
public interface UserServiceApi {

    Result<UserDto> saveUser(UserDto req);

    Result<UserDto> getUserById(Long id);

    Result<UserDto> updateUser(UserDto req);

}
