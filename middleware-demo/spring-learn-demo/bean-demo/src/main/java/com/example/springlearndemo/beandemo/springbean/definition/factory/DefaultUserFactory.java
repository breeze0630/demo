package com.example.springlearndemo.beandemo.springbean.definition.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author liubiao
 */
public class DefaultUserFactory implements UserFactory , InitializingBean , DisposableBean {

    /**
     * 注解标注此方法，会在对象初始化时，调用此方法
     * */
    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct 调用 ：初始化中......");
    }

    /**
     * 自定义的初始化方法
     * */
    public  void initMethod(){
        System.out.println("initMethod 调用 ： 初始化中 ......");
    }



    /**
     * 实现 InitializingBean，初始化数据时，设置参数后会回调此方法
     * */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet 调用 ： 初始化中 ......");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("@PreDestroy 调用 ：对象销毁......");
    }


    /**
     * 实现 DisposableBean
     * 对象销毁时，会回调此方法
     *
     * */
    @Override
    public void destroy() throws Exception {
        System.out.println("@destroy 回调 ：对象销毁......");

    }

    public void doDestroy(){
        System.out.println("自定义方法 doDestroy 回调 ：对象销毁......");
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory 对象正在被垃圾回收...");
    }

}
