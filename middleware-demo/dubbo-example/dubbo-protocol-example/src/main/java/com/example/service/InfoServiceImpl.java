package com.example.service;

import com.alibaba.fastjson.JSON;
import com.example.domain.api.InfoDTO;
import com.example.domain.api.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
@Slf4j
public class InfoServiceImpl implements InfoService {


    @Override
    public String get(String msg)  {
        log.info("get method is ok.");
/*        try {
            Thread.sleep(10000);
        }catch (Exception e){
            log.error("e:{}",e);
        }*/
        return "ok:" + msg;
    }

    @Override
    public String set(){
        log.info("set method is ok.");
/*        try {
            Thread.sleep(10000);
        }catch (Exception e){
            log.error("e:{}",e);
        }*/
        return "set ok.";
    }

    @Override
    public String add(InfoDTO infoDTO) {
        log.info("info:{}", JSON.toJSONString(infoDTO));
        String result = "add method is ok.";
        log.info(result);
        return result;
    }
}
