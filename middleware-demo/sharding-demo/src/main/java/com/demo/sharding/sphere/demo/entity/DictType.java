package com.demo.sharding.sphere.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @auther: liubiao
 * @date: 2024-11-21
 */
@Data
@TableName("t_dict_type")
public class DictType {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String name;
}
