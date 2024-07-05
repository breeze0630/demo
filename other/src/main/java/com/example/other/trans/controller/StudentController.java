package com.example.other.trans.controller;

import com.example.other.trans.bean.Student;
import com.example.other.trans.dto.TechBankResult;
import com.example.other.trans.service.StuSexService;
import com.example.other.trans.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
@RestController
@RequestMapping("student")
@Slf4j
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
    @GetMapping("listAddress")
    public TechBankResult listAddress(){
        return TechBankResult.success(studentService.selectAddress());
    }
    @PostMapping("listSex")
    public TechBankResult listSex(){
        return TechBankResult.success(stuSexService.list());
    }

    @GetMapping("l2")
    public TechBankResult l2(){
        return TechBankResult.success(studentService.l2());
    }
}
