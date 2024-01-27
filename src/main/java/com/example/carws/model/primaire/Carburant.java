package com.example.carws.model.primaire;

import com.example.carws.utility.IdGenerator;
import jakarta.persistence.*;
import java.util.Set;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table( name = "carburant" )
public class Carburant{
	@Id
	@Column( name = "id_carburant" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, 
		parameters = {
				@Parameter(name = "prefix" , value = "CRB"), 
				@Parameter( name = "sequence", value = "seq_carburant" ), 
				@Parameter( name = "max_length", value = "7" ) }  )
	@GeneratedValue( generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

	@Column( name = "nom" )
	String nom;

	@Column( name = "deleted" )
	boolean deleted;
          
//          @ManyToMany
            
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

	public Carburant(){

	}

	public Carburant( String nom ) throws Exception{
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