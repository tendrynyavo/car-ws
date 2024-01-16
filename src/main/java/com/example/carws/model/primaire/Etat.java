package com.example.carws.model.primaire;

import jakarta.persistence.*;

@Entity
@Table( name = "etats" )
public class Etat {
	@Id
	@Column( name = "id")
	Integer id;
	// @Column
	@Column( name = "nom" )
	String nom;

	public void setId( Integer id ){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setNom( String nom ) throws Exception{
		if( nom == null || nom.isEmpty() ){
			throw new Exception("Le nom de categorie ne peut etre nulle");
		}
		this.nom = nom;
	}

    public String getNom(){
		return this.nom;
	}

	public Etat(){

	}

	public Etat( int id, String nom ) throws Exception{
        this.setId(id);
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