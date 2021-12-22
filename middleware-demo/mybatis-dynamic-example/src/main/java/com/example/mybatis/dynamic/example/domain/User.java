package com.example.mybatis.dynamic.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Setter
@Getter
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    @TableField("user_name")
    private String userName;

    @TableField("age")
    private int age;
}
