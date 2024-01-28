/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.model.primaire;

import com.example.carws.model.voiture.Voiture;
import com.example.carws.utility.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "coloriage")
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Coloriage {

    @Id
    @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "COU"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_coloriage" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
    @Column( name = "id_coloriage" )
    String id;

    @ManyToOne
    @JoinColumn(name = "id_voiture")
    @JsonIgnore
    Voiture voiture;

    @ManyToOne
    @JoinColumn(name = "id_couleur")
    Couleur couleur;

    public Voiture getVoiture(){
        return this.voiture;
    }

    public void setVoiture(Voiture voiture){
        this.voiture = voiture;
    }
          
    public String getId() {
            return id;
    }

    public void setId(String id) {
            this.id = id;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
            this.couleur = couleur;
    }
          
    public Coloriage(){

    }
          
}
