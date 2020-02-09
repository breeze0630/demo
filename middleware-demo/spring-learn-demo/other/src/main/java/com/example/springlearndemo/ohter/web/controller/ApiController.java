package com.example.springlearndemo.ohter.web.controller;


import com.example.springlearndemo.ohter.web.service.NameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api")
public class ApiController {

/*    @Resource
    NameService nameService;*/

/*    @Autowired
    HttpServletRequest request;*/

    @GetMapping("test")
    public String test( HttpServletRequest request) throws ClassNotFoundException {
//        nameService.printInfo();

        NameService nameService = (NameService) WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean("nameServiceImpl");

//        NameService nameService = (NameService) WebApplicationContextUtils.getWebApplicationContext(request.getServletContext()).getBean(NameService.class);

        nameService.printInfo();
        return "ok";
    }


}
