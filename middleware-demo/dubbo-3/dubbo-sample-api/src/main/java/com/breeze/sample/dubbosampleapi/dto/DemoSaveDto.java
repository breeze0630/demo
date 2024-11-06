package com.breeze.sample.dubbosampleapi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther: liubiao
 * @date: 2024-10-25
 */

@Data
public class DemoSaveDto implements Serializable {

    private String name;

    private String address;
}
