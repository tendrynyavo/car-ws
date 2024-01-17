package com.example.carws.model.voiture;

import com.example.carws.model.annonce.DetailsAnnonce;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table( name = "voiture_annonce" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Voiture{
	@Id
	@Column( name = "id_voiture_annonce", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column( name = "id_marque" )
	Integer idMarque;

	@Column( name = "id_modele" )
	Integer idModele;

    @Column( name = "id_carburant" )
	Integer idCarburant;

    @Column( name = "id_categorie" )
	Integer idCategorie;

    @Column( name = "id_transmission" )
	Integer idTransmission;

    @Column( name = "kilometrage" )
	double kilometrage;

    @Column( name = "annee" )
	Integer annee;

    @OneToOne
    @JoinColumn(name = "id_detail_annonce")
    @JsonBackReference("annonce-voiture")
    DetailsAnnonce detailsAnnonce;

    public DetailsAnnonce getDetails(){
        return this.detailsAnnonce;
    }

    public void setDetails(DetailsAnnonce details){
        this.detailsAnnonce = details;
    }

	public void setId(int id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setIdMarque(int idMarque){
        this.idMarque = idMarque;
    }

    public Integer getIdMarque(){
        return this.idMarque;
    }

    public void setIdModele(Integer idModele){
        this.idModele = idModele;
    }

    public Integer getIdModele(){
        return this.idModele;
    }

    public void setIdCarburant(Integer idCarburant){
        this.idCarburant = idCarburant;
    }

    public Integer getIdCarburant(){
        return this.idCarburant;
    }

    public void setIdCategorie(Integer idCategorie){
        this.idCategorie = idCategorie;
    }

    public Integer getIdCategorie(){
        return this.idCategorie;
    }

    public void setIdTransmission(Integer idTransmission){
        this.idTransmission = idTransmission;
    }

    public Integer getIdTransmission(){
        return this.idTransmission;
    }

    public void setKilometrage(double kilometrage){
        this.kilometrage = kilometrage;
    }

    public double getKilometrage(){
        return this.kilometrage;
    }

    public void setAnnee(int annee){
        this.annee = annee;
    }

    public Integer getAnnee(){
        return this.annee;
    }

	public Voiture(){

	}

	public Voiture(int idMarque, int idModele, int idCarburant, int idCategorie, int idTransmission, double kilometrage, int annee) {
        this.setIdMarque(idMarque);
        this.setIdModele(idModele);
        this.setIdCarburant(idCarburant);
        this.setIdCategorie(idCategorie);
        this.setIdTransmission(idTransmission);
        this.setKilometrage(kilometrage);
        this.setAnnee(annee);
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