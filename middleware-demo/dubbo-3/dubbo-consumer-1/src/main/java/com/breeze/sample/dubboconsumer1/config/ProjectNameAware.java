package com.breeze.sample.dubboconsumer1.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @auther: liubiao
 * @date: 2024-10-29
 */
@Configuration
public class ProjectNameAware implements EnvironmentAware {

    @Value("${spring.application.name:unknow}")
    private String projectName;
    @Override
    public void setEnvironment(Environment environment) {

        if(StringUtils.isBlank(System.getProperty("project.name"))){
            System.setProperty("project.name",projectName);
        }
    }
}
