package com.breeze.sample.dubbosampleapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
@Data
public class UserDto implements Serializable {

    @ApiModelProperty(value = "id")
    private Long id;

    private String name;

    private Long addressId;

    private Long age;
}
