//package com.example.modeldemo.service.factory;
//
//import com.example.modeldemo.init.SpringContextHolder;
//import com.example.modeldemo.service.OutputService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ServiceFactory {
//
//    public static Map<String,OutputService> serviceMap ;
//
//    @Autowired
//    private ApplicationContext ac;
//
//    @PostConstruct
//    public void init(){
//        if(serviceMap == null){
//            serviceMap = new HashMap<>();
//        }
//    }
//
//    public static OutputService getServiceByName(String name){
//        if(serviceMap.get(name) == null){
//            ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
//            applicationContext.getBean(name);
//        }
//
//        return null;
//    }
//}
