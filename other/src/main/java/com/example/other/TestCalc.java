package com.example.other;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther: liubiao
 * @date: 2025-03-03
 */
public class TestCalc {

    public static void main(String[] args) {
        ConcurrentSkipListSet<String> set = new ConcurrentSkipListSet<>();
        set.add("姓名");
        set.add("年龄");
        set.add("性别");

        System.out.println(JSON.toJSONString(set));
        System.out.println(JSON.toJSONString(set));
        System.out.println(JSON.toJSONString(set));
        System.out.println(JSON.toJSONString(set));
        System.out.println(JSON.toJSONString(set));
        System.out.println(JSON.toJSONString(set));

    }
}
