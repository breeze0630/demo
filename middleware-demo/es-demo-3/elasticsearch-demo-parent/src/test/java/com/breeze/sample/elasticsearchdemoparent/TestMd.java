package com.breeze.sample.elasticsearchdemoparent;

import ch.qos.logback.core.util.MD5Util;
import ch.qos.logback.core.util.StringUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.MD5;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.tomcat.util.security.MD5Encoder;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

/**
 * @auther: liubiao
 * @date: 2025-02-27
 */
public class TestMd {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(MD5.create().digestHex("admin").toUpperCase());
    }
}
