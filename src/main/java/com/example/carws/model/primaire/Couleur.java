/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.model.primaire;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author sarobidy
 */
@Entity
@Table(name = "couleur")
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Couleur {
          @Id
          @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "COU"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_couleur" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
        @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
          @Column( name = "id_couleur" )
          String id;
          @Column
          String nom;

          @OneToMany(mappedBy = "couleur")
          @JsonIgnore
          List<Coloriage> coloriage;
          
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
          

          public List<Coloriage> getColoriage(){
            return this.coloriage;
          }

          public void setColoriage(List<Coloriage> coloriage){
            this.coloriage = coloriage;
          }
          
}
