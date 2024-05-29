package com.example.other.trans.controller;

import com.example.other.trans.bean.Student;
import com.example.other.trans.dto.TechBankResult;
import com.example.other.trans.service.StuSexService;
import com.example.other.trans.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StuSexService stuSexService;
    @PostMapping("save")
    public TechBankResult add(@RequestBody Student student){
        return TechBankResult.success(studentService.save(student));
    }

    @PostMapping("update")
    public TechBankResult update(@RequestBody Student student){
        return TechBankResult.success(studentService.updateById(student));
    }

    @PostMapping("update2")
    public TechBankResult update2(@RequestBody Student student){
        return studentService.update2(student);
    }

    @PostMapping("list")
    public TechBankResult list(){

        return TechBankResult.success(studentService.list());
    }

    @PostMapping("listSex")
    public TechBankResult listSex(){
        return TechBankResult.success(stuSexService.list());
    }
}
