package com.breeze.sample.elasticsearchdemoparent.entity;

/**
 * @auther: liubiao
 * @date: 2025-03-11
 */
public enum AttachFlag {
    YES("附加",0),
    NO("非附加",1);
    public String status;
    public int code;

    AttachFlag(String status, int code){
        this.status = status;
        this.code = code;
    }

    public static AttachFlag getByCode(int code){
        for(AttachFlag obj : values()){
            if(obj.code == code){
                return obj;
            }
        }
        return null;
    }


}
