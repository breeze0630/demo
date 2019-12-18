package com.example.jdbc.jdbcdemo.config;

import com.example.jdbc.jdbcdemo.anno.SecondaryMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.example.jdbc.jdbcdemo.biz.mapper2.**",annotationClass = SecondaryMapper.class,sqlSessionFactoryRef = "sqlSessionFactorySecond")
public class SecondaryMapperScanConfiguration {
}
