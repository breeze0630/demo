package com.example.huawei.day0001;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * 字符串中找出连续最长的数字串，包含正负号和小数点
 * @auther: liubiao
 * @date: 2025-03-07
 */
public class Day0002 {

    public static void main(String[] args) {

        System.out.println(process("1234567890abcd9.+12345.678.9ed"));
    }

    public static String process(String str){

        String l = "";
        Pattern pattern = Pattern.compile("[+-]?\\d+[.]\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            if(matcher.group().length()>=l.length()){
                l = matcher.group();
            }
        }

        return l;
    }
}
