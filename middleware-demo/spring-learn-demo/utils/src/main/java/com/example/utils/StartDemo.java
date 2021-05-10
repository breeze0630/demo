package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.example.utils.bean.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class StartDemo {
    public static void main(String[] args) {
        Map<String,Object> sourceMap = new HashMap<String,Object>(){
            {
                put("name","张三");
                put("age","11");
                put("address","楼上");
            }
        };

        UserDTO userDTO = new UserDTO();
        BeanUtils.mapToBean(sourceMap,userDTO);
        System.out.println(JSON.toJSONString(userDTO));
    }
}
