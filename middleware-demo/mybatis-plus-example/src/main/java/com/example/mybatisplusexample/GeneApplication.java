package com.example.mybatisplusexample;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

public class GeneApplication {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql//127.0.0.1:33061/mybatis-test?useUnicode=true&characterEncoding=utf8&useSSL=false", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("liu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/liubiao/Documents/code/demo/middleware-demo/mybatis-plus-example/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.mybatisplusexample.gene") // 设置父包名
                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/liubiao/Documents/code/demo/middleware-demo/mybatis-plus-example/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_activity_flow") // 设置需要生成的表名
                            .addTablePrefix("t_")
                            .entityBuilder()
                            .enableLombok(); // 设置过滤表前缀
                })
                .templateConfig(builder -> builder.disable())
                .execute();

    }
}
