package com.example.other.trans.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.other.trans.bean.StuSex;
import com.example.other.trans.mapper.StuSexMapper;
import com.example.other.trans.service.StuSexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
@Service
@Slf4j
public class StuSexServiceImpl extends ServiceImpl<StuSexMapper, StuSex> implements StuSexService {

    @Override
    @Transactional
    public void update2(StuSex stuSex) {
        this.lambdaUpdate()
                .set(StuSex::getSex,stuSex.getSex())
                .eq(StuSex::getStuId,stuSex.getStuId())
                .update();

    }
}
