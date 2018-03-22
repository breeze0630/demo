package com.example.demo.core;

import com.example.demo.core.interceptor.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018/3/21.
 */
@Configuration
public class SessionConfiguration extends WebMvcConfigurerAdapter
{

	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
	}
}
