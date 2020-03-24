package com.example.jdbc.jdbcdemo;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class JdbcDemoApplication2Tests {

    @Test
    void contextLoads() {
        List<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        List<String> idNewList = idList.subList(0, 1);
        for (int i = 0; i < idNewList.size(); i++) {
            idNewList.set(i, "3");
        }

        System.out.println("idList:" + JSON.toJSONString(idList));
        System.out.println("idNewList:" + JSON.toJSONString(idNewList));

    }

    public static void main(String[] args) {
        List<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("2");
        List<String> idNewList = idList.subList(0, 1);
        for (int i = 0; i < idNewList.size(); i++) {
            idNewList.set(i, "3");
        }

        System.out.println("idList:" + JSON.toJSONString(idList));
        System.out.println("idNewList:" + JSON.toJSONString(idNewList));

        String[] array = new String[10];
        array = idList.toArray(array);
        System.out.println("array:" + JSON.toJSONString(idList.toArray(array)));


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.intValue() == o2.intValue()) {
                    return 0;
                }
                return o1.intValue() < o2.intValue() ? -1 : 1;
            }
        });

        System.out.println("list:" + JSON.toJSONString(list));

        HashMap<String, String> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
    }

}
