package com.example.apicommons.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liubiao
 * @date: 2021/10/9 11:47
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int code;

    private String msg;

    private T data;

    public CommonResult (int code,String msg){
        this.code = code;
        this.msg = msg;
        this.data  = data;
    }

    public CommonResult(T data){
        this.code = 200;
        this.msg = "成功";

        this.data = data;
    }

}
