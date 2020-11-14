package com.example.springboot.autoconfig.web.demo.service.impl;

import com.example.springboot.autoconfig.web.demo.entity.UserRegion;
import com.example.springboot.autoconfig.web.demo.mapper.UserRegionMapper;
import com.example.springboot.autoconfig.web.demo.service.UserRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-地区关联 服务实现类
 * </p>
 *
 * @author liu
 * @since 2020-11-13
 */
@Service
public class UserRegionServiceImpl extends ServiceImpl<UserRegionMapper, UserRegion> implements UserRegionService {

}
