package com.demo.sharding.sphere.demo.service.impl;

import cn.hutool.core.util.IdUtil;
import com.alibaba.ttl.TtlRunnable;
import com.demo.sharding.sphere.demo.config.SecurityContextHolder;
import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.mapper.OrderMapper;
import com.demo.sharding.sphere.demo.service.ExampleService;
import com.demo.sharding.sphere.demo.service.OrderService;
import com.demo.sharding.sphere.demo.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * @auther: liubiao
 * @date: 2024-11-22
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


    private final ForkJoinPool forkJoinPool = new ForkJoinPool(3);

    @Resource
    private  OrderMapper orderMapper;

    @Override
    public int saveOne(Order order) {
        return orderMapper.insertOne(order);
    }
    @Async("threadPoolTaskExecutor")
    @Override
    public List<OrderVo> getList() {
        log.info(Thread.currentThread().getName()+": "+ SecurityContextHolder.get2());
        getList2();
        return orderMapper.getOrderList();
    }
    public Object getList2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");


        forkJoinPool.submit(TtlRunnable.get(()->{
            list.parallelStream().forEach(item->{
                log.info(Thread.currentThread().getName()+":"+item+": "+ SecurityContextHolder.get2());
            });
        }));
        return null;
    }
    @Override
    public int batchSaveOrder(List<Order> orderList) {

//        orderMapper.insertOne(orderList.get(0));

        return 0;
    }
}
