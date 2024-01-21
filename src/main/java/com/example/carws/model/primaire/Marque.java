package com.example.carws.model.primaire;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;
import java.util.*;

@Entity
@Table( name = "marque" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Marque{
	@Id
	@Column( name = "id_marque", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column( name = "nom_marque" )
	String nom;
	@Column( name = "deleted" )
	boolean deleted;

	@OneToMany( mappedBy ="marque", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	// @JsonManagedReference("modele")
	List<Modele> modeles;

	public void setModeles(List<Modele> modeles){
		this.modeles = modeles;
	}
	public List<Modele> getModeles(){
		return this.modeles;
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
			throw new Exception("Le nom de categorie ne peut etre nulle");
		}
		this.nom = nom;
	}

	public Marque(){

	}

	public Marque( String nom ) throws Exception{
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
	// public Categorie[] test() throws Exception{
	// 	Categorie[] categories = new Categorie[3];
	// 	categories[0] = new Categorie("Camion");
	// 	categories[1] = new Categorie("Plaisir");
	// 	categories[2] = new Categorie("Mini Bus");
	// 	return categories;
	// }

}