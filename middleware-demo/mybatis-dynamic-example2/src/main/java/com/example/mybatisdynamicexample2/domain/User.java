package com.example.mybatisdynamicexample2.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private int id;

    private String userName;

    private int age;
}
