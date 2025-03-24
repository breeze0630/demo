package com.breeze.sample.elasticsearchdemoparent.controller;

import cn.hutool.bloomfilter.BloomFilterUtil;
import cn.hutool.core.lang.UUID;
import co.elastic.clients.elasticsearch._types.aggregations.AggregationBuilders;
import com.breeze.sample.elasticsearchdemoparent.entity.Commodity;
import com.breeze.sample.elasticsearchdemoparent.entity.DetectTask;
import com.breeze.sample.elasticsearchdemoparent.mapper.CommodityMapper;
import com.breeze.sample.elasticsearchdemoparent.mapper.DetectTaskMapperMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonBloomFilter;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @auther: liubiao
 * @date: 2024-12-23
 */
@RestController
@RequestMapping("task")
@Slf4j
public class DetectTaskController {


    @Autowired
    private DetectTaskMapperMapper detectTaskMapperMapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("cache/get")
    public Object getCache(String key){

    }

    @GetMapping("/insert/{start}/{end}")
    public Object inert(@PathVariable("start")Integer start,@PathVariable("end")Integer end){
        // 每个送检单500个上下的任务
        Random random = new Random();
        for( int startNum = start; startNum < end ; startNum++){

            int size = 500 +  random.nextInt(50);
            String inspectionId = UUID.fastUUID().toString();
            String sampleId = UUID.fastUUID().toString();
            String sampleInfoId = UUID.fastUUID().toString();

            String taskNo = UUID.fastUUID().toString();

            for( int i = 0 ; i< size;i++){
                DetectTask detectTask = new DetectTask();
                detectTask.setId(UUID.fastUUID().toString());
                detectTask.setInspectionId(inspectionId);
                detectTask.setTaskNo(taskNo);
                detectTask.setSampleId(sampleId);
                detectTask.setSampleInfoId(sampleInfoId);
                detectTask.setDescription(sampleInfoId);
                detectTask.setAuditStatus(random.nextInt(2) >= 1 ? "未开始" : "已开始");
                detectTask.setDetectType(random.nextInt(2) >= 1 ? "病原" : "抗体");
                detectTask.setLength((int)Math.round(Math.random()*100));
                detectTaskMapperMapper.save(detectTask);
            }

        }

        return "success";
    }

    @GetMapping("/getList2")
    public Object searchUsers(@RequestParam(required = false) String keyword) {
        log.info("keyword:{}",keyword);
        NativeQuery searchQuery = new NativeQueryBuilder()
//                .withQuery(Queries.termQueryAsQuery("title", keyword))
//                .withFilter(Queries.matchQueryAsQuery("title", keyword, Operator.Or,0.01f))
//                .withFilter(Queries.matchQueryAsQuery("title", keyword, Operator.Or,0.01f))
                .withAggregation("commodity_index_99", AggregationBuilders.max().field("id").build()._toAggregation())


//                .withQuery(Queries.termQueryAsQuery("description", keyword))
                .build();

  /*      return elasticsearchTemplate.search(searchQuery, Commodity.class)
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());*/

        return elasticsearchTemplate.search(searchQuery, Commodity.class)
                .stream()
                .map(SearchHit::getContent)
//                .stream()
//                .map(SearchHit::getContent)
//                .collect(Collectors.toList())
                ;
    }
}
