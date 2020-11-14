package com.example.converter.bean;

/**
 * @Description
 * @Date: 2020/9/11 00:07
 * @Create by external_ll@163.com
 **/
public class User {

    private Long id;

    private String name;

    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", context='" + context + '\'' +

                '}';
    }
}
