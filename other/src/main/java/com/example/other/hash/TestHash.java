package com.example.other.hash;

import java.util.Arrays;
import java.util.List;

/**
 * @auther: liubiao
 * @date: 2025-03-10
 */
public class TestHash {

    public static void main(String[] args) {

        List<String> nodes = Arrays.asList("node1","node2","node3");
        ConsistentHash hash = new ConsistentHash(100,nodes);
        String key = "2";
        System.out.println(key + ":" + hash.getNode(key));
    }


}
