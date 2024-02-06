package com.example.carws.model.annonce;

// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.*;
import java.util.Base64;

import jakarta.persistence.*;

import com.example.carws.utility.IdGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "photo" )

public class AnnoncePhoto{
	@Id
    @Column(name="id_photo")
    @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@org.hibernate.annotations.Parameter(name = "prefix" , value = "ANP"), @org.hibernate.annotations.Parameter( name = "sequence", value = "seq_photo" ), @org.hibernate.annotations.Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

    @ManyToOne
    @JoinColumn(name="id_annonce", nullable=false)
    @JsonManagedReference("annonce")
    Annonce annonce;

    @Column( name = "file")
    byte[] bytes;

    String photo;

    public void setBytes(byte[] bytes){
    	this.bytes = bytes;
    }
    public byte[] getBytes(){
    	return this.bytes;
    }

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

    public void setPhoto(String photo) throws Exception{
        this.photo = photo;
        this.decode();
    }

    public void decode() throws Exception{
    	byte[] decoded = Base64.getDecoder().decode( this.getPhoto() );
    	this.setBytes( decoded );
    }

    public String getPhoto(){
        return this.photo;
    }

	public AnnoncePhoto(){

	}

	public AnnoncePhoto( String photo ) throws Exception{
        this.setPhoto(photo);
	}

}