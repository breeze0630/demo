package com.example.springlearndemo.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@org.springframework.context.annotation.PropertySource("classpath:/application.properties")
public class EnvironmentPropertiesSourceChangeDemo {
    @Value("${user.name}")
    private String userName;
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnvironmentPropertiesSourceChangeDemo.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(EnvironmentPropertiesSourceChangeDemo.class);

        ConfigurableEnvironment environment = context.getEnvironment();

        MutablePropertySources propertySources = environment.getPropertySources();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user.name","heihei");
        PropertySource propertySource = new MapPropertySource("my-map-property",map);
        propertySources.addFirst(propertySource);

        context.refresh();


        EnvironmentPropertiesSourceChangeDemo demo = context.getBean(EnvironmentPropertiesSourceChangeDemo.class);

        System.out.println(demo.userName);

        map.put("user.name","更新后参数name");


        System.out.println("======================================");

        for (PropertySource source: propertySources ) {
            System.out.printf("PropertySource (name:%s) user.name 属性:%s \n",source.getName(),source.getProperty("user.name"));
        }

        context.close();
    }
}
