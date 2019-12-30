package com.example.springlearndemo.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Transactional
@Service
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionalService {

    /**
     * @return 服务Bean名称
     *
     * */
    String name() default "";
}
