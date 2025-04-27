//package com.breeze.sample.elasticsearchdemoparent.config;
//
//import co.elastic.clients.elasticsearch._types.query_dsl.Query;
//import jakarta.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
///**
// * @auther: liubiao
// * @date: 2025-04-23
// */
//
//@Slf4j
//@Aspect
//@Component
//public class ElasticsearchSearchLogAspect {
//
//    @Resource
//    private ElasticsearchTemplate elasticsearchTemplate;
//
//    @Before("execution(* org.springframework.data.elasticsearch.core.AbstractElasticsearchTemplate.search(org.springframework.data.elasticsearch.core.query.Query , Class))")
//    public void beforeSearch(JoinPoint joinPoint){
//
//        try {
//            Object[] args = joinPoint.getArgs();
//            if (args != null && args.length == 2){
//                Query query = (Query) args[0];
//                Class<?> clazz = (Class<?>) args[1];
//                IndexCoordinates indexCoordinatesFor = elasticsearchTemplate.getIndexCoordinatesFor(clazz);
//                Method searchMethod = Class.forName("org.springframework.data.elasticsearch.core");
//            }
//        }catch (Exception e){
//            log.error("e:{}",e);
//        }
//
//    }
//}
