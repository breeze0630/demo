package com.example.mybatisplusexample.domain.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther: liubiao
 * @date: 2024-09-30
 */
@Data
public class QueryReq implements Serializable {

    public String name;


    private Integer userId;


    private String address;
}
