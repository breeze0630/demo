package com.breeze.sample.elasticsearchdemoparent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther: liubiao
 * @date: 2025-02-18
 */
@Slf4j
public class TestReentrantLock {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();


        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("线程1开始执行");
                lock.lock();
                log.info("线程1执行...");
                try {
                    lock.lock();
                    log.info("线程1 重入1次...");
                    Thread.sleep(5000);
                    lock.unlock();
                    log.info("线程1释放1次重入锁");


                    Thread.sleep(10000);
                    lock.unlock();
                    log.info("线程1释放2次重入锁");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("线程2开始执行");
                lock.lock();
                log.info("线程2执行...");
            }
        }).start();

    }
}
