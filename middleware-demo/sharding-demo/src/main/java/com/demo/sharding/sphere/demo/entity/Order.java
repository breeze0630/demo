package com.demo.sharding.sphere.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @auther: liubiao
 * @date: 2024-11-21
 */
@Data
@TableName("t_order")
public class Order extends Model<Order> {

    @TableId(value = "order_id",type = IdType.AUTO)
    private Long orderId;

//    @TableField(value = "user_id")
    private Long userId;

//    @TableField(value = "name")
    private String name;
}
