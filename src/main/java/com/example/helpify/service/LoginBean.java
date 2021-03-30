package com.example.helpify.service;

import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;

public class LoginBean {
    public static boolean login(User user, UserRepository userRepository) {
       User foundUser ;
        foundUser= userRepository.findUserByEmail(user.getEmail());
        if(foundUser==null) return false;
        if(foundUser.getPassword().equals((user.getPassword()))) return true;
        return false;

    }



}
