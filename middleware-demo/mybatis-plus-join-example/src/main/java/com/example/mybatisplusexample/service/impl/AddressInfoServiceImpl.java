package com.example.mybatisplusexample.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusexample.domain.db.AddressInfo;
import com.example.mybatisplusexample.domain.db.User;
import com.example.mybatisplusexample.domain.req.QueryReq;
import com.example.mybatisplusexample.domain.vo.UserDetailVo;
import com.example.mybatisplusexample.mapper.AddressInfoMapper;
import com.example.mybatisplusexample.mapper.UserMapper;
import com.example.mybatisplusexample.service.AddressInfoService;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import com.github.yulichang.toolkit.MPJWrappers;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/4
 */
@AllArgsConstructor
@Service
public class AddressInfoServiceImpl extends ServiceImpl<AddressInfoMapper, AddressInfo>
        implements AddressInfoService {


    private AddressInfoMapper addressInfoMapper;

    private UserMapper userMapper;
    @Override
    public List<UserDetailVo> getList(QueryReq queryReq) {

        List<UserDetailVo> detailVos = userMapper.selectJoinList(UserDetailVo.class, MPJWrappers.lambdaJoin(User.class)
                        .leftJoin(AddressInfo.class, AddressInfo::getUserId, User::getId)
                        .selectAs(User::getId, UserDetailVo::getUserId)
                        .selectAs(User::getUserName, UserDetailVo::getName)
                        .selectAs(AddressInfo::getAddress, UserDetailVo::getAddress)
                        .selectAs(User::getAge, UserDetailVo::getAge)
                        .eq(ObjectUtils.isNotEmpty(queryReq.getUserId()), User::getId, queryReq.getUserId())
                        .like(ObjectUtils.isNotEmpty(queryReq.getAddress()), AddressInfo::getAddress, queryReq.getAddress())
                );

        return detailVos;
    }
}
