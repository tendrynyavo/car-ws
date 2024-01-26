package com.example.carws.model.primaire;

import jakarta.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.*;
import com.example.carws.model.primaire.relation.*;
import com.example.carws.model.voiture.Voiture;
import com.example.carws.utility.IdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table( name = "categorie" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Categorie{
	@Id
	@Column( name = "id_categorie"  )
          
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "CAT"), @Parameter( name = "sequence", value = "seq_categorie" ), @Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;
	
	@Column( name = "nom" )
	String nom;
	@Column( name = "deleted" )
	boolean deleted;

	@OneToMany( mappedBy = "categorie" )
	Set<Design> modeles;

	@OneToOne(mappedBy = "categorie")
	Voiture voiture;
    
	public void setDesigns( Set<Design> modeles ){
		this.modeles = modeles;
	}

	public Set<Design> getDesigns(){
		return this.modeles;
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