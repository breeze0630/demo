package com.example.springlearndemo.executor;

import java.util.concurrent.Callable;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/13 21:52
 * @Create by external_ll@163.com
 **/
public class CallableImpl implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call 1");
        Thread.sleep(5000);
        System.out.println("call 2");

        return "call info";
    }
}
