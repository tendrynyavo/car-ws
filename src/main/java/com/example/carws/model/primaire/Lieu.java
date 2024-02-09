/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.model.primaire;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.utility.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

/**
 *
 * @author sarobidy
 */
@Entity
@Table( name = "lieu" )
public class Lieu {
          @Id
          @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "LIE"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_lieu" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
          @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
          @Column( name = "id_lieu" )
          String id;
          
          @Column
          String nom;

          @OneToMany(mappedBy = "lieu")
          @JsonIgnore
          List<Annonce> annonce;

          public List<Annonce> getAnnonce(){
            return this.annonce;
          }

          public void setAnnonce(List<Annonce> annonce){
            this.annonce = annonce;
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
