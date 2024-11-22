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
public class Account{

//    @TableId(value = "account_id",type = IdType.ASSIGN_ID)
    private Long accountId;

//    @TableField(value = "name")
    private String name;
}
