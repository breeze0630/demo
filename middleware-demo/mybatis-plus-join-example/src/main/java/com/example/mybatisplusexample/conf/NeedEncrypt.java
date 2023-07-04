package com.example.mybatisplusexample.conf;

import java.lang.annotation.*;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/6/30
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
public @interface NeedEncrypt {

    String value() default "";
    //可以增加参数，定义不同的加密算法
    String columnValue() default "";
}
