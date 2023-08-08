package com.example.modeldemo.service.enumt;

import com.example.modeldemo.init.SpringContextHolder;
import com.example.modeldemo.service.OutputService;
import org.springframework.context.ApplicationContext;

public enum ServiceEnum implements OutputService {


    SERVICE_DEFAULT("outputServiceImpl"){
        /**
         * 输出内容
         *
         * @param info
         */
        @Override
        public void outputInfo(String info) {
            ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
            OutputService outputService = (OutputService)applicationContext.getBean(this.getName());
            outputService.outputInfo(info);
        }
    },
    SERVICE_1("outputService2Impl"){
        /**
         * 输出内容
         *
         * @param info
         */
        @Override
        public void outputInfo(String info) {
            ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
            OutputService outputService = (OutputService)applicationContext.getBean(this.getName());
            outputService.outputInfo(info);
        }
    },
    SERVICE_2("outputService2Impl"){
        /**
         * 此处静态方法抽出
         *
         * @param info
         */
        @Override
        public void outputInfo(String info) {
            execute(info,this.getName());
        }
    };

    private String name;

    ServiceEnum(String name){
        this.name = name;
    }

    private static void execute(String info,String name){
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
        OutputService outputService = (OutputService)applicationContext.getBean(name);
        outputService.outputInfo(info);
    }

    public String getName() {
        return name;
    }

    public static ServiceEnum getByName(String name){
        for(ServiceEnum obj : values()){
            if(obj.name.equals(name)){
                return obj;
            }
        }
        return null;
    }
}
