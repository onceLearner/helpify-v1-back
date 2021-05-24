package com.example.helpify.controller;


import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import com.example.helpify.repository.OffreRepository;
import com.example.helpify.repository.UserRepository;
import com.example.helpify.service.GestionOffresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class GestionOffres {

    @Autowired
    OffreRepository offreRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/offre/offres")
    public List<Offre> getAllOffres() {
        return offreRepository.findAll();
    }

    @PostMapping("/user/{userEmail}/offre/add")
    public Offre createComment(@PathVariable(value = "userEmail") String userEmail,
                                 @Valid @RequestBody Offre offre)
    {

        User user=null;
        user = userRepository.findUserByEmail(userEmail);
         if(user !=null){
                    offre.setUser(user);
                    return  offreRepository.save(offre);
        }
        else
         {
             throw new NotFoundException("No user with this email/id " + userEmail);
         }




    }


//    @DeleteMapping("/user/{userEmail}/offre/delete/{idOffer}")
//    public Offre createComment(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idOffer") long )
//    {
//        return GestionOffresService.SaveOffre(offre,userEmail,offreRepository,userRepository);
//
//    }





}
