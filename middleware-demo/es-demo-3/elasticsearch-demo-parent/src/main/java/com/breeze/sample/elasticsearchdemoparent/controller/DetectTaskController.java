package com.breeze.sample.elasticsearchdemoparent.controller;

import cn.hutool.bloomfilter.BloomFilterUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import co.elastic.clients.elasticsearch._types.aggregations.AggregationBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.alibaba.fastjson.JSON;
import com.breeze.sample.elasticsearchdemoparent.entity.Commodity;
import com.breeze.sample.elasticsearchdemoparent.entity.DetectTask;
import com.breeze.sample.elasticsearchdemoparent.entity.ServiceType;
import com.breeze.sample.elasticsearchdemoparent.mapper.CommodityMapper;
import com.breeze.sample.elasticsearchdemoparent.mapper.DetectTaskMapperMapper;
import jakarta.json.Json;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonBloomFilter;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.client.elc.Queries;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

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
                ServiceType serviceType = new ServiceType();
                serviceType.setNames(Arrays.asList(detectTask.getAuditStatus(),detectTask.getDetectType()));
                detectTask.setServiceType(serviceType);
                detectTask.setLength((int)Math.round(Math.random()*100));
                detectTaskMapperMapper.save(detectTask);
            }

        }

        return "success";
    }


    @GetMapping("getList3")
    public Object getList3(){

        BoolQuery.Builder builder = new BoolQuery.Builder();

        builder.must(b -> b.match(m -> m.field("auditStatus").query("已开始")));
        builder.must(b -> b.match(m -> m.field("detectType").query("抗体")));

        BoolQuery.Builder builder1 = new BoolQuery.Builder();
        builder1.should(b -> b.match(m -> m.field("serviceType.names").query("已开始")));
        builder1.should(b -> b.match(m -> m.field("serviceType.names").query("抗体")));
        builder1.minimumShouldMatch("1");

        builder.must(b -> b.bool(builder1.build()));
        SearchHits<DetectTask> search = elasticsearchTemplate.search(new NativeQueryBuilder().withQuery(
                builder.build()._toQuery()).build(), DetectTask.class);
        List<DetectTask> detectTaskStream = search
                .stream()
                .map(SearchHit::getContent).toList();

        log.info("size:{}",search.getTotalHits());
        return detectTaskStream;
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
