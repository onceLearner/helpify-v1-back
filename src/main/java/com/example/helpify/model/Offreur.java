package com.example.helpify.model;

import javax.persistence.Entity;

//Non terminee
@Entity
public class Offreur extends User {
    private String description;
    private Evaluation[] evaluations;
    private String[] temps_disponibilite;
    private float diametre_de_disponibilte;
    private String[] moyen_de_transport;
    private String[] type_actvitees;

}
