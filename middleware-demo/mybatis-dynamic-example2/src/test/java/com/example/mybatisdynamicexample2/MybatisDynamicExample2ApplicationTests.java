package com.example.mybatisdynamicexample2;

import com.example.mybatisdynamicexample2.domain.User;
import com.example.mybatisdynamicexample2.domain.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
class MybatisDynamicExample2ApplicationTests {


    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void selectById(){
        log.info("user:{}",userService.selectById(1));
    }

    @Test
    void updateById(){
        User user = userService.selectById(1);
        user.setUserName("李四");
        user.setAge(20);
        log.info("row:{}",userService.updateById(user));
    }
}
