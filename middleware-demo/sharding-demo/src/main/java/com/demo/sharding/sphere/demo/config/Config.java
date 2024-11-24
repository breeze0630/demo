package com.demo.sharding.sphere.demo.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @auther: liubiao
 * @date: 2024-11-23
 */
@Configuration
public class Config {

    @Autowired
    private MybatisPlusProperties mybatisPlusProperties;
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean() ;
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setMapperLocations(mybatisPlusProperties.resolveMapperLocations());
//        return sqlSessionFactory.getObject();
//    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
