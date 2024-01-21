package com.example.carws.model.primaire;

import jakarta.persistence.*;
import java.util.*;

public class Moteur{

	Integer id;
	Marque marque;
	Modele modele;
	Carburant carburant;
	double puissance;
	double cylindre;
	String configuration;

	Set<Modele> modelesCompatibles;

	public void setModelesCompatibles(Set<Modele> compatibles){
		this.modelesCompatibles = compatibles;
	}
	public Set<Modele> getModelesCompatibles(){
		return this.modelesCompatibles;
	}

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}

	public void setMarque( Marque marque ){
		this.marque = marque;
	}
	public Marque getMarque(){
		return this.marque;
	}

	public void setModele(Modele modele){
		this.modele = modele;
	}

	public Modele getModele(){
		return this.modele;
	}

	public void setCarburant( Carburant carburant ){
		this.carburant = carburant;
	}
	public Carburant getCarburant(){
		return this.carburant;
	}

	public void setPuissance( double puissance ) throws Exception{
		if( puissance < 0 ) throw new Exception("La puissance de l'automobile ne doit pas etre negatif");
		this.puissance = puissance;
	}

	public double getPuissance(){
		return this.puissance;
	}

	public void setCylindre(double cylindre){
		this.cylindre = cylindre;
	}
	public double getCylindre(){
		return this.cylindre;
	}

	public void setConfiguration( String conf ){
		this.configuration = conf;
	}
	public String getConfiguration(){
		return this.configuration;
	}

}