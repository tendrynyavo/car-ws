/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.request;

import com.example.carws.model.primaire.Carburant;
import com.example.carws.model.primaire.Marque;
import com.example.carws.model.primaire.Moteur;
import com.example.carws.model.primaire.TypeMoteur;

/**
 *
 * @author sarobidy
 */
public class EngineRequest {
          
          String nom;
          String configuration;
          Integer cylindre;
          Double puissance;
          Double capaacite;
          Double consommation;
          String marque;
          String type;
          String carburant;

          public String getNom() {
                    return nom;
          }

          public void setNom(String nom) {
                    this.nom = nom;
          }

          public String getConfiguration() {
                    return configuration;
          }

          public void setConfiguration(String configuration) {
                    this.configuration = configuration;
          }

          public Integer getCylindre() {
                    return cylindre;
          }

          public void setCylindre(Integer cylindre) {
                    this.cylindre = cylindre;
          }

          public Double getPuissance() {
                    return puissance;
          }

          public void setPuissance(Double puissance) {
                    this.puissance = puissance;
          }

          public Double getCapaacite() {
                    return capaacite;
          }

          public void setCapaacite(Double capaacite) {
                    this.capaacite = capaacite;
          }

          public Double getConsommation() {
                    return consommation;
          }

          public void setConsommation(Double consommation) {
                    this.consommation = consommation;
          }

          public String getMarque() {
                    return marque;
          }

          public void setMarque(String marque) {
                    this.marque = marque;
          }

          public String getType() {
                    return type;
          }

          public void setType(String type) {
                    this.type = type;
          }

          public String getCarburant() {
                    return carburant;
          }

          public void setCarburant(String carburant) {
                    this.carburant = carburant;
          }
          
          public Moteur toEngine(){
                    Moteur moteur = new Moteur();
                    moteur.setCapacite(this.getCapaacite());
                    moteur.setConfiguration(this.getConfiguration());
                    moteur.setConsommation(this.getConsommation());
                    moteur.setCylindre(this.getCylindre());
                    moteur.setNom(this.getNom());
                    moteur.setPuissance(this.getPuissance());
                    Marque m = new Marque();
                    m.setId(this.getMarque());
                    TypeMoteur tm = new TypeMoteur();
                    tm.setId(this.getType());
                    Carburant c= new Carburant();
                    c.setId(this.getCarburant());
                    moteur.setCarburant(c);
                    moteur.setMarque(m);
                    moteur.setType(tm);
                    return moteur;
          }
          
}
