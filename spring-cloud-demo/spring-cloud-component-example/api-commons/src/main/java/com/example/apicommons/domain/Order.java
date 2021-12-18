package com.example.apicommons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: liubiao
 * @date: 2021/10/9 13:06
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private long id;

    private String orderNo;

}
