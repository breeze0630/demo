package com.demo.sharding.sphere.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.sharding.sphere.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @auther: liubiao
 * @date: 2024-11-21
 */
@Mapper
public interface OrderMapper  {

    int insertOne(@Param("param") Order order);

//    int insert4Batch(@Param("list") List<Order> orderList);

}
