package com.example.mybatisplusexample.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusexample.domain.db.AddressInfo;
import com.example.mybatisplusexample.domain.req.QueryReq;
import com.example.mybatisplusexample.domain.vo.UserDetailVo;

import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/4
 */
public interface AddressInfoService extends IService<AddressInfo> {


    List<UserDetailVo> getList(QueryReq addressInfo);
}
