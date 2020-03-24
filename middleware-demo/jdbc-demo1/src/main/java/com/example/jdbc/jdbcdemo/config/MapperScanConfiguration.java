package com.example.jdbc.jdbcdemo.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置开关
 *
 * @author liubiao
 */
@MapperScan(value = "com.example.jdbc.jdbcdemo.biz.mapper.**", annotationClass = Mapper.class, sqlSessionFactoryRef = "sqlSessionFactory")
@Configuration
public class MapperScanConfiguration {
}
