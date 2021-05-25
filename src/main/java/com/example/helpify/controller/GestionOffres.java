package com.example.helpify.controller;


import com.example.helpify.model.Demande;
import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import com.example.helpify.repository.OffreRepository;
import com.example.helpify.repository.UserRepository;
import com.example.helpify.service.GestionOffresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    public Offre addOffre(@PathVariable(value = "userEmail") String userEmail,
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





    @PutMapping("/user/{userEmail}/offre/update/{idOffer}")
    public Offre updateOffre(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idOffer") long idOffre , @Valid @RequestBody Offre offre )
    {
        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){
            Offre offreToUpdate = null;
            offreToUpdate=offreRepository.findOffreById(idOffre);

            if(offreToUpdate!=null) {
                offreToUpdate.setType_activite(offre.getType_activite());
                offreToUpdate.setPerimetre(offre.getPerimetre());
                offreToUpdate.setStart_day(offre.getStart_day());
                offreToUpdate.setEnd_day(offre.getEnd_day());
                offreToUpdate.setStart_time(offre.getStart_time());
                offreToUpdate.setEnd_time(offre.getEnd_time());
                offreToUpdate.setMoyen_de_transport(offre.getMoyen_de_transport());
                offreToUpdate.setLocalisationX(offre.getLocalisationX());
                offreToUpdate.setLocalisationY(offre.getLocalisationY());
                offreToUpdate.setEtat(offre.getEtat());

                return  offreRepository.save(offreToUpdate);
            }

            else{
                throw new NotFoundException("No offre with this id " + userEmail);
            }



        }
        else
        {
            throw new NotFoundException("No user with this email/id " + userEmail);
        }

    }



    @PutMapping("/user/{userEmail}/offre/play/{idOffer}")
    public Offre playPauseOffre(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idOffer") long idOffre  )
    {
        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){
            Offre offreToUpdate = null;
            offreToUpdate=offreRepository.findOffreById(idOffre);

            if(offreToUpdate!=null) {

                offreToUpdate.setEtat("active");

                return  offreRepository.save(offreToUpdate);
            }

            else{
                throw new NotFoundException("No offre with this id " + userEmail);
            }



        }
        else
        {
            throw new NotFoundException("No user with this email/id " + userEmail);
        }

    }



    @PutMapping("/user/{userEmail}/offre/pause/{idOffer}")
    public Offre PauseOffre(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idOffer") long idOffre  )
    {
        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){
            Offre offreToUpdate = null;
            offreToUpdate=offreRepository.findOffreById(idOffre);

            if(offreToUpdate!=null) {

                offreToUpdate.setEtat("pause");

                return  offreRepository.save(offreToUpdate);
            }

            else{
                throw new NotFoundException("No offre with this id " + userEmail);
            }



        }
        else
        {
            throw new NotFoundException("No user with this email/id " + userEmail);
        }

    }




    @Transactional
    @DeleteMapping("/user/{userEmail}/offre/delete/{idOffer}")
    public String deleteOffre(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idOffer") long idOffre )
    {
        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){


            try {
                offreRepository.deleteById(((long) idOffre));

                return "success";

            }
            catch (Exception e){
                System.out.println(e);
                }

        }
        else
        {
            throw new NotFoundException("No user with this email/id " + userEmail);
        }

        return "Error";

    }










}
