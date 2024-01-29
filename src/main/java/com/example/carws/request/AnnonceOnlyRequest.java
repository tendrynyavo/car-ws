package com.example.carws.request;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.model.primaire.Lieu;
import com.example.carws.model.users.Users;
import com.example.carws.model.voiture.Voiture;
import java.sql.Timestamp;

public class AnnonceOnlyRequest{
	Timestamp date;
	String description;
	double prix;
	String lieu;
	String user;
	int valeur;
	String voiture;

	public void setDate(Timestamp t){
		this.date = t;
	}
	public Timestamp getDate(){
		return this.date;
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return this.description;
	}

	public double getPrix(){
		return this.prix;
	}
	public void setPrix( double prix ){
		this.prix = prix;
	}

	public void setLieu(String lieu){
		this.lieu = lieu;
	}
	public String getLieu(){
		return this.lieu;
	}

	public void setUser(String lieu){
		this.user = lieu;
	}
	public String getUser(){
		return this.user;
	}

	public int getValeur(){
		return this.valeur;
	}
	public void setValeur(int v){
		this.valeur = v;
	}

	public void setVoiture(String v){
		this.voiture = v;
	}
	public String getVoiture(){
		return this.voiture;
	}
    
          public Annonce toAnnonce(){
                    Annonce n = new Annonce();
                    n.setDate(this.getDate());
                    Voiture v = new Voiture();
                    v.setId(this.getVoiture());
                    n.setVoiture(v);
                    n.setDescription( this.getDescription() );
                    Lieu l = new Lieu();
                    l.setId(this.getLieu());
                    n.setLieu(l);
                    n.setValeur(this.getValeur());
                    n.setPrix(this.getPrix());
                    Users u = new Users(this.getUser());
                    n.setUser(u);
                    return n;
          }
    
//    Mila avadika annonce

}