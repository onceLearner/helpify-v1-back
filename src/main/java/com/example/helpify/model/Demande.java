package com.example.helpify.model;


import javax.persistence.*;

@Entity
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String typeActivite;
    private String description;
    private String adresse;
    private String etat;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user ;


    public Demande() {
    }

    public Demande(long id, String titre, String typeActivite, String description, String adresse, String etat, User user) {
        this.id = id;
        this.titre = titre;
        this.typeActivite = typeActivite;
        this.description = description;
        this.adresse = adresse;
        this.etat = etat;
        this.user = user;
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
        return typeActivite;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Demande{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", typeActivite='" + typeActivite + '\'' +
                ", description='" + description + '\'' +
                ", adresse='" + adresse + '\'' +
                ", etat='" + etat + '\'' +
                ", user=" + user +
                '}';
    }
}
