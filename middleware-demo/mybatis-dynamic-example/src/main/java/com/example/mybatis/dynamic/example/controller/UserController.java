package com.example.mybatis.dynamic.example.controller;

import com.example.mybatis.dynamic.example.domain.User;
import com.example.mybatis.dynamic.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    public User get(@PathVariable("id") int id){
        return userService.getById(id);
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") int id,User user){
        user.setId(id);
        userService.updateById(user);
        return "ok";
    }
}
