package com.example.helpify.repository;


import com.example.helpify.model.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre,Long> {

    Offre findOffreById(long id);

}
