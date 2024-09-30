package com.example.mybatisplusexample.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {


    @TableId(type = IdType.AUTO)
    private Integer id;

    private String userName;

    private int age;

    @TableLogic(delval = "1" ,value = "0")
    private int delFlag;

}
