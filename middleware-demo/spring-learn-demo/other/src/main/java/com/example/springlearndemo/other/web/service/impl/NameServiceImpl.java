package com.example.springlearndemo.other.web.service.impl;

import com.example.springlearndemo.other.web.service.NameService;
import lombok.extern.slf4j.Slf4j;

/**
 * 首先通过注解注入Bean
 * */
//@Service
@Slf4j
public class NameServiceImpl implements NameService {

    @Override
    public void printInfo() {

        log.info("NameService.printInfo : 打印信息");

    }
}
