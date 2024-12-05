package com.demo.sharding.sphere.demo.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;

/**
 * @auther: liubiao
 * @date: 2024-11-25
 */
public class TestId {

    public static void main(String[] args) {
        System.out.println(IdcardUtil.isValidCard18("340824201806216116"));
        System.out.println(IdcardUtil.isValidCard18("340828201806216016"));

        System.out.println(getId());
    }

    public  static String getId(){
        return IdUtil.fastSimpleUUID();
    }
}
