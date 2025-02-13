package com.breeze.sample.elasticsearchdemoparent.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @auther: liubiao
 * @date: 2024-12-23
 */
@Data
@Document(indexName = "commodity_index_99")
public class Commodity {

    @Field(type = FieldType.Keyword)
    private Long id;

    @Field(type = FieldType.Keyword)
    private String no;

//    ik_smart
    //ik_max_word
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String description;

    @Field(type = FieldType.Integer)
    private Integer length;


}
