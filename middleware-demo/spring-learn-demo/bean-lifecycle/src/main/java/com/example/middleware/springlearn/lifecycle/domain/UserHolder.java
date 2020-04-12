package com.example.middleware.springlearn.lifecycle.domain;


import com.example.springlearndemo.dependencylookup.domain.User;

public class UserHolder {

    private  User user ;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
