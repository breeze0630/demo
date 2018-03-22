package com.example.demo.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018/3/22.
 */
@Configuration
public class StaticFileConfiguration extends WebMvcConfigurerAdapter
{
	@Override public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/file/img/**").addResourceLocations("classpath:/static/");
	}
}
