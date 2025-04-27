package com.breeze.sample.elasticsearchdemoparent.entity;

import lombok.Data;
import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @auther: liubiao
 * @date: 2025-03-11
 */
@Data
@Document(indexName = "detect_task_all")
public class DetectTask {


    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Keyword)
    private String inspectionId;

    @Field(type = FieldType.Keyword)
    private String taskNo;

    @Field(type = FieldType.Keyword)
    private String sampleId;

    @Field(type = FieldType.Keyword)
    private String detectType;




    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String description;

    @Field(type = FieldType.Integer)
    private Integer length;

    /**
     * 样品明细id
     */
    @Field(type = FieldType.Keyword)
    private String sampleInfoId;

    /**
     * 手机号
     */
    @Field(type = FieldType.Keyword)
    private String mobile;

    /**
     * 未开始 检测中 待提交审核 待审核 审核通过 待复检
     */
    @Field(type = FieldType.Keyword)
    private String taskStatus;

    /**
     * 未审核 审核通过  附件
     */
    @Field(type = FieldType.Keyword)
    private String auditStatus;

    /**
     * 附加样品标识
     */
    @Field(type = FieldType.Keyword)
    private Integer attachFlag;

    /**
     * 复检标识
     */
    @Field(type = FieldType.Keyword)
    private Integer recheckFlag;

    /**
     * 检测结果
     * 优先级：复检结果 > 初检结果
     * 取值说明：阴性、阳性
     */
    @Field(type = FieldType.Keyword)
    private String result;

    /**
     * 结果上传时间
     */
    @Field(type = FieldType.Keyword)
    private LocalDateTime resultTime;

    /**
     * 试剂品牌
     */
    @Field(type = FieldType.Keyword)
    private String reagent;

    /**
     * 阴性对照值1
     */
    @Field(type = FieldType.Keyword)
    private String odnc1;

    /**
     * 阴性对照值2
     */
    @Field(type = FieldType.Keyword)
    private String odnc2;

    /**
     * 阳性对照值1
     */
    @Field(type = FieldType.Keyword)
    private String odpc1;

    /**
     * 阳性对照值2
     */
    @Field(type = FieldType.Keyword)
    private String odpc2;

    /**
     * OD值
     */
    @Field(type = FieldType.Keyword)
    private String od;

    /**
     * 结果值
     */
    @Field(type = FieldType.Keyword)
    private String resultValue;

    /**
     * 备注
     */
    @Field(type = FieldType.Keyword)
    private String note;
    @Field(type = FieldType.Keyword)

    private String createBy;
    @Field(type = FieldType.Keyword)

    private LocalDateTime createTime;
    @Field(type = FieldType.Keyword)

    private String updateBy;
    @Field(type = FieldType.Keyword)

    private LocalDateTime updateTime;
    @Field(type = FieldType.Keyword)


    /**
     * 样品是否退回（0：正常、1：已退回）
     */
    private Integer isReturn;

    @Field(type = FieldType.Nested)
    private ServiceType serviceType;

}
