package com.example.helpify.repository;

import com.example.helpify.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande,Long> {
    public Demande findDemandeById(long id);

}
