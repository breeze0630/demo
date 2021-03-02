package com.example.springlearndemo.aop.overview;

import java.lang.reflect.Method;

public interface ExceptionInterceptor {

    /**
     *
     * @param proxy
     * @param method
     * @param args
     * @param throwable
     */
    void intercept(Object proxy, Method method, Object[] args, Throwable throwable);
}
