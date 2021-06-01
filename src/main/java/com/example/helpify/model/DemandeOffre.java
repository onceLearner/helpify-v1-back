package com.example.helpify.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DemandeOffre {

    @Id
    private long id;

    private String etat;




    @OneToOne
    private Demande demande;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offre_id", nullable = false)
    @JsonIgnore
    private Offre offre;


    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    private String idOffreur;
    private String idDemandeur;


    private String commentOffreur ;
    private String commentDemandeur;


    public DemandeOffre(long id, Demande demande, Offre offre, LocalDateTime createDateTime, LocalDateTime updateDateTime, String idOffreur, String idDemandeur, String commentOffreur, String commentDemandeur,String etat) {
        this.id = id;
        this.demande = demande;
        this.offre = offre;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.idOffreur = idOffreur;
        this.idDemandeur = idDemandeur;
        this.commentOffreur = commentOffreur;
        this.commentDemandeur = commentDemandeur;
        this.etat= etat;
    }

    public DemandeOffre() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getIdOffreur() {
        return idOffreur;
    }

    public void setIdOffreur(String idOffreur) {
        this.idOffreur = idOffreur;
    }

    public String getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(String idDemandeur) {
        this.idDemandeur = idDemandeur;
    }

    public String getCommentOffreur() {
        return commentOffreur;
    }

    public void setCommentOffreur(String commentOffreur) {
        this.commentOffreur = commentOffreur;
    }

    public String getCommentDemandeur() {
        return commentDemandeur;
    }

    public void setCommentDemandeur(String commnetDemandeur) {
        this.commentDemandeur = commnetDemandeur;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "DemandeOffre{" +
                "id=" + id +
                ",etat="+etat+
                ", demande=" + demande +
                ", offre=" + offre +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                ", idOffreur='" + idOffreur + '\'' +
                ", idDemandeur='" + idDemandeur + '\'' +
                ", commentOffreur='" + commentOffreur + '\'' +
                ", commentDemandeur='" + commentDemandeur + '\'' +
                '}';
    }
}
