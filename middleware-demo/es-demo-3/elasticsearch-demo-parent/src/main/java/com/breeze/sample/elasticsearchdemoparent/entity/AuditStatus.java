package com.breeze.sample.elasticsearchdemoparent.entity;

/**
 * @auther: liubiao
 * @date: 2025-03-11
 */
public enum AuditStatus {
    UNAUDITED("未审核",0),
    APPROVED("审核通过",1);
    public String status;
    public int code;

    AuditStatus(String status,int code){
        this.status = status;
        this.code = code;
    }
    public static AuditStatus getByCode(int code){
        for(AuditStatus obj : values()){
            if(obj.code == code){
                return obj;
            }
        }
        return null;
    }

}
