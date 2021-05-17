package com.example.helpify.controller;

import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GetAllUsers {
    @Autowired
    UserRepository userRepository;



    @GetMapping("/users")
    public List<User> allusers (){

        return userRepository.findAll();


    }
}
