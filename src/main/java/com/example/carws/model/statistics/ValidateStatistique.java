package com.example.carws.model.statistics;

import jakarta.persistence.*;

@Entity
@Table( name = "get_validate_annonce_by_year" )
public class ValidateStatistique {
	
	@Column( name = "annee" )
	Integer annee;

    @Id
    @Column( name = "mois")
	String mois;

    @Column( name = "nbr_annonce_valide")
    Integer validateAnnonceNumber;

	public void setAnnee( Integer an ){
		this.annee = an;
	}

	public Integer getAnnee(){
		return this.annee;
	}

    public void setValidateAnnonceNumber( Integer an ){
		this.validateAnnonceNumber = an;
	}

	public Integer getValidateAnnonceNumber(){
		return this.validateAnnonceNumber;
	}

    public String getMois(){
        return this.mois;
    }

    public void setMois(String mois){
        this.mois = mois;
    }

    public ValidateStatistique(){

    }

}