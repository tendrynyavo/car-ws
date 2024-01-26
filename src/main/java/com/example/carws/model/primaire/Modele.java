package com.example.carws.model.primaire;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.*;

import java.sql.Date;
import java.util.Set;
import com.example.carws.model.primaire.relation.*;
import com.example.carws.utility.IdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table( name = "modele" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")

public class Modele{
	
	@Id
	@Column( name = "id_modele", columnDefinition = "serial" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "MOD"), @Parameter( name = "sequence", value = "seq_modele" ), @Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

	@ManyToOne
	@JoinColumn( name = "id_marque", nullable = false )
	Marque marque;

	@Column( name = "nom" , nullable = false )
	String nom;
	
	@Column( name = "deleted" )
	boolean deleted;
          
    @Column( name = "annee" )
    Date annee;

	

	public Date getAnnee() {
			return annee;
	}

	public void setAnnee(Date annee) {
			this.annee = annee;
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

	public void setId( String id ){
		this.id = id;
	}

	public String getId(){
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