package com.example.springlearndemo.function;

import lombok.Builder;

@Builder

public class Student {
    private Integer id;

    private String name;

    private Integer age;

    public Student() {
    }
    public Student(int id,String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /*
    测试hash冲突，需要将hashcode 重写掉，不然几乎无法测试
    @Override
    public int hashCode() {
        int result = 17;
        result = result*31 + id.hashCode();
        result = result*31 + name.hashCode();
        result = result*31 + age.hashCode();
        return result;
    }*/
}
