package com.example.jdbc.jdbcdemo.api;

import com.alibaba.fastjson.JSON;
import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;
import com.example.jdbc.jdbcdemo.configswtich.ConfigSwitch;
import com.example.jdbc.jdbcdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 配置开关
 *
 * @author liubiao
 */
@RestController
@RequestMapping("userTest")
@Slf4j
public class UserInfoApi {

    @Autowired
    private UserService userService;

//    @RequestMapping("getUserInfoById")
//    public Object getUserInfoById(int userId){
//        List<UserInfo> list  = userService.getAllUser();
//        log.info("getUserInfoById list:{}", JSON.toJSONString(list));
//        return list;
//    }

    @RequestMapping("getAllUser")
    public Object getAllUser() {
        List<UserInfo> list = userService.getAllUser();
        log.info("getAllUser list:{}", JSON.toJSONString(list));
        return list;
    }

    @RequestMapping("changeSqlSwitch")
    public boolean changeSqlSwitch(Boolean sqlSwitch) {
        log.info("changeSqlSwitch sqlSwitch:{}", sqlSwitch);
        if (sqlSwitch != null) {
            ConfigSwitch.sqlSwitch = sqlSwitch;
            return true;
        } else {
            return false;
        }
    }
}
