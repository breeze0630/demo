package com.example.jdbc.jdbcdemo.api;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Description 测试Exception的全局处理和局部处理
 * 当 {@link ExceptionHandler} 所在的类上未标注  {@link ControllerAdvice} 注解，那么此次配置的 ExceptionHandler 只能在当前类中生效
 * @Date: 2020/5/14 22:17
 * @Create by external_ll@163.com
 **/
@RestController
//@ControllerAdvice
public class ExceptionController  {

    @RequestMapping("null")
    public Object testNull(){
        throw new NullPointerException();
    }


    @RequestMapping("testNoSuchBean")
    public Object testNoSuchBeanDefinitionException(){
        throw new NoSuchBeanDefinitionException("");
    }

    @ExceptionHandler(value = NoSuchBeanDefinitionException.class)
//    @ResponseBody
    public String  noSuchBeanDefinitionException(){
        return "noSuchBeanDefinitionException!!!";
    }
}
