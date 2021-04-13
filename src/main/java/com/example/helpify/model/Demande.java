package com.example.helpify.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String categorie;
    private String description;
    private String adresse;
    private String etat;

    public Demande() {
    }

    public Demande(long id, String titre, String categorie, String description, String adresse, String etat) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.adresse = adresse;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", categorie='" + categorie + '\'' +
                ", description='" + description + '\'' +
                ", adresse='" + adresse + '\'' +
                ", etat='" + etat + '\'' +
                '}';
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
