package com.newtower.web.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@SpringBootApplication
@Controller
public class Api {

    public static void main(String[] args) {
        SpringApplication.run(Api.class, args);
    }


    @GetMapping("send")
    public Object send(){
        return SendMsgUtil.send();
    }
}
