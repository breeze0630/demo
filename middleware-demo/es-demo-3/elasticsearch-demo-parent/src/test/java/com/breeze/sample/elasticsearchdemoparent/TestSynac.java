package com.breeze.sample.elasticsearchdemoparent;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther: liubiao
 * @date: 2025-02-25
 */
@Slf4j
public class TestSynac {

    public static void main(String[] args) {

        new TestSynac().process();
    }

    public void process(){
        TestBean bean = new TestBean();
        synchronized (bean){
         log.info("对bean上锁完成");

         synchronized (bean){
             log.info("对bean二次上锁完成");
         }
        }
    }

    @Data
    class TestBean{
        private int id;
    }
}
