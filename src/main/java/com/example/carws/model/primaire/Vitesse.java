package com.example.carws.model.primaire;

import com.example.carws.model.voiture.Voiture;
import com.example.carws.utility.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "boite_vitesse" )
public class Vitesse{
	@Id
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "BDV"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_boite_vitesse" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
        @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
        @Column( name = "id_boite" )
	String id;
	@Column( name = "nom", nullable = false )
	String nom;
	@Column( name = "deleted" )
	boolean deleted;

	@OneToMany(mappedBy = "vitesse")
	@JsonIgnore
	List<Voiture> voiture;

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
			throw new Exception("Le nom de categorie ne peut etre nulle");
		}
		this.nom = nom;
	}

	public Vitesse(){

	}

	public Vitesse( String nom ) throws Exception{
		this.setNom(nom);
	}

	public String getNom(){
		return this.nom;
	}

}