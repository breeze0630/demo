package com.example.springlearndemo.test.test1;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/21
 */
public class TestMain {

    public static void main(String[] args) {
        User user = new User();
        user.setId("111");
        user.setValid(false);
        user.setActive(true);
        String json = JSON.toJSONString(user);
        System.out.println("json1:" + json);
    }
}
