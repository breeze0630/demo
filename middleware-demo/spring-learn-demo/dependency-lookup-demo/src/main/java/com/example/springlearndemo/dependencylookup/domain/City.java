package com.example.springlearndemo.dependencylookup.domain;

public enum City {

    HANGZHOU("杭州"),
    NANJING("南京"),
    BEIJING("北京"),
    ANQING("安庆");


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    City(String name) {
        this.name = name;
    }

}
