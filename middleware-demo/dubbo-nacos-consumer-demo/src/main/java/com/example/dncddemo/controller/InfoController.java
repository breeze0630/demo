package com.example.dncddemo.controller;

import com.example.dndemo.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@Slf4j
public class InfoController {

    @Reference(async = true,timeout = 60000)
    InfoService infoService;

    @RequestMapping("printInfo")
    public String printInfo(String info){
        
        AtomicReference<String> result = new AtomicReference<>(infoService.printInfo(info));
       log.info("result:{}",result);
        CompletableFuture<String> future = RpcContext.getContext().getCompletableFuture();
        log.info("process ...1...");

        CountDownLatch latch = new CountDownLatch(1);
        future.whenComplete((v,t)->{
            if(t != null){
                log.error("异常：{}",t);
            }else {
                result.set((String) v);
                log.info("CompletableFuture<String> future.result:{}",v);
            }
            latch.countDown();
        });

        log.info("process ...2...");

        log.info("last.result:{}",result);

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.get();
    }
}
