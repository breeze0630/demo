package com.demo.sharding.sphere.demo.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.ttl.TtlRunnable;
import com.demo.sharding.sphere.demo.config.SecurityContextHolder;
import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.service.OrderService;
import com.demo.sharding.sphere.demo.vo.OrderVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @auther: liubiao
 * @date: 2024-11-22
 */
@RestController
@AllArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("saveOne")
    public Object saveOne(@RequestBody Order order){
      return  orderService.saveOne(order);
    }

    @GetMapping("getList")
    public Object getList(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");



        new ForkJoinPool(3).submit(()->{
            list.parallelStream().forEach(item->{
                log.info(Thread.currentThread().getName()+":"+item+": "+ SecurityContextHolder.get2());
            });
        });


        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(()->{log.info(Thread.currentThread().getName()+": "+ SecurityContextHolder.get2());});

        try {
            Thread.sleep(4000);
        }catch (Exception e){

        }
        log.info(Thread.currentThread().getName()+":修改前"+": "+ SecurityContextHolder.get2());
        List<OrderVo> data  =  orderService.getList();
        SecurityContextHolder.set2(IdUtil.fastSimpleUUID());
        log.info(Thread.currentThread().getName()+":已修改"+": "+ SecurityContextHolder.get2());
        List<OrderVo> data2  =  orderService.getList();

        return data;
    }

    @GetMapping("getList2")
    public Object getList2(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        ForkJoinPool forkJoinPool = new ForkJoinPool(3);
        log.info(Thread.currentThread().getName()+":修改前"+": "+ SecurityContextHolder.get2());

        CountDownLatch countDownLatch = new CountDownLatch(3);
        forkJoinPool.submit(TtlRunnable.get(()->{
            list.parallelStream().forEach(item->{
                log.info(Thread.currentThread().getName()+":"+item+": "+ SecurityContextHolder.get2());
                countDownLatch.countDown();
            });
        }));
        try {
//            forkJoinPool.awaitQuiescence(10, TimeUnit.SECONDS);
            countDownLatch.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SecurityContextHolder.set2(IdUtil.fastSimpleUUID());
        log.info(Thread.currentThread().getName()+":已修改"+": "+ SecurityContextHolder.get2());

        forkJoinPool.submit(TtlRunnable.get(()->{
            list.parallelStream().forEach(item->{
                log.info(Thread.currentThread().getName()+":"+item+": "+ SecurityContextHolder.get2());
            });
        }));
        return null;
    }
}
