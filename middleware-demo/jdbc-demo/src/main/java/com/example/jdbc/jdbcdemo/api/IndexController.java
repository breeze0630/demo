package com.example.jdbc.jdbcdemo.api;

import com.example.jdbc.jdbcdemo.anno.MyAutowired;
import com.example.jdbc.jdbcdemo.biz.bean.Info;
import com.example.jdbc.jdbcdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class IndexController {
    @Autowired
    private UserService userService;
    @RequestMapping("index")
    public String index(String info){
        log.info("info:{}",info);
        Info info1 = new Info();
        info1.setName(info);
        userService.insert(info1);
        return "success";
    }

}
