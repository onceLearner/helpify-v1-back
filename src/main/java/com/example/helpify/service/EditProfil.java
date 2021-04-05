package com.example.helpify.service;

import com.example.helpify.model.User;
import com.example.helpify.repository.UserRepository;

public class EditProfil {
    public static boolean edit(User user, UserRepository userRepository) {
        User foundUser ;
        foundUser= userRepository.findUserByEmail(user.getEmail());

        if(foundUser==null) return false;

        foundUser.setAdresse(user.getAdresse());
        foundUser.setNom(user.getNom());
        foundUser.setEmail(user.getEmail());
        foundUser.setPrenom(user.getPrenom());
        foundUser.setTelephone(user.getTelephone());
        userRepository.save(foundUser);
        return true;

    }
}
