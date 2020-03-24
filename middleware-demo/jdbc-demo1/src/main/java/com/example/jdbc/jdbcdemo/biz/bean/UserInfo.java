package com.example.jdbc.jdbcdemo.biz.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * 配置开关
 *
 * @author liubiao
 */
@Data
@TableName("user_info_new")
public class UserInfo extends Model<UserInfo> {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("name_new")
    private String name;

    @TableField("age_new")
    private int age;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }


}
