package com.example.springlearndemo.aop.overview;

import java.lang.reflect.Method;

/**
 * 最终执行拦截器
 * */
public interface FinallyInterceptor {

    Object finalize(Object proxy, Method method, Object[] args,Object afterReturn);
}
