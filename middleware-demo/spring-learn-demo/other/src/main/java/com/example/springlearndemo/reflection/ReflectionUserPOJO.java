package com.example.springlearndemo.reflection;

public class ReflectionUserPOJO implements UserParent{

    private int id;

    private String name;

    ReflectionUserPOJO (){}

    ReflectionUserPOJO (int id,String name){
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "ReflectionUserPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
