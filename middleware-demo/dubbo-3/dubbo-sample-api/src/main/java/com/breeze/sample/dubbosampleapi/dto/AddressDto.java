package com.breeze.sample.dubbosampleapi.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
@Data
public class AddressDto implements Serializable {

    private Long id;

    private String address;

    private String province;

    private String city;

    private String region;

    private String country;
}
