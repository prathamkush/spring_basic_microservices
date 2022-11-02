package com.signup.service.signupService.service;

import com.netflix.discovery.converters.Auto;
import com.signup.service.signupService.model.User;
import com.signup.service.signupService.proxyServices.AuthenticationConsumer;
import com.signup.service.signupService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    AuthenticationConsumer authConsumer;

    public String signupService(User user){

        User savedUser = userRepository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created User\",\n"+
                "\"data\":"+savedUser+",\n"+
                "}";
    }

    public String loginService(String email, String password){
        List<User> foundUsers =  userRepository.loginUser(email);

        if(foundUsers.isEmpty()){
            return "{\n" +
                    "\"message\":"+"\" Authentication Failed !!! (USER NOT FOUND) \",\n"+
                    "}";
        }

        else if(!foundUsers.get(0).getPassword().equals(password)){
            return "{\n" +
                    "\"message\":"+"\" Password Incorrect !!!\",\n"+
                    "}";
        }

        return "{\n" +
                "\"message\":"+"\" Successfully Logged-in\",\n"+
                "\"data\": {\n"+" Name : "+foundUsers.get(0).getName()+",\n"+
                "Email : "+foundUsers.get(0).getEmail()+"\n"+
                "token : "+authConsumer.createToken(foundUsers.get(0).getId())+"\n"+
                "}";

    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
