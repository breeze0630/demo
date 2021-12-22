package com.example.mybatisplusexample.controller;

import com.example.mybatisplusexample.db.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("get/{id}")
    public Object getUser(@PathVariable("id") int id){
        return userDao.getUser(id);
    }
}
