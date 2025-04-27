//package com.breeze.sample.elasticsearchdemoparent.config;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.Resource;
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RBloomFilter;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @auther: liubiao
// * @date: 2025-03-12
// */
//@Slf4j
//@Component
//public class BloomFilterUtil {
//
//    // 布隆过滤器的初始大小
//
//    @Value("${bloomFilter.MIN EXPECTED INSERTIONS:1000}")
//    private int MIN_EXPECTED_INSERTIONS;
//
//    //预期插入数据量
//    private int EXPECTED_INSERTIONS;
//
//    //布隆过滤器的错误率
//    @Value("${bloomFilter.bloomFilterErrorRate:0.01}")
//    private double FPP;
//    //布隆过滤器的最大使用率
//    @Value("${bloomFilter.maximumUtilization:0.9}")
//    private double maximumUtilization;
//    //布隆过滤器的最小使用率
//    @Value("${bloomFilter.minimumUtilization:0.001}")
//    private double minimumUtilization;
//    //布隆过滤器的初始序列号
//    @Value("${bloomFilter.RBloomFilterSequence:1}")
//    public int RBloomFilterSequence;
//    //布隆过滤器的容量自适应定时任务频率
//    private static final String CRON_EXPANSION = "0 0/5 * * * ?";
//    //    public BloomFilter<String> bloomFilter;
//    public RBloomFilter<String> rBloomFilter;
//    @Resource
//    private RedissonClient redissonClient;
//
//    /**
//     * 初始化基于Redis防止数据库查询的布隆过滤器
//     */
//    @PostConstruct
//    public void buidUserRegisterCachePenetrationBloomFilter() {
//        EXPECTED_INSERTIONS = MIN_EXPECTED_INSERTIONS;
//        RBloomFilter<String> cachePenetrationBloomFilter = getrBloomFilter();
//        cachePenetrationBloomFilter.tryInit(EXPECTED_INSERTIONS, FPP);
//        initRBloomFilter(cachePenetrationBloomFilter);
//        rBloomFilter = cachePenetrationBloomFilter;
//
//    }
//
//    private void initRBloomFilter(RBloomFilter<String> rBloomFilter) {
//        List<String> names = Arrays.asList("张三", "李四", "王五");
//        names.parallelStream().forEach(rBloomFilter::add);
//    }
//
//    public RBloomFilter<String> getrBloomFilter() {
//        try {
//            RBloomFilter<String> bloomFilter;
//            if (RBloomFilterSequence == 1) {
//                bloomFilter = redissonClient.getBloomFilter("names_1");
//            }else {
//                bloomFilter = redissonClient.getBloomFilter("names_2");
//            }
//            return bloomFilter;
//        } catch (Exception e) {
//            log.error("异常:{}", e);
//        }
//        return null;
//    }
//}
