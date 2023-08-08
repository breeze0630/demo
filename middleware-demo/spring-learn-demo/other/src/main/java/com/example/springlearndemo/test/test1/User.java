package com.example.springlearndemo.test.test1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/21
 */

@Data
public class User  implements Serializable {
    /**
     *
     * JsonAlias
     * JsonProperty
     * JSONField
     * 都无法解决 boolean 类型 Is 开头的字段
     *
     * 只有将 基本类型的 boolean 改为 Boolean 才可
     */
    @JsonProperty( "isActive")
    private boolean isActive;

    private boolean valid;

    private String id;


}
