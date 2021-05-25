package com.example.helpify.service;

import com.example.helpify.model.Demande;
import com.example.helpify.model.User;
import com.example.helpify.repository.DemandeRepository;


public class GestionDemandeService {
    public static boolean ajouterDemande(Demande demande, DemandeRepository demandeRepository) {
        if (demande == null) return false;
        demandeRepository.save(demande);
        return true;
    }

    public static boolean modifierDemande(Demande demande, DemandeRepository demandeRepository) {
        Demande foundDemande;
        foundDemande = demandeRepository.findDemandeById(demande.getId());

        if (foundDemande == null) return false;

        foundDemande.setTypeActivite(demande.getTypeActivite());
        foundDemande.setDescription(demande.getDescription());
        foundDemande.setEtat(demande.getEtat());
        foundDemande.setTitre(demande.getTitre());
        demandeRepository.save(foundDemande);
        return true;
    }

    public static boolean supprimerDemande(long id, DemandeRepository demandeRepository) {
        Demande foundDemande;
        foundDemande = demandeRepository.findDemandeById(id);

        if (foundDemande == null) return false;


        demandeRepository.delete(foundDemande);
        return true;
    }
}
