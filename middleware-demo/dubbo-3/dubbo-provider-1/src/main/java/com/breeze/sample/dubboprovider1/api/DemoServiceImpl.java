package com.breeze.sample.dubboprovider1.api;

import com.alibaba.fastjson2.JSONObject;
import com.breeze.sample.dubbosampleapi.api.DemoService;
import com.breeze.sample.dubbosampleapi.dto.DemoSaveDto;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @auther: liubiao
 * @date: 2024-10-25
 */
@DubboService
public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {

        System.out.println(name);
        return "hello " + name;
    }

    public String save(DemoSaveDto req) {
        System.out.println(JSONObject.toJSONString(req));
        return "OK";
    }
}
