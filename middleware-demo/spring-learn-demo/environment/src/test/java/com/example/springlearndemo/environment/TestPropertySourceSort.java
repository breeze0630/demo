package com.example.springlearndemo.environment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@TestPropertySource(
        properties = "user.name = inner test name",
        locations = "classpath:application-test.properties"
)
public class TestPropertySourceSort {

    @Value("${user.name}")
    private String userName;

    @Autowired
    private ConfigurableEnvironment environment ;


    @Test
    public void testProcess(){

        System.out.println(this.userName);

        for (PropertySource source : environment.getPropertySources()){
            System.out.printf("source(name:%s) 属性 user.name = %s \n",source.getName(),source.getProperty("user.name"));
        }
    }
}
