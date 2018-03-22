package com.example.demo.core;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2018/3/19.
 */
@Configuration
public class DruidConfiguration
{
	@Bean
	public ServletRegistrationBean statViewSerlvet()
	{
		//创建serlvet注册实体
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid");

		//设置ip白名单
		servletRegistrationBean.addInitParameter("allow","127.0.0.1");

		//设置IP黑名单，如果allow和deny同时存在，deny优先于allow
		servletRegistrationBean.addInitParameter("deny","192.168.0.185");
		//设置控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername","druid");
		servletRegistrationBean.addInitParameter("loginPassword","123456");
		//是否可以重置数据
		servletRegistrationBean.addInitParameter("resetEnable","false");
		return  servletRegistrationBean;
	}

	public FilterRegistrationBean statFilter()
	{
		//创建过滤器
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		//设置过滤器路径
		filterRegistrationBean.addUrlPatterns("/*");
		//忽略过滤器的形式
		filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
