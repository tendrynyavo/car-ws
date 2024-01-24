/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.model.primaire.relation;

import com.example.carws.model.primaire.Carburant;
import com.example.carws.model.primaire.TypeMoteur;

/**
 *
 * @author sarobidy
 */
public class TypeCarburant {
          
          Integer id_type;
          Carburant carburant;
          TypeMoteur moteur;

          public Integer getId_type() {
                    return id_type;
          }

          public void setId_type(Integer id_type) {
                    this.id_type = id_type;
          }

          public Carburant getCarburant() {
                    return carburant;
          }

          public void setCarburant(Carburant carburant) {
                    this.carburant = carburant;
          }

          public TypeMoteur getMoteur() {
                    return moteur;
          }

          public void setMoteur(TypeMoteur moteur) {
                    this.moteur = moteur;
          }
          
          
}
