package com.example.jdbc.jdbcdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/14 22:14
 * @Create by external_ll@163.com
 **/
@ControllerAdvice
public class ExceptionExternalHandler {

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public String nullPointException(NullPointerException e){
        return "空指针异常!!!";
    }
}
