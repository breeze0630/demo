package com.example.springlearndemo.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试Callable 接口 ，ExecutorService.submit 提交线程对象, Future<T> 英语接收返回数据, Future.get() 获取最终线程数据
 * @Description 线程相关测试
 * @Date: 2020/5/13 20:11
 * @Create by external_ll@163.com
 **/
public class ScheduledThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试时间 :" +  System.currentTimeMillis());
            }
        },1,5, TimeUnit.SECONDS);
    }
}

