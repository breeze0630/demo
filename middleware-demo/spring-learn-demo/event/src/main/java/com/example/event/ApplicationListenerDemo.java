package com.example.event;

import org.springframework.context.support.GenericApplicationContext;

/**
 *
 * {@link org.springframework.context.ApplicationListener}
 * @Description
 * @Date: 2020/9/13 18:57
 * @Create by external_ll@163.com
 **/
public class ApplicationListenerDemo {

    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();

        applicationContext.refresh();

        applicationContext.close();
    }
}
