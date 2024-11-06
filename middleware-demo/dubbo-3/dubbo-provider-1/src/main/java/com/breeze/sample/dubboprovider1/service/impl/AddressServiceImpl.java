package com.breeze.sample.dubboprovider1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.breeze.sample.dubboprovider1.domain.Address;
import com.breeze.sample.dubboprovider1.service.AddressService;
import com.breeze.sample.dubboprovider1.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author lb
* @description 针对表【address】的数据库操作Service实现
* @createDate 2024-10-28 11:30:39
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

}




