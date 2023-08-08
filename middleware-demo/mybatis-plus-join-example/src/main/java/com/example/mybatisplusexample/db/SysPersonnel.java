package com.example.mybatisplusexample.db;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * (SysPersonnel)表实体类
 *
 * @author liulu
 * @since 2021-01-13 09:49:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPersonnel extends PageBean implements Serializable {

    /**
     *
     */
    private String id;


    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;


    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createdDate;


    /**
     *
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastModifiedBy;


    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastModifiedDate;


    /**
     *
     */
    private String idNo;


    /**
     *
     */
    private String idType;


    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;


    /**
     *
     */
    private String domicileAddr;


    /**
     *
     */
    private String email;


    /**
     *
     */
    private String employer;


    /**
     *
     */
    private Integer gender;


    /**
     *
     */
    private String graduatedFrom;


    /**
     *
     */
    private String health;


    /**
     *
     */
    private String highestEducation;


    /**
     *
     */
    private String jobNo;


    /**
     *
     */

    private String major;


    /**
     *
     */
    private String name;


    /**
     *
     */
    private String nation;


    /**
     *
     */
    private String nativeAddr;


    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date participateWorkDate;


    /**
     *
     */
    private String phone;


    /**
     *
     */
    private String politicalStatus;


    /**
     *
     */
    private String professionalTitle;


    /**
     *
     */
    private String remark;


    /**
     *
     */
    private String responsibility;


    /**
     *
     */
    private Short specialOperator;


    /**
     *
     */
    private String type;


    /**
     *
     */
    private String workAddress;


    /**
     *
     */
    private Integer workingStatus;


    /**
     *
     */

    private String zipCode;


    /**
     * 照片
     */
    private String photoId;

    /**
     * 照片base64
     */
    @TableField(exist = false)
    private String photo;

    /**
     * 工作简历
     */
    private String resumeId;

    /**
     * 0主要负责人 1相关人员
     */
    private String isChargePerson;
    /**
     * 最高学位
     */
    private String highestDegree;
    /**
     * 职务
     */
    private String post;
    /**
     * 工作经历
     */
    private String workExperience;
    /**
     * 主要负责人办公电话
     */
    @ApiModelProperty("主要负责人办公电话")
    private String telephone;

    /**
     * 工龄
     */
    @ApiModelProperty("工龄")
    private String workingYears;

    /**
     * 相关人员 1：分管领导；2：带班领导；3：安全总监；4：安全管理部门负责人；5：车间主任；6：安全管理人员；7：特种作业人员；8：外来作业人员
     */
    @ApiModelProperty("相关人员 1：分管领导；2：带班领导；3：安全总监；4：安全管理部门负责人；5：车间主任；6：安全管理人员；7：特种作业人员；8：外来作业人员")
    private String relatedPersonType;

    /**
     * 是否为承包商人员：0-否，1-是
     */
    @ApiModelProperty("是否为承包商人员：0-否，1-是")
    private Integer isContractorPersonnel;

    @ApiModelProperty("人脸特征数据")
    private String faceFeatureData;

    @ApiModelProperty("人脸特征数据注册ID")
    private Integer arcFaceSearchId;

    /**
     * 个人电子签名
     */
    @ApiModelProperty(value = "个人电子签名")
    private String sign;

    @ApiModelProperty("")
    @TableField(fill = FieldFill.INSERT)
    private Integer isDel;

    @TableField(fill = FieldFill.INSERT)
    private String ownerId;

    @TableField(fill = FieldFill.INSERT)
    private String tenantId;



    @TableField(exist = false)
    Set<String> departmentIds;

    @TableField(exist = false)
    Set<String> workPositionIds;

    @TableField(exist = false)
    String department;

    @TableField(exist = false)
    String workPosition;



    @TableField(exist = false)
    Set<String> workTypeIds;


}
