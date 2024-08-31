package com.example.other.trans.controller;

import com.example.other.dto.StuDto;
import com.example.other.trans.bean.Student;
import com.example.other.trans.dto.TechBankResult;
import com.example.other.trans.service.StuSexService;
import com.example.other.trans.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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


    @GetMapping("l3")
    public TechBankResult l3(){
        List<Student> studentList = studentService.l2();
        List<StuDto> stuDtos = Optional.ofNullable(studentList)
                .orElse(new ArrayList<>())
                .stream().map(l->{
                    StuDto stuDto = new StuDto();
                    BeanUtils.copyProperties(l,stuDto);
                    return stuDto;
                }).toList();
        return TechBankResult.success(stuDtos);
    }

    @GetMapping("l4")
    public ResponseEntity l4(){
        List<Student> studentList = studentService.l2();
        List<StuDto> stuDtos = Optional.ofNullable(studentList)
                .orElse(new ArrayList<>())
                .stream().map(l->{
                    StuDto stuDto = new StuDto();
                    BeanUtils.copyProperties(l,stuDto);
                    return stuDto;
                }).toList();
       return ResponseEntity.status(200).body(stuDtos);
    }

}
