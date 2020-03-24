package com.example.springlearndemo.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,0L, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10));
        int index = 0;
        while (index<30){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.printf("index : \n" );

                    try {
                        Thread.currentThread().sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            index++;
        }
        System.out.println("aaaa");
    }

}
