package com.example.helpify.model;

//Non terminee

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Entity // this was commented
@Table(name = "offre")
public class Offre  {

    @Id
    private Long id;


    @ManyToOne( optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"offres","demandes","createDateTime","updateDateTime","telephone","password"})
    private User user;


    @OneToMany(mappedBy = "offre",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DemandeOffre> demandeOffres ;

    private int start_day;
    private int end_day;

    private LocalTime start_time;
    private LocalTime end_time;


    private float perimetre;
    private float localisationX;
    private float localisationY;
    private String moyen_de_transport;
    private String type_activite;
    private String etat;

    public Offre(Long id, User user, List<DemandeOffre> demandeOffres, int start_day, int end_day, LocalTime start_time, LocalTime end_time, float perimetre, float localisationX, float localisationY, String moyen_de_transport, String type_activite, String etat) {
        this.id = id;
        this.user = user;
        this.demandeOffres = demandeOffres;
        this.start_day = start_day;
        this.end_day = end_day;
        this.start_time = start_time;
        this.end_time = end_time;
        this.perimetre = perimetre;
        this.localisationX = localisationX;
        this.localisationY = localisationY;
        this.moyen_de_transport = moyen_de_transport;
        this.type_activite = type_activite;
        this.etat = etat;
    }

    public Offre () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStart_day() {
        return start_day;
    }

    public void setStart_day(int start_day) {
        this.start_day = start_day;
    }

    public int getEnd_day() {
        return end_day;
    }

    public void setEnd_day(int end_day) {
        this.end_day = end_day;
    }

    public LocalTime getStart_time() {
        return start_time;
    }

    public void setStart_time(LocalTime start_time) {
        this.start_time = start_time;
    }

    public LocalTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalTime end_time) {
        this.end_time = end_time;
    }

    public float getPerimetre() {
        return perimetre;
    }

    public void setPerimetre(float perimetre) {
        this.perimetre = perimetre;
    }

    public float getLocalisationX() {
        return localisationX;
    }

    public void setLocalisationX(float localisationX) {
        this.localisationX = localisationX;
    }

    public float getLocalisationY() {
        return localisationY;
    }

    public void setLocalisationY(float localisationY) {
        this.localisationY = localisationY;
    }

    public String getType_activite() {
        return type_activite;
    }

    public void setType_activite(String type_activite) {
        this.type_activite = type_activite;
    }

    public String getMoyen_de_transport() {
        return moyen_de_transport;
    }

    public void setMoyen_de_transport(String moyen_de_transport) {
        this.moyen_de_transport = moyen_de_transport;
    }

    public String getType_actvitees() {
        return type_activite;
    }

    public void setType_actvitees(String type_actvite) {
        this.type_activite = type_actvite;
    }


    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public List<DemandeOffre> getDemandeOffres() {
        return demandeOffres;
    }

    public void setDemandeOffres(DemandeOffre demandeOffre) {
        this.demandeOffres.add( demandeOffre);
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", user=" + user +
                ", start_day=" + start_day +
                ", end_day=" + end_day +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", perimetre=" + perimetre +
                ", localisationX=" + localisationX +
                ", localisationY=" + localisationY +
                ", moyen_de_transport='" + moyen_de_transport + '\'' +
                ", type_activite='" + type_activite + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
