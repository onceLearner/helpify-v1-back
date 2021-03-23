package com.example.helpify.service;

import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;

public class RegistrationBean {

    public static void register(User user, UserRepository userRepository) {
        userRepository.save(user);

    }




}
