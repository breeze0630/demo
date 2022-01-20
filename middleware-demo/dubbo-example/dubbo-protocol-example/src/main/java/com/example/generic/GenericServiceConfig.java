package com.example.generic;

import com.example.service.MyGenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericServiceConfig {

    @Bean(name = "genericService")
    public MyGenericService myGenericService(){
        return new MyGenericService();
    }

}
