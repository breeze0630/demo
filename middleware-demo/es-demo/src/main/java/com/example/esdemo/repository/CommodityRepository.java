package com.example.esdemo.repository;

import com.example.esdemo.dto.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * @author liubiao
 * @descrition 这里的Repository相当于DAO，操作mysql还是elasticsearch都是一样的
 * 这里是interface ，具体实现由框架适配提供
 * */
@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity,String> {

}
