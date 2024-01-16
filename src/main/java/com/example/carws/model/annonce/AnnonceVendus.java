package com.example.carws.model.annonce;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table( name = "annonce_vendus" )
public class AnnonceVendus{
	@Id
	@Column( name = "id_annonce_vendus", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_annonce")
    Annonce annonce;

    @Column( name = "date_vendus" )
	Date date;

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

    public void setDate(Date dateheure){
        this.date = dateheure;
    }

    public Date getDatetime(){
        return this.date;
    }

	public AnnonceVendus(){

	}

	public AnnonceVendus( Date date ) throws Exception{
        this.setDate(date);
	}

}