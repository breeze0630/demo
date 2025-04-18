package com.breeze.sample.aidemo.config;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationParam;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.Role;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @auther: liubiao
 * @date: 2025-04-18
 */
@Service
@Slf4j
public class AiConfig {

    @Value("${ai.key}")
    private String aiKey ;

    @Value("${ai.appId}")
    private String aiAppId;

    List<Message> messages = new ArrayList<>();


    @PostConstruct
    public void init(){
        messages.add(createMessage(Role.SYSTEM, "You are a helpful assistant."));

    }



    public GenerationParam createGenerationParam(List<Message> msg) {
        return GenerationParam.builder()
                // 若没有配置环境变量，请用百炼API Key将下行替换为：.apiKey("sk-xxx")
                .apiKey(aiKey)
                // 模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
                .model("qwen-turbo-0624")
                .messages(msg)
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .build();
    }

    public ApplicationParam craateApplicationParam(String message){
        ApplicationParam param = ApplicationParam.builder()
                // 若没有配置环境变量，可用百炼API Key将下行替换为：.apiKey("sk-xxx")。但不建议在生产环境中直接将API Key硬编码到代码中，以减少API Key泄露风险。
                .apiKey(aiKey)
                .appId(aiAppId)
                .prompt(message)
                .build();
        return param;
    }

    public ApplicationParam craateApplicationParamForLiushi(String message){
        ApplicationParam param = ApplicationParam.builder()
                // 若没有配置环境变量，可用百炼API Key将下行替换为：.apiKey("sk-xxx")。但不建议在生产环境中直接将API Key硬编码到代码中，以减少API Key泄露风险。
                .apiKey(aiKey)
                .appId(aiAppId)
                .prompt(message)
                .incrementalOutput(true)
                .build();
        return param;
    }

    private  Message createMessage(Role role, String content) {
        return Message.builder().role(role.getValue()).content(content).build();
    }

    public  GenerationResult callGenerationWithMessages(GenerationParam param) {
        Generation gen = new Generation();
        try {
            return gen.call(param);
        }catch (Exception e){
            log.error("e:{}",e);
        }
        return null;
    }

    public Object send(String message) {
        messages.add(createMessage(Role.USER, message));
        GenerationParam param = createGenerationParam(messages);
        GenerationResult result = callGenerationWithMessages(param);
        String res = result.getOutput().getChoices().get(0).getMessage().getContent();
        log.info("模型输出:{}",res);

        return res;
//        messages.add(result.getOutput().getChoices().get(0).getMessage());
    }

    public String send2(String message){

        try {
            ApplicationParam craateApplicationParam = craateApplicationParam(message);
            Application application = new Application("https://dashscope.aliyuncs.com/api/v1/");
            ApplicationResult result = application.call(craateApplicationParam);

            String res = result.getOutput().getText();
            log.info("send2.res:{}",res);
            return res;
        }catch ( Exception e){
            log.error("e:{}",e);
        }

        return null;

    }






    public GenerationParam buildGenerationParam(Message userMsg) {
        return GenerationParam.builder()
                // 若没有配置环境变量，请用百炼API Key将下行替换为：.apiKey("sk-xxx")
                .apiKey(aiKey)
                .model("qwen-turbo-0624")   // 此处以qwen-plus为例，您可按需更换模型名称。模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
                .messages(Arrays.asList(userMsg))
                .resultFormat(GenerationParam.ResultFormat.MESSAGE)
                .incrementalOutput(true)
                .build();
    }
}
