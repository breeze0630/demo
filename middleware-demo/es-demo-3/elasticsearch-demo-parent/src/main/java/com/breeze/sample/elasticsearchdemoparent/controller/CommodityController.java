package com.breeze.sample.elasticsearchdemoparent.controller;

import co.elastic.clients.elasticsearch._types.aggregations.AggregationBuilders;
import com.breeze.sample.elasticsearchdemoparent.entity.Commodity;
import com.breeze.sample.elasticsearchdemoparent.mapper.CommodityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.web.bind.annotation.*;

/**
 * @auther: liubiao
 * @date: 2024-12-23
 */
@RestController
@RequestMapping("commodity")
@Slf4j
public class CommodityController {


    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping("/getList")
    public Object getList(){

        return String.valueOf("ok");

    }

    @GetMapping("/insert/{id}")
    public Object inert(@PathVariable("id")Long id){

        Commodity commodity = new Commodity();
        commodity.setId(id);
        commodity.setNo(id.toString());
        commodity.setTitle("title.."+id);
        commodity.setDescription("desc..."+id);
        commodity.setContent("content...."+id);
        commodity.setLength((int)Math.round(Math.random()*100));
        commodityMapper.save(commodity);
        return commodity;

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
