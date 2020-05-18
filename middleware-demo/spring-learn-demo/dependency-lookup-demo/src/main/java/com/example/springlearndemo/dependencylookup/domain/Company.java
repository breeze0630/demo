package com.example.springlearndemo.dependencylookup.domain;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/18 20:59
 * @Create by external_ll@163.com
 **/
public class Company {

    private String name;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
