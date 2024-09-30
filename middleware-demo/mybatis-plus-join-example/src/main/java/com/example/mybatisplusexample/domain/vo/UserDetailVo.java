package com.example.mybatisplusexample.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther: liubiao
 * @date: 2024-09-30
 */
@Data
public class UserDetailVo implements Serializable {

    private Integer userId;

    private String name;

    private String address;

    private Integer age;
}
