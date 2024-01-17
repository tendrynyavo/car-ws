package com.example.carws.request;

import java.util.HashMap;

public class SearchedElements {
    Integer idCategorie;
    Integer idCarburant;
    Integer idTransmission;
    Integer idMarque;
    Integer idModele;

    double minIntervalle;
    double maxIntervalle;

    double kilometrage;
    Integer annee;

    String description;

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setKilometrage(double kilometrage){
        this.kilometrage = kilometrage;
    }

    public double getKilometrage(){
        return this.kilometrage;
    }

    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    public Integer getAnnee(){
        return this.annee;
    }

    public Integer getIdCategorie(){
        return this.idCategorie;
    }

    public void setIdCategorie(Integer idcategorie){
        this.idCategorie = idcategorie;
    }

    public Integer getIdCarburant(){
        return this.idCarburant;
    }

    public void setIdCarburant(Integer idcarburant){
        this.idCarburant = idcarburant;
    }

    public Integer getIdTransmission(){
        return this.idTransmission;
    }

    public void setIdTransmission(Integer idTransmission){
        this.idTransmission = idTransmission;
    }

    public Integer getIdMarque(){
        return this.idMarque;
    }

    public void setIdMarque(Integer idMarque){
        this.idMarque = idMarque;
    }

    public Integer getIdModele(){
        return this.idModele;
    }

    public void setIdModele(Integer idModele){
        this.idModele = idModele;
    }

    public double getMinIntervalle(){
        return this.minIntervalle;
    }

    public void setMinIntervalle(double min){
        this.minIntervalle = min;
    }

    public double getMaxIntervalle(){
        return this.maxIntervalle;
    }

    public void setMaxIntervalle(double max){
        this.maxIntervalle = max;
    }

    public SearchedElements(){

    }

    public HashMap<String, Object> allConditions(){
        HashMap<String, Object> conditions = new HashMap<>();

        conditions.put("idCategorie", this.getIdCategorie());
        conditions.put("idCarburant", this.getIdCarburant());
        conditions.put("idTransmission", this.getIdTransmission());
        conditions.put("idMarque", this.getIdMarque());
        conditions.put("idModele", this.getIdModele());
        conditions.put("annee", this.getAnnee());

        return conditions;
    }

}
