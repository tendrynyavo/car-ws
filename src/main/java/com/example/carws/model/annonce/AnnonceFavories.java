package com.example.carws.model.annonce;

import java.sql.Date;

import com.example.carws.model.users.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import com.example.carws.utility.IdGenerator;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

@Entity
@Table( name = "favori" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class AnnonceFavories{
	@Id
	@Column( name = "id_favori" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "FAV"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_favori" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_annonce")
    Annonce annonce;

    @ManyToOne
	@JoinColumn(name = "id_utilisateur")
    @JsonBackReference
    Users user;

    @Column( name = "date_ajout" )
	Date date;

	public void setId( String id ){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

    public void setAnnonce(Annonce annonce){
        this.annonce = annonce;
    }

    public Annonce getAnnonce(){
        return this.annonce;
    }

    public void setUser(Users user){
        this.user = user;
    }

    public Users getUser(){
        return this.user;
    }

    public void setDate(Date dateheure){
        this.date = dateheure;
    }

    public Date getDatetime(){
        return this.date;
    }

	public AnnonceFavories(){

	}

	public AnnonceFavories( Date date ) throws Exception{
        this.setDate(date);
	}

}