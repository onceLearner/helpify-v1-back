package com.example.helpify.controller;

import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;
import com.example.helpify.service.EditProfil;
import com.example.helpify.service.RegistrationBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class EditProfilControlller {



    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/edit")
    public ResponseEntity<?> EditController (@RequestBody User user) {


        return  ResponseEntity.ok().body(EditProfil.edit(user,userRepository));

    }
}
