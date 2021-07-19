package com.example.springlearndemo.enumdemo;

/**
 * @author: liubiao
 * @date: 2021/5/9 10:29
 * @Description:
 */
public enum ImgTypeEnum {

    other("其他"),
    advert("广告"),

    column("栏目"),
    logo("游戏logo"),
    split("游戏截图");


    private final String value;

    ImgTypeEnum(String value) {
        this.value = value;
    }
}
