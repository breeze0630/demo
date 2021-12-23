package com.example.mybatisdynamicexample2.api;

import com.example.mybatisdynamicexample2.domain.User;
import com.example.mybatisdynamicexample2.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("get/{id}")
    public User get(@PathVariable("id") int id){
        return userService.selectById(id);
    }


    @PostMapping("update/{id}")
    public int get(@PathVariable("id") int id,@RequestBody User user){
        return userService.updateById(user);
    }
}
