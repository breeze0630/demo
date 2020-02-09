package com.example.springlearndemo.beandemo.springbean.definition.factory;


import com.example.springlearndemo.beandemo.springbean.definition.User;

/**
 * @author liubiao
 */
public interface UserFactory {
    default User createUser(){
        User user = new User();
        user.setId(1L);
        user.setName("刘彪");
        return user;
    }
}
