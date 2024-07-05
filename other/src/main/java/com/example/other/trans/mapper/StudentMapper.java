package com.example.other.trans.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.other.trans.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select address from t_student")
    List<String> selectAddress();

    List<Student> searchAge22();
}
