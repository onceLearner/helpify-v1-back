package com.example.helpify.repository;

import com.example.helpify.model.Demande;
import com.example.helpify.model.DemandeOffre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeOffreRepository extends JpaRepository<DemandeOffre,Long> {

    public DemandeOffre findDemandeOffreById(long id);
    public DemandeOffre  findFirstById(long id);
}
