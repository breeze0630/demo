package com.example.configuration;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * @auther: liubiao
 * @date: 2025-03-10
 */
@Slf4j
@Configuration
public class EventConfig implements ApplicationListener<RequestHandledEvent> {


    /**
     * HTTP 请求处理完毕时（需 Spring MVC 环境）
     * @param event
     */
    @Override
    public void onApplicationEvent(RequestHandledEvent event) {
        log.info("http请求处理完毕...:{}", JSON.toJSONString(event));
    }
}
