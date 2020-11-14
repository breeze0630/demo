package com.example.dndemo.service.impl;

import com.example.dndemo.service.InfoService2;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Service
@Slf4j
public class InfoService2Impl implements InfoService2 {
    @Override
    public String printInfo(String info) {
        String returnInfo = "returnInfo:"+info;
        log.info(returnInfo);
        return returnInfo;
    }
}
