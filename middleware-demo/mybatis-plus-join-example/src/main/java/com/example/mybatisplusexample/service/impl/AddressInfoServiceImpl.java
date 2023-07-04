package com.example.mybatisplusexample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusexample.db.AddressInfo;
import com.example.mybatisplusexample.mapper.AddressInfoMapper;
import com.example.mybatisplusexample.service.AddressInfoService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/4
 */
@Service
public class AddressInfoServiceImpl extends ServiceImpl<AddressInfoMapper, AddressInfo> implements AddressInfoService {
}
