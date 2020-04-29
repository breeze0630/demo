package com.example.springboot.autoconfig.web.demo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebMvcServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return of(SpringWebMvcConfiguration.class);
    }
    @Override
    protected String[] getServletMappings() {
        return of("/*");
    }

    private static <T> T[] of(T... values){
        return values;
    }
}
