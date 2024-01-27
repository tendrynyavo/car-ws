/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.model.primaire;

import com.example.carws.utility.IdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author sarobidy
 */
@Entity
@Table( name = "type_moteur" )
public class TypeMoteur {
          @Id
          @Column( name = "id_type" )
          @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "TPM"), @Parameter( name = "sequence", value = "seq_type_moteur" ), @Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
          String id;
          @Column( name = "nom" )
          String nom;
          @Column
          boolean deleted;
          
          @ManyToMany
           @JoinTable(
               name = "type_carburant",
               joinColumns = @JoinColumn(name = "id_type"),
               inverseJoinColumns = @JoinColumn(name = "id_carburant")
           )
          Set<Carburant> carburants;

          public Set<Carburant> getCarburants() {
                    return carburants;
          }

          public void setCarburants(Set<Carburant> carburants) {
                    this.carburants = carburants;
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

          public boolean isDeleted() {
                    return deleted;
          }

          public void setDeleted(boolean deleted) {
                    this.deleted = deleted;
          }
          
}
