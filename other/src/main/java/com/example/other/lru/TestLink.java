package com.example.other.lru;

import com.alibaba.fastjson.JSON;

/**
 * @auther: liubiao
 * @date: 2025-03-02
 */
public class TestLink {

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode("张三","张三明细");
        myLinkedList.addNode("李四","李四名字");
        myLinkedList.addNode("王五","王五名字");
        myLinkedList.addNode("赵六","赵六名字");

        System.out.println(myLinkedList.refreshNode("李四"));
        System.out.println(myLinkedList.toString());
    }
}
