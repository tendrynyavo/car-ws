package com.example.carws.model.annonce;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table( name = "validate_annonce" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class ValidateAnnonce{
	@Id
	@Column( name = "id_annonce_valide", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_annonce")
    Annonce annonce;

    @Column( name = "date_time_validation" )
	Timestamp datetimevalidation;

	public void setId( Integer id ){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

    public void setAnnonce(Annonce annonce){
        this.annonce = annonce;
    }

    public Annonce getAnnonce(){
        return this.annonce;
    }

    public void setDatetimevalidation(Timestamp dateheure){
        this.datetimevalidation = dateheure;
    }

    public Timestamp getDatetime(){
        return this.datetimevalidation;
    }

	public ValidateAnnonce(){

	}

	public ValidateAnnonce( Timestamp dateheure ) throws Exception{
        this.setDatetimevalidation(dateheure);
	}

}