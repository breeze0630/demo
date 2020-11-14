package com.example.springlearndemo.test;

public class ComsumerQueueTest {

    public static void main(String[] args) {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        int i = 1;
                        int result = QueueTest.blockingQueue.take();
                        System.out.println("输出消费者ComsumerQueueTest1 第" + i + " 个数：" + result);
                        i++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
         new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        int i = 1;
                        int result = QueueTest.blockingQueue.take();
                        System.out.println("输出消费者ComsumerQueueTest1 第" + i + " 个数：" + result);
                        i++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
//        thread.start();
    }
}
