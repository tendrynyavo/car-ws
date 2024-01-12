package com.example.carws.model.primaire;

import jakarta.persistence.*;

@Entity
@Table( name = "modele" )
public class Modele{
	@Id
	@Column( name = "id_modele", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	// @Column
	@Column( name = "nom_modele" )
	String nom;
	@Column( name = "deleted" )
	boolean deleted;

	public boolean getDeleted(){
		return this.deleted;
	}

	public void setDeleted( boolean bool ){
		this.deleted = bool;
	}

	public void setId( Integer id ){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setNom( String nom ) throws Exception{
		if( nom == null || nom.isEmpty() ){
			throw new Exception("Le modele ne peut etre vide");
		}
		this.nom = nom;
	}

	public String getNom(){
		return this.nom;
	}


	public Modele(){

	}

	public Modele( String nom ) throws Exception{
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