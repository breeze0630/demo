package com.example.esdemo.controller;

import com.example.esdemo.dto.User;
import com.example.esdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @GetMapping("addUser")
    public Object addUser(int id,int count  ){
        String name = "张三";
        String english_name = "zhangsan";
        Random random = new Random();
        String address = "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地" +
                "址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地" +
                "址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地" +
                "址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地" +
                "址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地" +
                "址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地" +
                "址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址" +
                "地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址地址";
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        address += address;
        StringBuilder sb = new StringBuilder(address);

        AtomicInteger idAto = new AtomicInteger(id);

        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
      /*  new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();*/
       /* new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();
        new Thread(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name)).start();*/

/*        ExecutorService executors = Executors.newFixedThreadPool(10,new UserInsertFactory());

        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));
        executors.execute(new UserInsertThread(id+count,idAto,userRepository,name,sb,english_name));*/

        return "ok";
    }
}
