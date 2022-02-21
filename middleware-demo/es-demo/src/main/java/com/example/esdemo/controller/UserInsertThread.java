package com.example.esdemo.controller;

import com.example.esdemo.dto.User;
import com.example.esdemo.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UserInsertThread implements Runnable{

    public UserInsertThread() {
    }

    public UserInsertThread(int total, AtomicInteger idAto, UserRepository userRepository, String name, StringBuilder sb, String english_name) {
        this.total = total;
        this.idAto = idAto;
        this.userRepository = userRepository;
        this.name = name;
        this.sb = sb;
        this.english_name = english_name;
    }

    private int total;
    private AtomicInteger idAto ;
    private UserRepository userRepository;
    private String name;
    private StringBuilder sb;
    private String english_name ;
    @Override
    public void run() {
        int inInner = idAto.getAndAdd(1);
        Random random = new Random();
        while (inInner <total){
            userRepository.save(User.builder()
                    .id(inInner).name(name+inInner)
                    .adress(sb.toString()+inInner)
                    .education("大学")
                    .english_name(english_name+inInner)
                    .job("电工")
                    .phone_number("17612345678")
                    .datetime(LocalDateTime.now())
                    .money(random.nextDouble())
                    .population(random.nextInt(10))
                    .build());
            inInner = idAto.getAndAdd(1);
        }
    }
}
