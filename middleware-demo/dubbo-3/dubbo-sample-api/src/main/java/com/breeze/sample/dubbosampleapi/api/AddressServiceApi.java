package com.breeze.sample.dubbosampleapi.api;

import com.breeze.sample.dubbosampleapi.base.Result;
import com.breeze.sample.dubbosampleapi.dto.AddressDto;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
public interface AddressServiceApi {

    Result<AddressDto> saveAddress(AddressDto req);

    Result<AddressDto> updateAddress(AddressDto req);

    Result<AddressDto> getAddressById(Long id);

}
