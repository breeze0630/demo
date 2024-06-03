package com.example.other.trans.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.other.trans.bean.StuSex;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-29
 */
public interface StuSexService extends IService<StuSex> {

    void update2(StuSex stuSex);
}
