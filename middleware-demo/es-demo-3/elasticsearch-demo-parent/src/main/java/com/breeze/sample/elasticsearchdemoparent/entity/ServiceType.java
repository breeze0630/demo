package com.breeze.sample.elasticsearchdemoparent.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @auther: liubiao
 * @date: 2025-04-23
 */
@Data
public class ServiceType {

    @Field(type = FieldType.Nested)
    private List<String> names;
}
