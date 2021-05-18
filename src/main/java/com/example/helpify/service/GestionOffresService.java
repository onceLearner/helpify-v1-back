package com.example.helpify.service;

import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import com.example.helpify.repository.OffreRepository;
import com.example.helpify.repository.UserRepository;

public class GestionOffresService {

    public static Offre SaveOffre(Offre offre,String email, OffreRepository offreRepository, UserRepository userRepository) {
        User foundUser ;
        foundUser= userRepository.findUserByEmail(email);

        if(foundUser==null) return null;

        else {

          foundUser.setOffres(offre);
          return offreRepository.save(offre);
        }




    }
    public static Offre DeleteOffre(long offreId,OffreRepository offreRepository){

      return   offreRepository.deleteOffreById(offreId);

    }



}
