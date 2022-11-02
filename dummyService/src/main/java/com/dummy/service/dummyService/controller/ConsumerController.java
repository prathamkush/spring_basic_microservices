package com.dummy.service.dummyService.controller;


import com.dummy.service.dummyService.model.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    UserRestConsumer restConsumer;

//    public ConsumerController(UserRestConsumer restConsumer){
//        this.restConsumer = restConsumer;
//    }

    @GetMapping("/get-users")
    List<User> getUsers(){
        System.out.println(restConsumer.getClass().getSimpleName());
        System.out.println("accessing from admin-service");
        return restConsumer.getUsers();
    }

    @PostMapping("/add-user")
    public String signup(@RequestBody User user){
        return restConsumer.signup(user);
    }


}
