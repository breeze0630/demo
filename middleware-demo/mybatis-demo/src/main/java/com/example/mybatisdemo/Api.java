package com.example.mybatisdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api
{
    @GetMapping("success")
    public Object success(){
        return "success";
    }

    @GetMapping("fail")
    public Object fail(){
        throw new RuntimeException("fail");
    }
}
