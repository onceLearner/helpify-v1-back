package com.example.helpify.controller;


import com.example.helpify.model.Demande;
import com.example.helpify.model.DemandeOffre;
import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import com.example.helpify.repository.DemandeOffreRepository;
import com.example.helpify.repository.DemandeRepository;
import com.example.helpify.repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GestionDemandeOffre {

    @Autowired
    DemandeOffreRepository demandeOffreRepository;

    @Autowired
    DemandeRepository demandeRepository;

    @Autowired
    OffreRepository offreRepository;


    @GetMapping("/demandeOffre/demandeOffres")
    public List<DemandeOffre> getAllDemandeOffres() {
        return demandeOffreRepository.findAll();
    }

    @PostMapping("/demandeOffre/add/{idDemande}/{idOffre}")
    public DemandeOffre addDemandeOffre (@Valid @RequestBody DemandeOffre demandeOffre,@PathVariable Long idOffre, @PathVariable Long idDemande){

      System.out.println(demandeOffre.toString());
        Demande demande=null;
        Offre offre = null;

        DemandeOffre potentialDemOff= null ;

        potentialDemOff=demandeOffreRepository.findFirstById(demandeOffre.getId());

        demande = demandeRepository.findDemandeById(idDemande);
        offre=offreRepository.findOffreById(idOffre);


//          return potentialDemOff ;



        if(demande !=null && offre!=null && potentialDemOff==null ){
            demandeOffre.setDemande (demande);
            demandeOffre.setOffre(offre);
            return  demandeOffreRepository.save(demandeOffre);
//            return potentialDemOff;
        }
        else
        {
            throw new NotFoundException("No offre/demande with this email/id " + idOffre);
        }


    }

    // set seen

    @PutMapping("/demandeOffre/modify/{demandeOffreId}/setSeen")
    public DemandeOffre setSennDemandeOffre (@PathVariable Long demandeOffreId){


        DemandeOffre potentialDemOff= null ;

        potentialDemOff=demandeOffreRepository.findFirstById(demandeOffreId);





        if( potentialDemOff!=null ){
            potentialDemOff.setIsSeen(1);

            return  demandeOffreRepository.save(potentialDemOff);
        }
        else
        {
            throw new NotFoundException("No offre/demande with this email/id " + demandeOffreId);
        }


    }

    // set state

    @PutMapping("/demandeOffre/modify/{demandeOffreId}/setState/{newState}")
    public DemandeOffre setNewStateDemandeOffre (@PathVariable Long demandeOffreId,@PathVariable String newState ){


        DemandeOffre potentialDemOff= null ;

        potentialDemOff=demandeOffreRepository.findFirstById(demandeOffreId);





        if( potentialDemOff!=null ){
            potentialDemOff.setEtat(newState);

            return  demandeOffreRepository.save(potentialDemOff);
        }
        else
        {
            throw new NotFoundException("No offre/demande with this email/id " + demandeOffreId);
        }


    }


    // set commentaire by offreur
    @PutMapping("/demandeOffre/modify/{demandeOffreId}/setcoment/byOffreur/{Commentaire}")
    public DemandeOffre setCommentDemandeOffre (@PathVariable Long demandeOffreId,@PathVariable String Commentaire ){


        DemandeOffre potentialDemOff= null ;

        potentialDemOff=demandeOffreRepository.findFirstById(demandeOffreId);





        if( potentialDemOff!=null ){
            potentialDemOff.setCommentDemandeur(Commentaire);

            return  demandeOffreRepository.save(potentialDemOff);
        }
        else
        {
            throw new NotFoundException("No offre/demande with this email/id " + demandeOffreId);
        }


    }


    // set commentaire by demandeur
    @PutMapping("/demandeOffre/modify/{demandeOffreId}/setcoment/byDemandeur/{Commentaire}/{note}")
    public DemandeOffre setCommentDemandeOffreDemandeur (@PathVariable Long demandeOffreId,@PathVariable String Commentaire,@PathVariable float note ){


        DemandeOffre potentialDemOff= null ;

        potentialDemOff=demandeOffreRepository.findFirstById(demandeOffreId);





        if( potentialDemOff!=null ){
            potentialDemOff.setCommentOffreur(Commentaire);
         potentialDemOff.setNoteOffreur(note);
            return  demandeOffreRepository.save(potentialDemOff);
        }
        else
        {
            throw new NotFoundException("No offre/demande with this email/id " + demandeOffreId);
        }


    }


}
