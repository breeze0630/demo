package com.example.mybatisplusexample.conf;

import mybatis.mate.annotation.Algorithm;
import mybatis.mate.encrypt.DefaultEncryptor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @description:
 * @auther: liubiao
 * @date: 2023/6/30
 */
@Component
public class MyEncryptor extends DefaultEncryptor {


    @Override
    public String encrypt(Algorithm algorithm, String password, String publicKey, String plaintext, Object metaObject)
            throws Exception {
        String result = Base64.getEncoder().encodeToString(plaintext.getBytes(StandardCharsets.UTF_8));
        return result;
    }

    @Override
    public String decrypt(Algorithm algorithm, String password, String privateKey, String encrypt, Object metaObject) throws Exception {
        try {
            byte[] asBytes = Base64.getDecoder().decode(encrypt);
            String result = new String(asBytes, StandardCharsets.UTF_8);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }
}
