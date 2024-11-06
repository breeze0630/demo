package com.breeze.sample.dubboprovider1.api;

import com.breeze.sample.dubboprovider1.domain.Address;
import com.breeze.sample.dubboprovider1.service.AddressService;
import com.breeze.sample.dubbosampleapi.api.AddressServiceApi;
import com.breeze.sample.dubbosampleapi.base.Result;
import com.breeze.sample.dubbosampleapi.dto.AddressDto;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
@DubboService(version = "1.1.0",group = "breeze")
public class AddressServiceApiImpl implements AddressServiceApi {

    @Resource
    private AddressService addressService;

    public String getAddress(Long addressId) {
        Address address =  addressService.getById(addressId);
        if(ObjectUtils.isEmpty(address)){
            return null;
        }
        return address.getAddress();
    }

    @Override
    public Result<AddressDto> saveAddress(AddressDto req) {
        Address entity = Address.builder()
                .address(req.getAddress())
                .province(req.getProvince())
                .city(req.getCity())
                .country(req.getCountry())
                .build();

        addressService.save(entity);
        Address addressRes = addressService.getById(entity.getId());
        AddressDto res = new AddressDto();
        BeanUtils.copyProperties(addressRes, res);
        return Result.success(res);
    }

    @Override
    public Result<AddressDto> updateAddress(AddressDto req) {
        return null;
    }

    @Override
    public Result<AddressDto> getAddressById(Long id) {
        Address addressRes = addressService.getById(id);
        AddressDto res = new AddressDto();
        BeanUtils.copyProperties(addressRes, res);
        return Result.success(res);
    }
}
