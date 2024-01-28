package com.example.carws.request;

import com.example.carws.model.primaire.*;

public class MarqueRequest{
	
	String nom;
	boolean deleted = false;

	public void setNom(String nom){
		this.nom = nom;
	}
	public String getNom(){
		return this.nom;
	}

	public void setDeleted(boolean f){
		this.deleted = f;
	}
	public boolean getDeleted(){
		return this.deleted;
	}

	public Marque toMarque() throws Exception{
		Marque m = new Marque();
		m.setNom(this.getNom());
		m.setDeleted(this.getDeleted());
		return m;
	}

}