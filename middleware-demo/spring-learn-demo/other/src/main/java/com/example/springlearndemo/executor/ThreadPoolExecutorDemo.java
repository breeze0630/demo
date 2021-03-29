package com.example.springlearndemo.executor;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorDemo {
    static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,1000L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10),new MyThreadFactory());
    static  ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(2,5,1000L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(10),new MyThreadFactory());

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        int i = 0;
        while(i++ < 6) {
            threadPoolExecutor.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "在执行中...");
            }));
        }
        i = 0;
        while(i++ < 6) {
            threadPoolExecutor2.execute(new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "在执行中...");
            }));
        }
    }
}

class MyThreadFactory implements ThreadFactory{
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    public MyThreadFactory(){
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        namePrefix = "pool-" +
                poolNumber.getAndIncrement() +
                "-myThread-";
    }
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}
