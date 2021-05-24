package com.example.helpify.repository;


import com.example.helpify.model.Offre;
import com.example.helpify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre,Long> {

    Offre findOffreById(long id);

    Offre deleteOffreById(long id);
    Offre deleteById(long id);

}
