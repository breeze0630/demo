package com.example.springlearndemo.executor;

import java.util.concurrent.Callable;

/**
 * 以Callable 创建线程,需要重写call()方法
 * @Description TODO
 * @Date: 2020/5/13 21:52
 * @Create by external_ll@163.com
 **/
public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("call 1");
        Thread.sleep(5000);
        System.out.println("call 2");

        return "call info";
    }
}
