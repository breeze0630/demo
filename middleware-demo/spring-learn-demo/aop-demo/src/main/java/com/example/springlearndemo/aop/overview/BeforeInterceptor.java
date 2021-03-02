package com.example.springlearndemo.aop.overview;

import java.lang.reflect.Method;

/**
 * 前置拦截器
 * */
public interface BeforeInterceptor {

    Object before(Object proxy, Method method, Object[] args);
}
