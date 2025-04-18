package com.breeze.sample.aidemo.config;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import io.reactivex.Flowable;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.PrintWriter;

/**
 * @auther: liubiao
 * @date: 2025-04-18
 */
@Controller
@Slf4j
@RequestMapping("ai2")
public class AiStreamController {

    @Resource
    AiConfig aiConfig;

    /**
     * 调用模型的流式返回
     * @param request
     * @param response
     * @param message
     * @throws NoApiKeyException
     * @throws InputRequiredException
     */
    @GetMapping("send")
    public void send(HttpServletRequest request, HttpServletResponse response, @RequestParam("message")String message) throws NoApiKeyException, InputRequiredException {
        Generation gen = new Generation();
        Message userMsg = Message.builder().role(Role.USER.getValue()).content(message).build();

        GenerationParam param = aiConfig.buildGenerationParam(userMsg);
        Flowable<GenerationResult> result = gen.streamCall(param);
        result.blockingForEach(k -> handleGenerationResult(k,response));
    }

    /**
     * 调用应用的流式返回
     * @param request
     * @param response
     * @param message
     * @throws NoApiKeyException
     * @throws InputRequiredException
     */
    @GetMapping("sendStream")
    public void sendStream(HttpServletRequest request, HttpServletResponse response, @RequestParam("message")String message) throws NoApiKeyException, InputRequiredException {


        ApplicationParam craateApplicationParam = aiConfig.craateApplicationParamForLiushi(message);
        Application application = new Application("https://dashscope.aliyuncs.com/api/v1/");
        Flowable<ApplicationResult> result = application.streamCall(craateApplicationParam);

        result.blockingForEach(k -> handleGenerationResult2(k,response));

    }

    public void handleGenerationResult2(ApplicationResult  message,HttpServletResponse response){
        String content = message.getOutput().getText();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        try {

            PrintWriter writer = response.getWriter();
            writer.println(content);
            writer.flush(); // 确保数据被发送到客户端
        }catch ( Exception e){
            log.error("e:{}",e);
        }

    }
    public void handleGenerationResult(GenerationResult  message,HttpServletResponse response){
        String content = message.getOutput().getChoices().get(0).getMessage().getContent();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");

        try {

            PrintWriter writer = response.getWriter();
                writer.println(content);
                writer.flush(); // 确保数据被发送到客户端
        }catch ( Exception e){
            log.error("e:{}",e);
        }

    }
}
