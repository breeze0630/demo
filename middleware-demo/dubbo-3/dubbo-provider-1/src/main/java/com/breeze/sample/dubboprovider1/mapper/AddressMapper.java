package com.breeze.sample.dubboprovider1.mapper;

import com.breeze.sample.dubboprovider1.domain.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lb
* @description 针对表【address】的数据库操作Mapper
* @createDate 2024-10-28 11:30:39
* @Entity com.breeze.sample.dubboprovider1.domain.Address
*/
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}




