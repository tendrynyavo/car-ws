/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.model.primaire;

import com.example.carws.model.annonce.DetailsAnnonce;
import com.example.carws.utility.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author sarobidy
 */
@Entity
@Table( name = "caracteristique" )
public class Caracteristique {
          @Id
           @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "CRT"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_caracteristique" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
        @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
           @Column( name = "id_caracteristique" )
          String id;
          @Column
          String nom;

          @OneToOne(mappedBy = "caracteristique")
          @JsonIgnore
          DetailsAnnonce details;

          public void setDetails(DetailsAnnonce details){
            this.details = details;
          }

          public DetailsAnnonce getDetails(){
            return this.details;
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
          
          
}
