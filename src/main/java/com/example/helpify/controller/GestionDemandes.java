package com.example.helpify.controller;


import com.example.helpify.model.Demande;
import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import com.example.helpify.repository.DemandeRepository;
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
public class GestionDemandes {

    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    UserRepository userRepository;



    @GetMapping("/demande/demandes")
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }






    @PostMapping("/user/{userEmail}/demande/add")
    public Demande addDemande(@PathVariable(value = "userEmail") String userEmail,
                          @Valid @RequestBody Demande demande)
    {

        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){
            demande.setUser(user);
            return  demandeRepository.save(demande);
        }
        else
        {
            throw new NotFoundException("No user with this email/id " + userEmail);
        }




    }





    @PutMapping("/user/{userEmail}/demande/update/{idDemande}")
    public Demande updateDemande(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idDemande") long idDemande , @Valid @RequestBody Demande demande )
    {
        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){
            Demande demandeToUpdate = null;
            demandeToUpdate=demandeRepository.findDemandeById(idDemande);

            if(demandeToUpdate!=null) {


                demandeToUpdate.setTitre(demande.getTitre());
                demandeToUpdate.setDescription(demande.getDescription());
                demandeToUpdate.setType_activite(demande.getType_activite());
                demandeToUpdate.setLocalisationX(demande.getLocalisationX());
                demandeToUpdate.setLocalisationY(demande.getLocalisationY());
                demandeToUpdate.setTime(demandeToUpdate.getTime());
                demandeToUpdate.setDate(demande.getDate());
                demandeToUpdate.setEtat(demande.getEtat());




                return  demandeRepository.save(demandeToUpdate);
            }

            else{
                throw new NotFoundException("No demande with this id " + userEmail);
            }



        }
        else
        {
            throw new NotFoundException("No user with this email/id " + userEmail);
        }

    }








    @Transactional
    @DeleteMapping("/user/{userEmail}/demande/delete/{idDemande}")
    public String deleteDemande(@PathVariable(value = "userEmail") String userEmail,@PathVariable(value = "idDemande") long idDemande )
    {
        User user=null;
        user = userRepository.findUserByEmail(userEmail);
        if(user !=null){


            try {
                demandeRepository.deleteById(((long) idDemande));

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
