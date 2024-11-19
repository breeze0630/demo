package com.breeze.sample.dubbosampleapi.api;

import com.breeze.sample.dubbosampleapi.dto.DemoSaveDto;

import java.util.List;
import java.util.Set;

/**
 * @auther: liubiao
 * @date: 2024-10-25
 */
public interface DemoService {

    String sayHello(String name);

    String save(DemoSaveDto req);

    Set<String> getList();
}
