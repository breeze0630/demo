package com.demo.sharding.sphere.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @auther: liubiao
 * @date: 2024-11-21
 */
@Data
public class OrderItem  {

//    @TableId(value = "order_item_id",type = IdType.ASSIGN_ID)
    private Long orderItemId;

//    @TableField(value = "order_id")
    private Long orderId;

//    @TableField(value = "name")
    private String name;
}
