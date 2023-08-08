package com.example.api;

import com.example.domain.api.InfoDTO;
import com.example.domain.api.InfoService;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {


    /**
     * 如果 dubboReference 已经设置了 retries , method 的 retries 将不会生效
     */
    @DubboReference(methods = {@Method(name = "get", retries = 1)})
    private InfoService infoService;


    @GetMapping("get")
    public Object get(String name) {
        return infoService.get(StringUtils.isEmpty(name) ? "empty" : name);
    }

    @GetMapping("set")
    public Object update() {
        return infoService.set();
    }

    @GetMapping("add")
    public Object add(int id, String message) {
        return infoService.add(InfoDTO.builder().id(id).message(message).build());
    }

    @GetMapping("addGeneric")
    public Object addGeneric(int id, String message) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setInterface("com.example.domain.api.InfoService");
        reference.setGeneric(true);
        GenericService genericService = reference.get();
        Object result = genericService.$invoke("addGeneric", new String[]{"com.example.domain.api.InfoDTO"}, new Object[]{InfoDTO.builder().id(id).message(message).build()});


        return result;
    }


    @GetMapping("getGeneric")
    public Object getGeneric(String name) {


        // 引用远程服务
        // 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("com.example.domain.api.InfoService");
        //        reference.setVersion("1.0.0");
        // 声明为泛化接口
        reference.setGeneric(true);

// 用org.apache.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

// 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke("get", new String[]{"java.lang.String"}, new Object[]{"world"});

/*// 用Map表示POJO参数，如果返回值为POJO也将自动转成Map
        Map<String, Object> person = new HashMap<String, Object>();
        person.put("name", "xxx");
        person.put("password", "yyy");
// 如果返回POJO将自动转成Map
        Object result = genericService.$invoke("findPerson", new String[]
                {"com.xxx.Person"}, new Object[]{person});
        */

        return result;
    }
}
