// package com.example.carws.model.annonce;

// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// import com.fasterxml.jackson.annotation.JsonIdentityInfo;

// import jakarta.persistence.*;

// @Entity
// @Table( name = "annonce_photo" )
// @JsonIdentityInfo(
//  generator = ObjectIdGenerators.PropertyGenerator.class, 
//  property = "id")
// public class AnnoncePhoto{
// 	@Id
// 	@Column( name = "id_photo", columnDefinition = "serial" )
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	Integer id;

//     @ManyToOne
//     @JoinColumn(name="id_annonce", nullable=false)
//     Annonce annonce;

//     @Column( name = "photo")
//     String photo;

// 	public void setId( Integer id ){
// 		this.id = id;
// 	}

// 	public Integer getId(){
// 		return this.id;
// 	}

//     public void setAnnonce(Annonce annonce){
//         this.annonce = annonce;
//     }

//     public Annonce getAnnonce(){
//         return this.annonce;
//     }

//     public void setPhoto(String photo){
//         this.photo = photo;
//     }

//     public String getPhoto(){
//         return this.photo;
//     }

// 	public AnnoncePhoto(){

// 	}

// 	public AnnoncePhoto( String photo ) throws Exception{
//         this.setPhoto(photo);
// 	}

// }