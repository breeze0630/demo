package com.example.mybatisplusexample;

import com.alibaba.fastjson.JSON;
import com.example.mybatisplusexample.db.UserDao;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
class MybatisPlusExampleApplicationTests {


    @Autowired
    private UserDao userDao;
    @Test
    void contextLoads() {
        System.out.println((JSON.toJSONString(userDao.getUser())));
    }

}
