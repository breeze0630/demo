package com.example.springlearndemo.test;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueTest {

    // 设置队列长度
    public static  volatile LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue(100);
    public static void main(String[] args)  {

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    while (true) {
//                        int i = 1;
//                        int result = QueueTest.blockingQueue.take();
//                        System.out.println("输出消费者ComsumerQueueTest1 第" + i + " 个数：" + result);
//                        i++;
//                    }
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        Random random = new Random();
        int i = 0;
        while (true) {
            int num = random.nextInt(101);
            try {
                // offset 和 put 都是入栈，offset : 入栈时如果队列中已满，则返回失败，线程不等待，继续执行
                // put 入栈时如果队列中已满，线程等待，直到队列有空余才继续执行
                blockingQueue.offer(num);
                System.out.println("第"+(i+1)+"个数:"+num);
                i++;
                if(i == 1000){
                    System.out.println("i");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
