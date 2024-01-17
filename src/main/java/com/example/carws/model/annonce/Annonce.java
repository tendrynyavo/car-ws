package com.example.carws.model.annonce;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table( name = "annonce" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class Annonce{
	@Id
	@Column( name = "id_annonce", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Column( name = "date_heure_publication" )
	Timestamp dateheure;

	@Column( name = "id_user" )
	String user;

    @Column( name = "prix" )
	double prix;

    @OneToOne(mappedBy = "annonce")
	@JsonManagedReference("annonce-details")
	DetailsAnnonce details;


    @Column( name = "id_etat")
    Integer etat;

	@OneToOne(mappedBy = "annonce", cascade = CascadeType.ALL)
	AnnonceVendus vendu;

	@OneToOne(mappedBy = "annonce", cascade = CascadeType.ALL)
	@JsonManagedReference("annonce-validate")
	ValidateAnnonce validate;

	@OneToOne(mappedBy = "annonce", cascade = CascadeType.ALL)
	@JsonBackReference("annonce-favoris")
	AnnonceFavories favoris;

	@OneToMany(mappedBy="annonce")
	Set<AnnoncePhoto> photos;

	public void setId( Integer id ){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

    public void setDateheure( Timestamp date ){
		this.dateheure = date;
	}

	public Timestamp getDateheure(){
		return this.dateheure;
	}

	public void setUser( String user ) throws Exception {
		if( user == null || user.isEmpty() ){
			throw new Exception("L'id de l'utilisateur ne peut etre nulle");
		}
		this.user = user;
	}

    public String getUser(){
        return this.user;
    }

    public void setPrix( double prix ) throws Exception {
        if(prix < 0){
            throw new Exception("Le prix ne devrait pas etre negatif!");
        }
		this.prix = prix;
	}

	public double getPrix(){
		return this.prix;
	}

    public DetailsAnnonce getDetails(){
        return this.details;
    }

    public void setDetails(DetailsAnnonce details){
        this.details = details;
    }

    public void setEtat(int etat){
        this.etat = etat;
    }

    public Integer getEtat(){
        return this.etat;
    }

	public void setVendus(AnnonceVendus vendu){
		this.vendu = vendu;
	}

	public AnnonceVendus getVendus(){
		return this.vendu;
	}

	public void setValidate(ValidateAnnonce validate){
		this.validate = validate;
	}

	public ValidateAnnonce getValidate(){
		return this.validate;
	}

	public void setFavories(AnnonceFavories favories){
		this.favoris = favories;
	}

	public AnnonceFavories getFavories(){
		return this.favoris;
	}

	public void setPhotos(Set<AnnoncePhoto> photos){
		this.photos = photos;
	}

	public Set<AnnoncePhoto> getPhotos(){
		return this.photos;
	}

	public Annonce(){

	}

	public Annonce( Timestamp dateheure, String user, double prix , int etat) throws Exception{
		this.setDateheure(dateheure);
        this.setUser(user);
        this.setPrix(prix);
		this.setEtat(etat);
	}

}