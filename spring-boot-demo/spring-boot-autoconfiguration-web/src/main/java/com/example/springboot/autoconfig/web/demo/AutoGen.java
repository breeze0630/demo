package com.example.springboot.autoconfig.web.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


public class AutoGen {

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        //全局配置
        mpg.setGlobalConfig(globalConfig());
        //数据源
        mpg.setDataSource(dataSourceConfig());
        //包
        mpg.setPackageInfo(packageConfig());
        //策略
        mpg.setStrategy(strategyConfig());
        mpg.execute();

    }

    private static GlobalConfig globalConfig(){
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "/Users/liubiao/Documents/code/demo/demo/spring-boot-demo/spring-boot-autoconfiguration-web" ;
//                System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("liu");
        gc.setOpen(false);
        gc.setFileOverride(true);
        // 开启 activeRecord 模式
        gc.setActiveRecord(true);


        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        config.setXmlName("%sDao");
//        config.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        return gc;
    }

    private static DataSourceConfig dataSourceConfig(){
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://rm-bp14z2vanu1hlt59rao.mysql.rds.aliyuncs.com:3306/time?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Liub630918");


        // 包配置

        return dsc;
    }

    private static PackageConfig packageConfig(){
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example.springboot.autoconfig.web.demo");
        return pc;
    }

    private static StrategyConfig strategyConfig(){
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
//        strategy.setSuperControllerClass("");
        // 写于父类中的公共字段
//        strategy.setSuperEntityColumns("id");
        strategy.setInclude("t_admin_user","t_user","t_user_region");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix( "t_");
        return strategy;
    }
}
