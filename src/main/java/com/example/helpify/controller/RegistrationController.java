package com.example.helpify.controller;

import com.example.helpify.model.User;
import com.example.helpify.repository.*;

import com.example.helpify.service.RegistrationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RegistrationController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> RegisterController (@RequestBody User user) {

        RegistrationBean.register(user,userRepository);
        return  ResponseEntity.ok().body(true);

    }



}
