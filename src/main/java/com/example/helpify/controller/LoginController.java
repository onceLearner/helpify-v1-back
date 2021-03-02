package com.example.helpify.controller;

import com.example.helpify.model.User;
import com.example.helpify.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register (@RequestBody User user) {
        System.out.println(user.toString());
        userRepository.save(user);
        return ResponseEntity.ok().body("sucess");

    }


}
