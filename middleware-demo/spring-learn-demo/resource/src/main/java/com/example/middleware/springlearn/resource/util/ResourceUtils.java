package com.example.middleware.springlearn.resource.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/7 20:25
 * @Create by external_ll@163.com
 **/
public class ResourceUtils {

    public static String  getContent(Resource resource ) {
        return getContent(resource,"UTF-8");
    }

        static String  getContent(Resource resource , String encoding){

        EncodedResource encodedResource = new EncodedResource(resource,encoding);
        try {
            Reader reader = encodedResource.getReader();
            return IOUtils.toString(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
