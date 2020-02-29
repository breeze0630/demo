package com.example.springlearndemo.dependency.injection;

import com.example.springlearndemo.dependency.injection.domain.User;


/**
 * {@link User}
 * */
public class UserHolder {



    private User user;
    public UserHolder(){

    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
