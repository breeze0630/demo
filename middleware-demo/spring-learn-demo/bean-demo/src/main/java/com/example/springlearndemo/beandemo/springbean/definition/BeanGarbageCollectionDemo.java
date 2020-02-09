package com.example.springlearndemo.beandemo.springbean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author liubiao
 *
 * Bean GC 垃圾回收示例
 *
 *
 */
//@Configuration
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        applicationContext.close();
        System.gc();
    }
}
