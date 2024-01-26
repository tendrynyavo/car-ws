// package com.example.carws.model.annonce;

// import java.sql.Date;

// import com.example.carws.model.users.Users;
// import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonIdentityInfo;
// import com.fasterxml.jackson.annotation.JsonManagedReference;
// import com.fasterxml.jackson.annotation.ObjectIdGenerators;

// import jakarta.persistence.*;

// @Entity
// @Table( name = "favoris" )
// @JsonIdentityInfo(
//  generator = ObjectIdGenerators.PropertyGenerator.class, 
//  property = "id")
// public class AnnonceFavories{
// 	@Id
// 	@Column( name = "id_favoris", columnDefinition = "serial" )
// 	@GeneratedValue(strategy = GenerationType.IDENTITY)
// 	Integer id;

//     @OneToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "id_annonce")
//     @JsonManagedReference("annonce-favoris")
//     Annonce annonce;

//     @ManyToOne
//     @JoinColumn(name="id_user", nullable=false)
//     Users user;

//     @Column( name = "date_ajout" )
// 	Date date;

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

//     public void setUser(Users user){
//         this.user = user;
//     }

//     public Users getUser(){
//         return this.user;
//     }

//     public void setDate(Date dateheure){
//         this.date = dateheure;
//     }

//     public Date getDatetime(){
//         return this.date;
//     }

// 	public AnnonceFavories(){

// 	}

// 	public AnnonceFavories( Date date ) throws Exception{
//         this.setDate(date);
// 	}

// }