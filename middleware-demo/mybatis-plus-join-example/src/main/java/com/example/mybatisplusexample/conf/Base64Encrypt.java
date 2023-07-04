package com.example.mybatisplusexample.conf;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/7/3
 */
public class Base64Encrypt {

    public static String encrypt(String src) {
        try {
            String result = Base64.getEncoder().encodeToString(src.getBytes(StandardCharsets.UTF_8));
            return result;
        } catch (Exception e) {
            throw new RuntimeException("encrypt fail!", e);
        }
    }

    /**
     * 自己写解密逻辑
     */
    public static String decrypt(String src) {
        try {
            byte[] asBytes = Base64.getDecoder().decode(src);
            String result = new String(asBytes, StandardCharsets.UTF_8);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

}
