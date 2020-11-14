package com.example.modeldemo.service.impl;

import com.example.modeldemo.service.OutputService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("outputService3Impl")
@Slf4j
public class OutputService3Impl implements OutputService {
    /**
     * 输出内容
     *
     * @param info
     */
    @Override
    public void outputInfo(String info) {
        log.info("info:{}",info);
    }
}
