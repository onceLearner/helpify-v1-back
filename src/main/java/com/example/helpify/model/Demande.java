package com.example.helpify.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class Demande {

    @Id
    private long id;
    private String titre;
    private String type_activite;
    private String description;
    private Float localisationX;
    private Float localisationY;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

   private LocalTime time;


    private String etat;

    @ManyToOne( optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties({"offres","demandes","createDateTime","updateDateTime","telephone","password"})
    private User user;


    @OneToMany(mappedBy = "demande")
    @JsonIgnoreProperties({"demande"})
    private List<DemandeOffre> demandeOffres;


    public Demande() {
    }

    public Demande(long id, String titre, String type_activite, String description, Float localisationX, Float localisationY, LocalDate date, LocalTime time, String etat, User user,List<DemandeOffre> demandeOffre) {
        this.id = id;
        this.titre = titre;
        this.type_activite = type_activite;
        this.description = description;
        this.localisationX = localisationX;
        this.localisationY = localisationY;
        this.date = date;
        this.time = time;
        this.etat = etat;
        this.user = user;
        this.demandeOffres=demandeOffres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTypeActivite() {
        return type_activite;
    }

    public void setTypeActivite(String type_activite) {
        this.type_activite = type_activite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType_activite() {
        return type_activite;
    }

    public void setType_activite(String type_activite) {
        this.type_activite = type_activite;
    }

    public Float getLocalisationX() {
        return localisationX;
    }

    public void setLocalisationX(Float localisationX) {
        this.localisationX = localisationX;
    }

    public Float getLocalisationY() {
        return localisationY;
    }

    public void setLocalisationY(Float localisationY) {
        this.localisationY = localisationY;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public List<DemandeOffre> getDemandeOffres() {
        return demandeOffres;
    }



    public void setDemandeOffres(DemandeOffre demandeOffre) {
        this.demandeOffres.add( demandeOffre);
    }


    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", type_activite='" + type_activite + '\'' +
                ", description='" + description + '\'' +
                ", localisationX=" + localisationX +
                ", localisationY=" + localisationY +
                ", date=" + date +
                ", time=" + time +
                ", etat='" + etat + '\'' +
                ", user=" + user +
                ", demandeOffres=" + demandeOffres +
                '}';
    }
}
