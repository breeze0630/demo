package com.example.demo.core;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter
{
	/**
	 * 修改自定义消息转换器
	 * @Param converters 消息转换器列表
	 * */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
	{
		//调用父类的配置
		super.configureMessageConverters(converters);
		//创建fastjson消息转换器
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		//创建配置类
		FastJsonConfig fastJsonConfig = new FastJsonConfig();

		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty
		);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		converters.add(fastConverter);
	}
}
