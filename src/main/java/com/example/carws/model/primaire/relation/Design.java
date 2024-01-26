package com.example.carws.model.primaire.relation;

import jakarta.persistence.*;
import com.example.carws.model.primaire.*;

import com.example.carws.utility.IdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "design")
public class Design {
	
	@Id
	@Column( name = "id_design" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "DSG"), @Parameter( name = "sequence", value = "seq_design" ), @Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

	@ManyToOne
	@JoinColumn(name="id_modele")
	Modele modele;

	@ManyToOne
	@JoinColumn( name = "id_categorie" )
	Categorie categorie;

	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}

	public void setModel( Modele m ){
		this.modele = m;
	}
	public Modele getModele(){
		return this.modele;
	}

	public void setCategorie( Categorie c ){
		this.categorie = c;
	}
	public Categorie getCategorie(){
		return this.categorie;
	}
}