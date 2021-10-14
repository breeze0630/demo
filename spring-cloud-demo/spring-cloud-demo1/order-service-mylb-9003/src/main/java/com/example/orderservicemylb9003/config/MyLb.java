package com.example.orderservicemylb9003.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
public class MyLb implements MyLoadBalancerClient {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public int getIndex(){
        int current = 0;
        int next = 0;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        log.info("*************第几次访问，次数:{}",next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> list) {
        int index = getIndex();
        if(CollectionUtils.isEmpty(list))
        {
            return null;
        }
        return list.get(index % list.size());
    }
}
