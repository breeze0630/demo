package com.example.jdbc.jdbcdemo.api;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/14 22:33
 * @Create by external_ll@163.com
 **/
@RestController("exception2")
public class ExceptionController2 {

    @RequestMapping("noSuchBean")
    public Object testNoSuchBeanException(){
        throw new NoSuchBeanDefinitionException("");
    }
}
