package com.example.jdbc.jdbcdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class SqlConfig {

    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    @Resource
    @Qualifier("dataSource1")
    private DataSource dataSource1;
    @Resource
    @Qualifier("dataSource2")
    private DataSource dataSource2;
    /**
     * 主数据源
     * <p>
     * 如果不添加@Primary注解, MyBatis可以工作，但是JdbcTemplate无法注入
     *    m-bp14z2vanu1hlt59rao.mysql.rds.aliyuncs.com
     *
     *    jdbc:mysql://r/one?useUnicode=true&characterEncoding=utf8
     * @return .
     */
        @Primary
        @Bean(value = "dataSource1")
        public DataSource dataSource() {
            return new HikariDataSource() {{
                setJdbcUrl("jdbc:mysql://rm-bp14z2vanu1hlt59rao.mysql.rds.aliyuncs.com:3306/test_0323?useUnicode=true&characterEncoding=utf8&useSSL=false");
                setUsername("root");
                setPassword("Liub630918");
            }};
        }
        
    /**
     * 副数据源
     *
     * @return .
     */
    @Bean(value = "dataSource2")
    public DataSource dataSourceSecond() {
        return new HikariDataSource() {{
            setJdbcUrl("jdbc:mysql://rm-bp14z2vanu1hlt59rao.mysql.rds.aliyuncs.com:3306/test_1207?useUnicode=true&characterEncoding=utf8&useSSL=false");
            setUsername("root");
            setPassword("Liub630918");
    }};
   }

    /**
     * 主SqlSessionFactory。使用主数据源。自定义SqlSessionFactory后，MyBatis就不自动添加SqlSessionFactory了，所以必须有
     *
     * @return .
     * @throws Exception .
     */
    @Bean(value = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        return new SqlSessionFactoryBean() {{
             setDataSource(dataSource1);
             setMapperLocations(resolver.getResources("classpath:/sqlMap/source1/**.xml"));
        }}.getObject();
    }

    /**
     * 副SqlSessionFactory。使用副数据源
     *
     * @return .
     * @throws Exception .
     */
    @Bean(value = "sqlSessionFactorySecond")
    public SqlSessionFactory sqlSessionFactorySecond() throws Exception {
        return new SqlSessionFactoryBean() {{
            setDataSource(dataSource2);
            setMapperLocations(resolver.getResources("classpath:/sqlMap/source2/**.xml"));
        }}.getObject();
    }
}
