package com.example.carws.model.users;

import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "discussions")
public class Messagerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "id_envoyeur")
    String idEnvoyeur;
    @Column(name = "id_receveur")
    String idReceveur;
    @Column(name = "date_heure_envoie")
    Timestamp dateHeureEnvoie;
    @Column
    String message;

    public Messagerie() {
    }

    public Messagerie(String idEnvoyeur) {
        this.setIdEnvoyeur(idEnvoyeur);
    }

    public Messagerie(String idEnvoyeur, String idReceveur) {
        this.setIdEnvoyeur(idEnvoyeur);
        this.setIdReceveur(idReceveur);
    }

    public Messagerie(String idEnvoyeur, String idReceveur, String dateHeureEnvoie, String message) {
        this.setIdEnvoyeur(idEnvoyeur);
        this.setIdReceveur(idReceveur);
        this.setDateHeureEnvoie(dateHeureEnvoie);
        this.setMessage(message);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdEnvoyeur() {
        return idEnvoyeur;
    }

    public void setIdEnvoyeur(String idEnvoyeur) {
        this.idEnvoyeur = idEnvoyeur;
    }

    public String getIdReceveur() {
        return idReceveur;
    }

    public void setIdReceveur(String idReceveur) {
        this.idReceveur = idReceveur;
    }

    public Timestamp getDateHeureEnvoie() {
        return dateHeureEnvoie;
    }

    public void setDateHeureEnvoie(Timestamp dateHeureEnvoie) {
        this.dateHeureEnvoie = dateHeureEnvoie;
    }

    public void setDateHeureEnvoie(String dateHeureEnvoie) {
        this.setDateHeureEnvoie(Timestamp.valueOf(dateHeureEnvoie));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
