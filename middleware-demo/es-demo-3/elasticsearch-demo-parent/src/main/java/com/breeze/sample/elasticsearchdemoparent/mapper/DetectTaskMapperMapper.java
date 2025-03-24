package com.breeze.sample.elasticsearchdemoparent.mapper;


import com.breeze.sample.elasticsearchdemoparent.entity.DetectTask;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: liubiao
 * @date: 2024-12-23
 */
@Repository
public interface DetectTaskMapperMapper extends ElasticsearchRepository<DetectTask,Long> {
}
