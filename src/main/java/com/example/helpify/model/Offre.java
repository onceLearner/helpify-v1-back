package com.example.helpify.model;

//Non terminee

import javax.persistence.*;

@Entity // this was commented
@Table(name = "offre")
public class Offre  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_offre;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private Float days_frame;
    private Float hours_frame;

    private float diametre_de_disponibilte;
    private Float localisatoin;
    private String moyen_de_transport;
    private String type_actvitees;



}
