package com.example.carws.model.primaire;

import jakarta.persistence.*;

@Entity
@Table( name = "categorie" )
public class Categorie{
	@Id
	@Column( name = "id_categorie", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	// @Column
	@Column( name = "nom_categorie" )
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
			throw new Exception("Le nom de categorie ne peut etre nulle");
		}
		this.nom = nom;
	}

	public Categorie(){

	}

	public Categorie( String nom ) throws Exception{
		this.setNom(nom);
	}

	public String getNom(){
		return this.nom;
	}

	/*
	 * 
	 * Get static data for category
	 * 
	 */
	public Categorie[] test() throws Exception{
		Categorie[] categories = new Categorie[3];
		categories[0] = new Categorie("Camion");
		categories[1] = new Categorie("Plaisir");
		categories[2] = new Categorie("Mini Bus");
		return categories;
	}

}