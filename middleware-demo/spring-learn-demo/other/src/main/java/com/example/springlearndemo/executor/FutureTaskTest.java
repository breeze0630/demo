package com.example.springlearndemo.executor;

import java.util.concurrent.*;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/13 21:51
 * @Create by external_ll@163.com
 **/
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(3);

        FutureTask<String> futureTask = new FutureTask<String>(new CallableImpl() );
        // 使用 Executors submit 提交
        exec.submit(futureTask);
        System.out.println(Thread.currentThread().getName());
        String info = futureTask.get();
        System.out.println(info);
    }
}
