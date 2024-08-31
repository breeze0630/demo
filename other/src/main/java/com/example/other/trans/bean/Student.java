package com.example.other.trans.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("t_student")
public class Student extends Model<Student> {

    private Integer id;

    private String name;

    private Integer age ;

    private String address;

    private LocalDateTime createTime;

    @TableField(exist = false)
    private String sex;
}
