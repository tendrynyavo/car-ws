package com.example.carws.model.primaire.relation;

import jakarta.persistence.*;
import com.example.carws.model.primaire.*;

@Entity
@Table(name = "design")
public class Design {
	
	@Id
	@Column(name="id_design")
	Integer id;

	@ManyToOne
	@JoinColumn(name="id_modele")
	Modele modele;

	@ManyToOne
	@JoinColumn( name = "id_categorie" )
	Categorie categorie;

	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
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