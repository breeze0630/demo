package com.example.paymentservicesentinel8060.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @GetMapping("/get/{id}")
    public Object getId(@PathVariable("id") int id){
        return "get:" + UUID.randomUUID() +  ":" + id;
    }
    @GetMapping("/getInfo/{id}")
    public Object getInfo(@PathVariable("id") int id){
        return "getInfo:" + UUID.randomUUID() +  ":" + id;
    }


}
