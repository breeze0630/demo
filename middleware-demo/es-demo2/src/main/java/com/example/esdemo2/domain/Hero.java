package com.example.esdemo2.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Hero implements Serializable {


    private Integer id;

    private String name;

    private String country;

    private String birthday;

    private Integer longevity;
}
