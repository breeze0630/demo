package com.example.zipdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExportZipController {

    @RequestMapping("export")
    public void exportZip(HttpServletResponse response, HttpServletRequest request){

        ZipUtils.exportZipFile("ys.zip","D:\\wendao\\FileSystem\\test\\abc",response,request);
    }
}
