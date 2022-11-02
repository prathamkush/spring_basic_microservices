package com.dummy.service.dummyService.controller;

import com.dummy.service.dummyService.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("admin-service/user")
public interface UserRestConsumer {

    @GetMapping("/add-user")
    String signup(@RequestBody User user);

    @GetMapping("/get-users")
    List<User> getUsers();


}
