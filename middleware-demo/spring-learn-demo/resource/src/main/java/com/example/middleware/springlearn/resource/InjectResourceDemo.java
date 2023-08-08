package com.example.middleware.springlearn.resource;

import com.example.middleware.springlearn.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/7 21:25
 * @Create by external_ll@163.com
 **/
public class InjectResourceDemo {


    @Value("classpath:/META-INF/default.properties")
    private Resource defaultResource;

    @Value("classpath*:/META-INF/*.properties")
    private Resource[] resources;

     @Value("${user.dir}")
     private String currentProjectBootPath;
    @PostConstruct
    private void init(){
        System.out.println(ResourceUtils.getContent(defaultResource));
        System.out.println("======================");
//        resources.forEach(k -> System.out.println(ResourceUtils.getContent(k)));
        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);
        System.out.println("======================");
        System.out.println(currentProjectBootPath);
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(InjectResourceDemo.class);

        applicationContext.refresh();

        applicationContext.close();
    }
}
