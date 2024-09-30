package com.example.mybatisplusexample.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.mybatisplusexample.conf.NeedDecrypt;
import com.example.mybatisplusexample.conf.NeedEncrypt;
import lombok.Data;

import java.util.Objects;


@Data
@TableName(value = "address")
public class AddressInfo {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value = "user_id")
    private Integer userId;

    @TableField("address")
    private String address;
    @TableField("password")
    @NeedEncrypt(columnValue = "password")
    @NeedDecrypt
    private String password;

}
