package com.example.apicommons.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: liubiao
 * @date: 2021/10/9 11:35
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private long id;

    private String name;

    private String address;

    private int age;

    public Payment(long id) {
        this.id = id;
    }
}
