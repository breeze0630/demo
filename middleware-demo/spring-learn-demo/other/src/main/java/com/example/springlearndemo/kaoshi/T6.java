package com.example.springlearndemo.kaoshi;

public class T6 {

    private final static String LINE = "-";

    public static void main(String[] args) {
        String  param = "main-action-holder";
        StringBuilder result = new StringBuilder();
        String a[] = param.split(LINE);
        for (String s : a) {
            if (!param.contains(LINE)) {
                result.append(s);
                continue;
            }
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        System.out.printf("转换结果：%s",result.toString());
    }

}

