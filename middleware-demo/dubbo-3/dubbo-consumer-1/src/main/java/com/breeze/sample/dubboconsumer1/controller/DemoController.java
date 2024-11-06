package com.breeze.sample.dubboconsumer1.controller;

import com.breeze.sample.dubbosampleapi.api.AddressServiceApi;
import com.breeze.sample.dubbosampleapi.api.DemoService;
import com.breeze.sample.dubbosampleapi.api.UserServiceApi;
import com.breeze.sample.dubbosampleapi.base.Result;
import com.breeze.sample.dubbosampleapi.dto.UserDto;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
@RestController
@RequestMapping("/api")
public class DemoController {


    @DubboReference
    private DemoService demoService;

//    @DubboReference
//    private UserServiceApi userServiceApi;

    @DubboReference(version = "1.1.0",group = "breeze")
    private AddressServiceApi addressServiceApi;
    @GetMapping("/say/{msg}")
    public Object sayMsg(@PathVariable("msg")String msg){
        return demoService.sayHello(msg);
    }

//    @GetMapping("/user/{id}")
//    public Result getUser(@PathVariable("id")Long id){
//        return userServiceApi.getUserById(id);
//    }

    @GetMapping("/address/{id}")
    public Result getAddress(@PathVariable("id")Long id){
        return addressServiceApi.getAddressById(id);
    }
}
