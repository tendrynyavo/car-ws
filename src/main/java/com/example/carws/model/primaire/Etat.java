package com.example.carws.model.primaire;

import jakarta.persistence.*;

@Entity
@Table( name = "etat" )
public class Etat {
	@Id
	@Column( name = "valeur", unique = true, nullable = false)
	Integer valeur;
	@Column( name = "designation" )
	String nom;

	public void setValeur( Integer id ){
		this.valeur = id;
	}

	public Integer getValeur(){
		return this.valeur;
	}

	public void setNom( String nom ) throws Exception{
		if( nom == null || nom.isEmpty() ){
			throw new Exception("La désignation de l'état ne peut etre nulle");
		}
		this.nom = nom;
	}

    public String getNom(){
		return this.nom;
	}

	public Etat(){

	}

	public Etat( int id, String nom ) throws Exception{
                   this.setValeur(id);
		this.setNom(nom);
	}

	/*
	 * 
	 * Get static data for category
	 * 
	 */
	// public Categorie[] test() throws Exception{
	// 	Categorie[] categories = new Categorie[3];
	// 	categories[0] = new Categorie("Camion");
	// 	categories[1] = new Categorie("Plaisir");
	// 	categories[2] = new Categorie("Mini Bus");
	// 	return categories;
	// }

}