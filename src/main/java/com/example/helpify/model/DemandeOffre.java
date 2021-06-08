package com.example.helpify.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DemandeOffre {

    @Id
    private long id;

    private String etat;


// just a comment

    @ManyToOne( optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    private Demande demande;


    @ManyToOne( optional = false)
    @JoinColumn(name = "offre_id", nullable = false)
    @JsonIgnoreProperties({"demandeOffres","createDateTime","updateDateTime",})
    private Offre offre;


    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    private String idOffreur;
    private String idDemandeur;

    private float noteOffreur;

    private int isSeen=0;


    private String commentOffreur ;
    private String commentDemandeur;


    public DemandeOffre(long id, Demande demande, Offre offre,float noteOffreur, LocalDateTime createDateTime, LocalDateTime updateDateTime, String idOffreur, String idDemandeur, String commentOffreur, String commentDemandeur,String etat,int isSeen) {
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
        this.noteOffreur=noteOffreur;
        this.isSeen=isSeen;
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

    public int getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(int isSeen) {
        this.isSeen = isSeen;
    }

    public float getNoteOffreur() {
        return noteOffreur;
    }

    public void setNoteOffreur(float noteOffreur) {
        this.noteOffreur = noteOffreur;
    }

    @Override
    public String toString() {
        return "DemandeOffre{" +
                "id=" + id +
                ", etat='" + etat + '\'' +
                ", demande=" + demande +
                ", offre=" + offre +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                ", idOffreur='" + idOffreur + '\'' +
                ", idDemandeur='" + idDemandeur + '\'' +
                ", noteOffreur=" + noteOffreur +
                ", isSeen=" + isSeen +
                ", commentOffreur='" + commentOffreur + '\'' +
                ", commentDemandeur='" + commentDemandeur + '\'' +
                '}';
    }
}
