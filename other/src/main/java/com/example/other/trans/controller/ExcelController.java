package com.example.other.trans.controller;

import com.example.other.trans.config.ResponseLocalEntity;
import com.example.other.trans.enums.ResourceEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-08-01
 */
@RestController
public class ExcelController {


    private static final String RESOURCE_PATH = "classpath:";

    private final ResourceLoader resourceLoader;

    public ExcelController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    @PostMapping("excel")
    public ResponseEntity<Resource> excel() throws Exception{
        ResourceEnum resourceEnum = ResourceEnum.findByCode("PM_Farm_Column");
        Assert.notNull(resourceEnum, "无效的资源编码");
        Resource resource = resourceLoader.getResource(RESOURCE_PATH + resourceEnum.getPath());
//        Resource resource = new FileSystemResource(resourceLoader.getResource(RESOURCE_PATH + resourceEnum.getPath()));
        Assert.notNull(resource, "资源不存在");
        String suffix = resourceEnum.getPath().lastIndexOf('.') != -1 ? resourceEnum.getPath().substring(resourceEnum.getPath().lastIndexOf('.')) : "";
        String fileName = URLEncoder.encode(resourceEnum.getName() + suffix, StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");
//        response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        return ResponseEntity.ok().headers(headers).body(resource);
    }
}
