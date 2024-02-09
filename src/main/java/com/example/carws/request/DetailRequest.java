package com.example.carws.request;

import com.example.carws.model.annonce.*;
import com.example.carws.model.primaire.*;

public class DetailRequest{

	String valeur;
	String caracteristique;

	public void setValeur(String value){
		this.valeur = value;
	}

	public String getValeur(){
		return this.valeur;
	}

	public void setCaracteristique(String caracteristique){
		this.caracteristique = caracteristique;
	}
	public String getCaracteristique(){
		return this.caracteristique;
	}

	public DetailsAnnonce toDetailAnnonce(){
		DetailsAnnonce	detail = new DetailsAnnonce();
		Caracteristique c = new Caracteristique();
		c.setId( this.getCaracteristique() );
		detail.setValeur( this.getValeur() );
		detail.setCaracteristique( c );
		return detail;
	}

}