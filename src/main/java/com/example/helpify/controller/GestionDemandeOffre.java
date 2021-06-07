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

        System.out.println("idOffre="+idOffre);

        Demande demande=null;
        Offre offre = null;
        demande = demandeRepository.findDemandeById(idDemande);
        offre=offreRepository.findOffreById(idOffre);
        if(demande !=null && offre!=null){
              demandeOffre.setDemande (demande);
              demandeOffre.setOffre(offre);
            return  demandeOffreRepository.save(demandeOffre);
        }
        else
        {
            throw new NotFoundException("No offre/demande with this email/id " + idOffre);
        }


    }
}
