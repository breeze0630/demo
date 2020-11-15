package com.example.dndemo.service.impl;

import com.example.dndemo.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Service
@Slf4j
public class InfoServiceImpl implements InfoService {

    @Override
    public String printInfo(String info){
        String  returnInfo = "returnInfo:"+info;
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            log.error("e:{}",e);
        }
        log.info(returnInfo);
        return returnInfo;
    }
}
