package com.example.helpify.model;

//Non terminee

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Arrays;

@Entity // this was commented
@Table(name = "offre")
public class Offre  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    private int start_day;
    private int end_day;
    private float start_hour;
    private float end_hour;


    private float diametre;
    private float localisationX;
    private float localisationY;
    private String moyen_de_transport;
    private String type_activite;

    public Offre(Long id, int start_day, int end_day, float start_hour, float end_hour, float diametre, @Size(min = 2, max = 2) float localisationX, float localisationY, String moyen_de_transport, String type_activite) {
        this.id = id;
        this.start_day = start_day;
        this.end_day = end_day;
        this.start_hour = start_hour;
        this.end_hour = end_hour;
        this.diametre = diametre;
        this.localisationX = localisationX;
        this.localisationY = localisationY;
        this.moyen_de_transport = moyen_de_transport;
        this.type_activite = type_activite;
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

    public float getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(float start_hour) {
        this.start_hour = start_hour;
    }

    public float getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(float end_hour) {
        this.end_hour = end_hour;
    }

    public float getDiametre() {
        return diametre;
    }

    public void setDiametre(float diametre) {
        this.diametre = diametre;
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

    public void setType_actvitees(String type_actvitees) {
        this.type_activite = type_actvitees;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", user=" + user.getEmail() +
                ", start_day=" + start_day +
                ", end_day=" + end_day +
                ", start_hour=" + start_hour +
                ", end_hour=" + end_hour +
                ", diametre=" + diametre +
                ", localisationX=" + localisationX +
                ", localisationY=" + localisationY +
                ", moyen_de_transport='" + moyen_de_transport + '\'' +
                ", type_activite='" + type_activite + '\'' +
                '}';
    }
}
