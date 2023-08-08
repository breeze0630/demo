package com.example.mybatisplusexample.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mybatisplusexample.db.AddressInfo;
import com.example.mybatisplusexample.mapper.UserMapper;
import com.example.mybatisplusexample.service.AddressInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {


    @Autowired
    UserMapper userMapper;


    @Autowired
    private AddressInfoService addressInfoService;
    @GetMapping("update")
    public Object update(){

        AddressInfo addressInfo  = new AddressInfo();
        addressInfo.setPassword("22222");
        addressInfo.setAddress("99999");
        LambdaUpdateWrapper<AddressInfo> lambdaUpdateWrapper = Wrappers.lambdaUpdate(addressInfo);
        lambdaUpdateWrapper.set(AddressInfo::getPassword,"44444")
                .set(AddressInfo::getAddress,"33333")
                .eq(AddressInfo::getUserId,1)
                .eq(AddressInfo::getPassword,"123456");
//        addressInfo.setId(1);
        addressInfoService.update(lambdaUpdateWrapper);

    /*    .set(AddressInfo::getPassword,"44444")
                .set(AddressInfo::getAddress,"33333")
                .eq(AddressInfo::getUserId,1)
                .eq(AddressInfo::getPassword,"123456").update();*/

        return addressInfoService.list(Wrappers.lambdaQuery(AddressInfo.class).eq(AddressInfo::getUserId,1));
    }
    /*@GetMapping("save")
    public Object savePass(){
        AddressInfo addressInfo = new AddressInfo();

        addressInfo.setAddress("ddd");
        addressInfo.setPassword("123456");
        addressInfo.setUserId(2);
//        addressInfo.setId(1);
        addressInfoMapper.insert(addressInfo);
        return addressInfo;
    }
    @GetMapping("get1")
    public Object getUser1(){
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setPassword("5555");
        QueryWrapper<AddressInfo> addressInfoLambdaQueryWrapper = Wrappers.query(addressInfo);
        addressInfoLambdaQueryWrapper.eq("user_id",1);
        addressInfoLambdaQueryWrapper.in("password", Arrays.asList("123456","231322"));
        addressInfoLambdaQueryWrapper.orderByAsc("id");

//        addressInfoLambdaQueryWrapper.eq(AddressInfo::getUserId,1);
//        addressInfoLambdaQueryWrapper.in(AddressInfo::getPassword, Arrays.asList("123456","231322"));
//        addressInfoLambdaQueryWrapper.orderByAsc(AddressInfo::getId);
        addressInfoLambdaQueryWrapper.last("limit 100");
        return addressInfoMapper.selectList(
                addressInfoLambdaQueryWrapper
        );
    }


    @GetMapping("get/{id}")
    public Object getUser(@PathVariable("id") int id){
        return addressInfoMapper.selectById(id);
    }
    @GetMapping("all")
    public Object getUser(){
        return addressInfoMapper.selectList(Wrappers.emptyWrapper());
    }
 *//*   @GetMapping("get1/{id}")
    public Object get1(@PathVariable("id") int id){
        MPJLambdaWrapper<AddressInfo> lambdaWrapper = new MPJLambdaWrapper<AddressInfo>()
                .selectAll(AddressInfo.class)
                .leftJoin(User.class,User::getId, AddressInfo::getUserId)
                .eq(AddressInfo::getUserId,id)
                .in(AddressInfo::getPassword,Arrays.asList("123456","231322"));

        List<AddressInfo> addressList = addressInfoMapper.selectJoinList(AddressInfo.class,lambdaWrapper);
        return addressList;
    }*//*


*/
}
