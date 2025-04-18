package com.breeze.sample.aidemo.config;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2025-04-18
 */

@RestController
@RequestMapping("ai")
public class AController {

    @Resource
    private AiConfig aiConfig;

    /**
     * 这是调用模型的文本对话
     * @param message
     * @return
     */
    @GetMapping("send")
    public Object send(@RequestParam("message")String message){
        return aiConfig.send(message);
    }

    /**
     * 调用智能应用体的文本对话
     * @param message
     * @return
     */
    @GetMapping("send2")
    public Object send2(@RequestParam("message")String message){
        return aiConfig.send2(message);
    }
}
