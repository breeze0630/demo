package com.example.springboot.autoconfig.web.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.example.springboot.autoconfig.web.demo"})
public class SpringWebMvcConfiguration {

}
