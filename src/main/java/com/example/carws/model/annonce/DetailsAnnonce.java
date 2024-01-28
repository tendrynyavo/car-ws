package com.example.carws.model.annonce;

import com.example.carws.model.primaire.Caracteristique;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.example.carws.utility.IdGenerator;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

@Entity
@Table( name = "detail" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class DetailsAnnonce{
	@Id
	@Column( name = "id_detail" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "DTL"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_detail" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

    @Column( name = "valeur" )
	String valeur;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_caracteristique")
    Caracteristique caracteristique;

    @OneToOne
    @JoinColumn(name = "id_annonce")
    @JsonIgnore
    Annonce annonce;

	public void setId( String id ){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

    public void setValeur( String valeur ){
		this.valeur = valeur;
	}

	public String getValeur(){
		return this.valeur;
	}

    public void setCaracteristique( Caracteristique caracteristique ){
        this.caracteristique = caracteristique;
    }

    public Caracteristique getCaracteristique(){
        return this.caracteristique;
    }

    public void setAnnonce(Annonce annonce){
        this.annonce = annonce;
    }

    public Annonce getAnnonce(){
        return this.annonce;
    }

	public DetailsAnnonce(){

	}

	public DetailsAnnonce( String valeur ) throws Exception{
        this.setValeur(valeur);
	}

}