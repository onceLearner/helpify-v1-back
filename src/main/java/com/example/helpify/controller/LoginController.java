package com.example.helpify.controller;


import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;
import com.example.helpify.service.LoginBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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



    @GetMapping("/findUser")
    public String findUser(@RequestParam(name = "email") String email) throws JsonProcessingException {

        User user= null;

        user= userRepository.findUserByEmail(email);

        ObjectMapper mapper = new ObjectMapper();
        String  a = mapper.writeValueAsString(user);
        return  a;


    }
}
