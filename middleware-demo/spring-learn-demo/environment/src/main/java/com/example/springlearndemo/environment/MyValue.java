package com.example.springlearndemo.environment;

import java.lang.annotation.*;

/**
 * {@link org.springframework.beans.factory.annotation.Value}
 * */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyValue {

    /**
     * attribute default ""
     * */
    String value() default "";
}
