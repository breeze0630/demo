package com.example.springlearndemo.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/13 21:53
 * @Create by external_ll@163.com
 **/
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService exec = Executors.newFixedThreadPool(3);
        Future<String> future = exec.submit(new CallableImpl());
        System.out.println("call 3");
        System.out.println(future.get());
        System.out.println("call 4");
    }
}
