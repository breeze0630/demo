package com.example.rocketmq.producerdemo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MessageDTO implements Serializable {

    private String topic;

    private String tag;

    private String msg;


    public MessageDTO() {
    }

    public MessageDTO(String topic, String tag, String msg) {
        this.topic = topic;
        this.tag = tag;
        this.msg = msg;
    }
}
