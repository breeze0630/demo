package com.breeze.sample.seata.orderservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */

@Data
@TableName("order_tbl")
public class OrderTbl extends Model<OrderTbl> {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long accountId;

    private BigDecimal money;
}
