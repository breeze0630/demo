package com.breeze.sample.elasticsearchdemoparent.mapper;


import com.breeze.sample.elasticsearchdemoparent.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @auther: liubiao
 * @date: 2024-12-23
 */
@Repository
public interface CommodityMapper extends ElasticsearchRepository<Commodity,Long> {
}
