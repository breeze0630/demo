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
        String json = JSON.toJSON(user).toString();
        System.out.println("json1:" + json);

        String ss = "{\"valid\":false,\"isActive\":true,\"id\":\"111\"}";
        User user1 = JSON.parseObject(ss,User.class);
        System.out.println(user1);
    }
}
