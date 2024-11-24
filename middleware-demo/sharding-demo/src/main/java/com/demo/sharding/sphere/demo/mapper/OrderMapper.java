package com.demo.sharding.sphere.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.demo.sharding.sphere.demo.entity.Order;
import com.demo.sharding.sphere.demo.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @auther: liubiao
 * @date: 2024-11-21
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    int insertOne(@Param("param") Order order);

    List<OrderVo> getOrderList();

//    int insert4Batch(@Param("list") List<Order> orderList);

}
