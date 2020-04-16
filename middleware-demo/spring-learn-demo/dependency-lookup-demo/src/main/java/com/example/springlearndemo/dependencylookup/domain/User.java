package com.example.springlearndemo.dependencylookup.domain;

import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class User implements BeanNameAware {

    private long id;

    private String name;

    private transient String beanName;

    private List<City> workCities;

    private List<City> lifeCities;

    public List<City> getWorkCities() {
        return workCities;
    }

    public void setWorkCities(List<City> workCities) {
        this.workCities = workCities;
    }

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public void setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static User createUser(){
        return new User();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beanName='" + beanName + '\'' +
                ", workCities=" + workCities +
                ", lifeCities=" + lifeCities +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("User Bean 对象初始化....");
    }

    @PreDestroy
    public void destory(){
        System.out.println("User Bean 对象销毁中....");
    }


    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
    }
}
