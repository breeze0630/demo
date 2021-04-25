package com.example.jdbc.jdbcdemo.api;

import com.alibaba.fastjson.JSON;
import com.example.jdbc.jdbcdemo.anno.MyAutowired;
import com.example.jdbc.jdbcdemo.biz.bean.Info;
import com.example.jdbc.jdbcdemo.biz.bean.UserInfo;
import com.example.jdbc.jdbcdemo.configswtich.ConfigSwitch;
import com.example.jdbc.jdbcdemo.proxy.UserInvokerHandler;
import com.example.jdbc.jdbcdemo.service.UserService;
import com.example.jdbc.jdbcdemo.service.impl.UserServiceImpl;
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

    @MyAutowired
    private UserService userService;

//    @RequestMapping("getUserInfoById")
//    public Object getUserInfoById(int userId){
//        List<UserInfo> list  = userService.getAllUser();
//        log.info("getUserInfoById list:{}", JSON.toJSONString(list));
//        return list;
//    }

    @RequestMapping(path = {"getAllUser","getAllUser1"})
    public Object getAllUser() {
        UserInvokerHandler myJDKProxy = new UserInvokerHandler();

        Object obj = myJDKProxy.getProxy(userService);
        UserService userService1 = (UserService)obj;

        List<UserInfo> list = userService1.getAllUser();

        log.info("getAllUser list:{}", JSON.toJSONString(list));
        return list;
    }


    @RequestMapping(path = {"deleteUser","getAllUser1"})
    public void deleteUser(String name) {
        userService.deleteUser(name);
    }
    @RequestMapping("getUserByName")
    public Object getUserByName(String name) {
        List<UserInfo> list = userService.selectByName( name );
        log.info("getUserByName list:{}", JSON.toJSONString(list));
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
