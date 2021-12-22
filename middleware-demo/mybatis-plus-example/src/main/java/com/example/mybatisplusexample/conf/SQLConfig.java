package com.example.mybatisplusexample.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ImportResource(locations = {"classpath*:mybatis.xml","classpath*:mybatis-plugin-config.xml"})
@ImportResource(locations = {"mybatis.xml","mybatis-plugin-config.xml"})
public class SQLConfig {
}
