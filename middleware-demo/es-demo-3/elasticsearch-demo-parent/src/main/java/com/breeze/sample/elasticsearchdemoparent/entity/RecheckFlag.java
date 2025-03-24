package com.breeze.sample.elasticsearchdemoparent.entity;

/**
 * @auther: liubiao
 * @date: 2025-03-11
 */
public enum RecheckFlag {
    YES("复检",0),
    NO("非复检",1);
    public String status;
    public int code;

    RecheckFlag(String status, int code){
        this.status = status;
        this.code = code;
    }

    public static RecheckFlag getByCode(int code){
        for(RecheckFlag obj : values()){
            if(obj.code == code){
                return obj;
            }
        }
        return null;
    }
}
