package com.breeze.sample.dubboconsumer1.controller;

import com.breeze.sample.dubbosampleapi.api.AddressServiceApi;
import com.breeze.sample.dubbosampleapi.api.DemoService;
import com.breeze.sample.dubbosampleapi.api.UserServiceApi;
import com.breeze.sample.dubbosampleapi.base.Result;
import com.breeze.sample.dubbosampleapi.dto.UserDto;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: liubiao
 * @date: 2024-10-28
 */
@RestController
@RequestMapping("/api")
public class DemoController {


    @DubboReference
    private DemoService demoService;

//    @DubboReference
//    private UserServiceApi userServiceApi;

    @DubboReference(version = "1.1.0",group = "breeze")
    private AddressServiceApi addressServiceApi;
    @GetMapping("/say/{msg}")
    public Object sayMsg(@PathVariable("msg")String msg){
        return demoService.sayHello(msg);
    }

    @GetMapping("/say2")
    public Object sayMsg2(){
        return demoService.getList();
    }

    @GetMapping("/say3")
    public Object sayMsg3(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-consumer-one");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://127.0.0.1:18848");

        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface("com.breeze.sample.dubbosampleapi.api.DemoService");
        applicationConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setGeneric("true");
        // do not wait for result, 'false' by default
        referenceConfig.setAsync(false);
        referenceConfig.setTimeout(7000);

        GenericService genericService = referenceConfig.get();
        Object result = genericService.$invoke("getList", null, null);

        return result;
    }


//    @GetMapping("/user/{id}")
//    public Result getUser(@PathVariable("id")Long id){
//        return userServiceApi.getUserById(id);
//    }

    @GetMapping("/address/{id}")
    public Result getAddress(@PathVariable("id")Long id){
        return addressServiceApi.getAddressById(id);
    }
}
