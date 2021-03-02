package com.example.springlearndemo.aop.overview;

import java.lang.reflect.Method;

/**
 * 后置拦截器
 * */
public interface AfterInterceptor {

    Object after(Object proxy, Method method, Object[] args,Object afterReturn);
}
