package com.example.jdbc.jdbcdemo.listener;

import com.alibaba.fastjson.JSON;
import com.example.jdbc.jdbcdemo.biz.dto.PushStringEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PushStringEventListener
//        implements ApplicationListener<PushStringEvent>
{
    @EventListener
    public void onApplicationEvent(PushStringEvent pushStringEvent) {
        log.info("pushStringEvent:{}", JSON.toJSONString(pushStringEvent));
    }
}
