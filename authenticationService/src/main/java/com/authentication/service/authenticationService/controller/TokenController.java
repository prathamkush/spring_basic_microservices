package com.authentication.service.authenticationService.controller;

import com.authentication.service.authenticationService.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }


    @GetMapping("/get-token")
    public String createToken(int userId){
        return tokenService.createToken(userId);
    }

}
