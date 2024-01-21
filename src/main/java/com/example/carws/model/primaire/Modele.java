package com.example.carws.model.primaire;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.util.Set;

@Entity
@Table( name = "modele" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Modele{
	
	@Id
	@Column( name = "id_modele", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@ManyToOne
	@JoinColumn( name = "id_marque", nullable = false )
	Marque marque;

	@Column( name = "nom_modele" , nullable = false )
	String nom;
	
	@Column( name = "deleted" )
	boolean deleted;

	@ManyToMany
	@JoinTable(
		name = "a_modele_categorie",
		joinColumns = @JoinColumn(name = "id_modele"),
		inverseJoinColumns = @JoinColumn(name = "id_categorie")
	)
	Set<Categorie> categories;

	public void setCategories(Set<Categorie> cs){
		this.categories = cs;
	}

	public Set<Categorie> getCategories(){
		return this.categories;
	}

	public void setMarque(Marque marque){
		this.marque = marque;
	}
	public Marque getMarque(){
		return this.marque;
	}

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