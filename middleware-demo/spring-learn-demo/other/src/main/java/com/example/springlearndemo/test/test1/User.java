package com.example.springlearndemo.test.test1;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/21
 */
public class User  implements Serializable {
    private Boolean isActive;

    private boolean valid;

    private String id;


    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
