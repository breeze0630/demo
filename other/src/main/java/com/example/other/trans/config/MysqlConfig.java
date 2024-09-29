package com.example.other.trans.config;

import net.sf.jsqlparser.util.validation.feature.DatabaseType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MysqlConfig {
//
//    @Bean(name = "jdbcTemplate")
//    public JdbcTemplate jdbcTemplate(
//            @Qualifier("dataSource") DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.setDatabaseProductName(DatabaseType.MYSQL.name());
//        return jdbcTemplate;
//    }
}
