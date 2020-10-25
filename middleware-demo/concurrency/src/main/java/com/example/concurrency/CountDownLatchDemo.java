package com.example.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        test();

    }

    private static void test() throws InterruptedException {

        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for(int i = 0 ; i < threadCount; i++){
            Thread thread = new Thread(new ThreadTest("name-"+i,latch));
            thread.start();
        }
        latch.wait();

        System.out.println(Thread.currentThread().getName());
    }

   static class ThreadTest implements Runnable{
        private String name;

        private CountDownLatch latch;
        public ThreadTest(String name,CountDownLatch latch) {
            this.name = name;
            this.latch = latch;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            latch.countDown();
        }
    }
}
