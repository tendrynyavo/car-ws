/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.carws.request;

import com.example.carws.model.primaire.Marque;
import com.example.carws.model.primaire.Modele;
import java.sql.Date;

/**
 *
 * @author sarobidy
 */
public class ModeleRequest {
          String nom;
          Date annee;
          String marque;
          boolean deleted = false;

          public void setDeleted(boolean t){
            this.deleted = t;
          }
          public boolean getDeleted(){
            return this.deleted;
          }

          public String getNom() {
                    return nom;
          }

          public void setNom(String nom) {
                    this.nom = nom;
          }

          public Date getAnnee() {
                    return annee;
          }

          public void setAnnee(Date annee) {
                    this.annee = annee;
          }

          public String getMarque() {
                    return marque;
          }

          public void setMarque(String marque) {
                    this.marque = marque;
          }
         
          public Modele toModele() throws Exception{
                    Modele m = new Modele();
                    m.setAnnee(this.getAnnee());
                    Marque a= new Marque();
                    m.setDeleted(this.getDeleted());
                    a.setId(this.getMarque());
                    m.setNom(this.getNom());
                    m.setMarque(a);
                    return m;
          }
}
