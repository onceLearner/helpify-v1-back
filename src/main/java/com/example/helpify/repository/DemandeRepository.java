package com.example.helpify.repository;

import com.example.helpify.model.Demande;
import com.example.helpify.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepository extends JpaRepository<Demande,Long> {
    public Demande findDemandeById(long id);



    Demande deleteById(long id);

}
