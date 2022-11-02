package com.dummy.service.dummyService.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("authentication-service/auth")
public interface AuthenticationConsumer {

    @GetMapping("/get-token")
    String createToken(int id);

}