package com.example.carws.model.annonce;

import com.example.carws.model.voiture.Voiture;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;

@Entity
@Table( name = "detail_annonce" )
@JsonIdentityInfo(
 generator = ObjectIdGenerators.PropertyGenerator.class, 
 property = "id")
public class DetailsAnnonce{
	@Id
	@Column( name = "id_detail_annonce", columnDefinition = "serial" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

    @Column( name = "description" )
	String description;

    @OneToOne
    @JoinColumn(name = "id_annonce")
    @JsonBackReference
    Annonce annonce;

    @OneToOne(mappedBy = "detailsAnnonce")
	@JsonManagedReference
    Voiture voiture;

	public void setId( Integer id ){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

    public void setDescription( String description ){
		this.description = description;
	}

	public String getDescription(){
		return this.description;
	}

    public void setAnnonce(Annonce annonce){
        this.annonce = annonce;
    }

    public Annonce getAnnonce(){
        return this.annonce;
    }

    public void setVoiture(Voiture voiture){
        this.voiture = voiture;
    }

    public Voiture getVoiture(){
        return this.voiture;
    }

	public DetailsAnnonce(){

	}

	public DetailsAnnonce( String description ) throws Exception{
        this.setDescription(description);
	}

}