package com.breeze.sample.seata.orderservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.breeze.sample.seata.orderservice.entity.OrderTbl;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */
@Mapper
public interface OrderTblMapper extends BaseMapper<OrderTbl> {
}
