package com.example.carws.request;

import com.example.carws.model.primaire.Carburant;
import com.example.carws.model.primaire.Categorie;
import com.example.carws.model.primaire.Marque;
import com.example.carws.model.primaire.Modele;
import com.example.carws.model.primaire.Moteur;
import com.example.carws.model.primaire.TypeMoteur;
import com.example.carws.model.primaire.Vitesse;
import com.example.carws.model.voiture.Voiture;

public class CarRequest{
          
          String categorie;
          String carburant;
          double kilometrage;
          String marque;
          String modele;
          String moteur;
          String type;
          String vitesse;
          
          public Voiture toVoiture(){
                    Categorie c = new Categorie();
                    c.setId(this.getCategorie());
                    Carburant ca = new Carburant();
                    ca.setId(this.getCarburant());
                    Marque m = new Marque();
                    m.setId(this.getMarque());
                    Modele mo = new Modele();
                    mo.setId( this.getModele() );
                    Moteur mot = new Moteur();
                    mot.setId(this.getMoteur());
                    TypeMoteur t = new TypeMoteur();
                    t.setId(this.getType());
                    Vitesse v =new Vitesse();
                    v.setId(this.getVitesse());
                    
                    Voiture voiture = new Voiture();
                    voiture.setCategorie(c);
                    voiture.setKilometrage(this.getKilometrage());
                    voiture.setModele(mo);
                    voiture.setMoteur(mot);
                    voiture.setVitesse(v);
                    
                    return voiture;
                    
          }

          public String getVitesse() {
                    return vitesse;
          }

          public void setVitesse(String vitesse) {
                    this.vitesse = vitesse;
          }
          
          

          public String getCategorie() {
                    return categorie;
          }

          public void setCategorie(String categorie) {
                    this.categorie = categorie;
          }

          public String getCarburant() {
                    return carburant;
          }

          public void setCarburant(String carburant) {
                    this.carburant = carburant;
          }

          public double getKilometrage() {
                    return kilometrage;
          }

          public void setKilometrage(double kilometrage) {
                    this.kilometrage = kilometrage;
          }

          public String getMarque() {
                    return marque;
          }

          public void setMarque(String marque) {
                    this.marque = marque;
          }

          public String getModele() {
                    return modele;
          }

          public void setModele(String modele) {
                    this.modele = modele;
          }

          public String getMoteur() {
                    return moteur;
          }

          public void setMoteur(String moteur) {
                    this.moteur = moteur;
          }

          public String getType() {
                    return type;
          }

          public void setType(String type) {
                    this.type = type;
          }
          
          
}