package com.example.authdemo.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
