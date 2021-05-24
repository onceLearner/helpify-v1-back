package com.example.helpify.service;

import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import com.example.helpify.repository.OffreRepository;
import com.example.helpify.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class GestionOffresService {

    public static Offre SaveOffre(Offre offre,String email, OffreRepository offreRepository, UserRepository userRepository) {



        User foundUser ;
        foundUser= userRepository.findUserByEmail(email);

        if(foundUser==null || offreRepository.findOffreById(offre.getId())!=null ) return null;

        else {


          return   offreRepository.save(offre);



        }



    }



}
