//package com.breeze.sample.elasticsearchdemoparent.service;
//
//import com.breeze.sample.elasticsearchdemoparent.config.BloomFilterUtil;
//import jakarta.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//
///**
// * @auther: liubiao
// * @date: 2025-03-12
// */
//@Service
//@Slf4j
//public class RBloomFilterService {
//
//    @Resource
//    private BloomFilterUtil bloomFilterUtil;
//
//    public boolean add(String key){
//        return bloomFilterUtil.rBloomFilter.add(key) ;
//    }
//
//    public boolean check(String key){
//        return bloomFilterUtil.rBloomFilter.contains(key) ;
//    }
//
//
//}
