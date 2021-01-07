package com.example.springlearndemo.function;

import java.util.Arrays;
import java.util.List;

/**
 * parallelStream 不仅仅会使用ForkJoinPool.commonPool-worker 工作线程执行，还有可能使用父线程（当前线程）执行
 * -Djava.util.concurrent.ForkJoinPool.common.parallelism 设置 ForkJoinPool 的线程池大小
 * */
public class ParalleStreamDemo {

    public static void  streamTest(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        numbers.parallelStream().forEach( num -> {
            System.out.println("第一次请求并行: "+ Thread.currentThread().getName() + " >> " + num);
        });
    }

    public static void streamTest2(){
        List<Integer> numbers = Arrays.asList(11,21,31,41,51,61,71,81,91);
        numbers.parallelStream().forEach( num -> {
            System.out.println("第二次请求并行: "+ Thread.currentThread().getName() + " >> " + num);
        });
    }

    public static void main(String[] args) {
        Thread thread1= new Thread( ()->{
            streamTest();
        });

        Thread thread2= new Thread( ()->{
            streamTest2();
        });

        thread1.start();
        thread2.start();

/*        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
