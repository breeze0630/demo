package com.example.other.trans.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.other.trans.bean.StuSex;
import com.example.other.trans.bean.Student;
import com.example.other.trans.dto.TechBankResult;
import com.example.other.trans.mapper.StudentMapper;
import com.example.other.trans.service.StuSexService;
import com.example.other.trans.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StuSexService stuSexService;

    @Override
    public List<String> selectAddress() {
        List<String> a =  this.baseMapper.selectAddress();
        log.info(JSON.toJSONString(a));
        return a;
    }

    @Override
    public List<Student> l2() {
        return this.baseMapper.searchAge22();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TechBankResult update2(Student student) {
        updateById(student);
        updateSex2(student);
        if(student.getId() == 1) {
            throw new RuntimeException("");
        }
        return TechBankResult.success();
    }
    private void updateSex2(Student student){
        StuSex stuSex = new StuSex();
        stuSex.setStuId(student.getId());
        stuSex.setSex(student.getSex());
        stuSexService.update2(stuSex);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateSex(Student student){
        StuSex stuSex = new StuSex();
        stuSex.setStuId(student.getId());
        stuSex.setSex(student.getSex());
        stuSexService.lambdaUpdate()
                .set(StuSex::getSex,student.getSex())
                .eq(StuSex::getStuId,student.getId())
                .update();


    }
}
