package com.example.other.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.other.trans.bean.Student;
import com.example.other.trans.dto.TechBankResult;

import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
public interface StudentService extends IService<Student> {

   TechBankResult update2(Student student);

   List<String> selectAddress( );

}
