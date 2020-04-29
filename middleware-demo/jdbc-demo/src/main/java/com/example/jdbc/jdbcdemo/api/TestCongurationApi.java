package com.example.jdbc.jdbcdemo.api;

import com.example.jdbc.jdbcdemo.config.MyConguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
public class TestCongurationApi {


//    @Autowired
    private MyConguration myConguration;

    @RequestMapping("/getConfig")
    public String getConfig(String name){
        return MyConguration.name;
    }


}
