package com.example.helpify.controller;


import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;
import com.example.helpify.service.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam(name = "email") String email, @RequestParam(name="password") String password){

        User user = new User(email, password);

        if(LoginBean.login(user, userRepository)) return ResponseEntity.ok().body(true);
        return ResponseEntity.ok().body(false);

    }
}
