package com.example.other.trans.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 人员性别信息
 * @auther: liubiao
 * @date: 2024-05-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_stu_sex")
public class StuSex extends Model<StuSex> {

    private Integer id;

    private String sex;

    private Integer stuId ;

}
