package com.example.carws.model.users;

import java.sql.Date;

import jakarta.persistence.*;
import java.util.Calendar;
import java.util.List;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.model.annonce.AnnonceFavories;
import com.example.carws.model.annonce.AnnonceVendus;
import com.example.carws.model.annonce.Historique;
import com.example.carws.model.annonce.ValidateAnnonce;
import com.example.carws.model.voiture.Voiture;

@Entity
@Table(name = "utilisateur")
public class Users {
    @Id
    @Column(name = "id_utilisateur")
    String id;

    @Column(name = "nom")
    String nom;

    @Column
    String prenom;

    @Column
    String contact;

    @Column(name = "date_naissance")
    Date dateDeNaissance;

    @Column(name = "email")
    String mail;
    
    @Column(name = "mot_de_passe")
    String password;

    // @OneToMany(mappedBy="user")
	// Set<AnnonceFavories> favories;

    @OneToMany(mappedBy = "user")
    // @JsonBackReference
    List<Annonce> annonces;

    @OneToOne(mappedBy = "user")
    Voiture voiture;

    @OneToOne(mappedBy = "user")
    // @JsonBackReference
    ValidateAnnonce validatesAnnonces;

    @OneToMany(mappedBy = "user")
    // @JsonBackReference
    List<AnnonceFavories> favoriesAnnonces;

    @OneToMany(mappedBy = "user")
    // @JsonBackReference
    List<AnnonceVendus> vendusAnnonces;

    @OneToMany(mappedBy = "user")
    // @JsonBackReference
    List<Historique> historiques;
    
    public Users() {
    }

    public Users(String id) {
        this.setId(id);
    }

    public Users(String id, String email) {
        this.setId(id);
        this.setMail(email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date date_de_naissance) throws Exception {
        java.util.Date utilDate = new java.util.Date(date_de_naissance.getTime());

        Calendar calendarNaissance = Calendar.getInstance();
        calendarNaissance.setTime(utilDate);

        int anneeNaissance = calendarNaissance.get(Calendar.YEAR);

        Calendar calendarMaintenant = Calendar.getInstance();
        int anneeActuelle = calendarMaintenant.get(Calendar.YEAR);

        int age = anneeActuelle - anneeNaissance;
        if (age < 18)
            throw new Exception("Désolé, vous devez avoir au moins 18 ans pour ouvrir un compte.");
        this.dateDeNaissance = date_de_naissance;
    }

    public void setDateDeNaissance(String date_de_naissance) throws Exception {
        this.setDateDeNaissance(Date.valueOf(date_de_naissance));
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAnnonces(List<Annonce> annonces){
        this.annonces = annonces;
    }

    public List<Annonce> getAnnonces(){
        return this.annonces;
    }

    // public void setFavories(Set<AnnonceFavories> listes){
    //     this.favories = listes;
    // }

    // public Set<AnnonceFavories> getFavories(){
    //     return this.favories;
    // }

}