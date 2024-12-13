package com.breeze.sample.seata.stockservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @auther: liubiao
 * @date: 2024-12-11
 */

@Data
@TableName("stock_tbl")
public class StockTbl extends Model<StockTbl> {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long storageId;

    private Long count;
}
