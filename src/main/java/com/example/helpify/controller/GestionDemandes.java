package com.example.helpify.controller;

import com.example.helpify.model.Demande;
import com.example.helpify.model.User;
import com.example.helpify.repository.DemandeRepository;
import com.example.helpify.repository.UserRepository;
import com.example.helpify.service.EditProfil;
import com.example.helpify.service.GestionDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class GestionDemandes {

    @Autowired
    DemandeRepository demandeRepository;

    @PostMapping("/demande/add")
    public ResponseEntity<?> AjouterController (@RequestBody Demande demande) {


        return  ResponseEntity.ok().body(GestionDemandeService.ajouterDemande(demande,demandeRepository));

    }

    @PostMapping("/demande/edit")
    public ResponseEntity<?> ModifierController (@RequestBody Demande demande) {

        return  ResponseEntity.ok().body(GestionDemandeService.modifierDemande(demande,demandeRepository));

    }

    @PostMapping("/demande/delete")
    public ResponseEntity<?> SupprimerController (@RequestBody long id) {


        return  ResponseEntity.ok().body(GestionDemandeService.supprimerDemande(id, demandeRepository));

    }
}
