package com.example.other.trans.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class ConfigBean {

    /**
     * 默认的处理类，这里要手动实现，是因为springboot的配置中添加了排他属性，自定义objectMapper 使得springboot 配置不生效
     * @param jackson2ObjectMapperBuilderCustomizer
     * @param jackson2ObjectMapperBuilder
     * @return
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer,
    Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder
                                     ) {
        jackson2ObjectMapperBuilderCustomizer.customize(jackson2ObjectMapperBuilder);
        return jackson2ObjectMapperBuilder.build();
    }

    @Bean
    public ObjectMapper responseParse(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

}
