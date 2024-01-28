package com.example.carws.model.primaire;

import com.example.carws.utility.IdGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table( name = "moteur" )
public class Moteur{

         @Id
         @Column( name = "id_moteur" )
         @GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "MOT"), @Parameter( name = "sequence", value = "seq_moteur" ),             @Parameter( name = "max_length", value = "7" ) }  )
          @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;
         @Column
         String nom;
         @Column
         Integer cylindre;
         @Column
         Double puissance;
         @Column
         String configuration;
         
         @ManyToOne
          @JoinColumn( name = "id_marque" )
         Marque marque;
         
         @ManyToOne
         @JoinColumn( name = "id_type" )
         TypeMoteur type;
         
         @ManyToOne
         @JoinColumn( name = "id_carburant" )
         Carburant carburant;

         @Column( name = "deleted" )
	    boolean deleted;

          public String getId() {
                    return id;
          }

          public void setId(String id) {
                    this.id = id;
          }

          public String getNom() {
                    return nom;
          }

          public void setNom(String nom) {
                    this.nom = nom;
          }

          public Integer getCylindre() {
                    return cylindre;
          }

          public void setCylindre(Integer cylindre) {
                    this.cylindre = cylindre;
          }

          public Double getPuissance() {
                    return puissance;
          }

          public void setPuissance(Double puissance) {
                    this.puissance = puissance;
          }

          public String getConfiguration() {
                    return configuration;
          }

          public void setConfiguration(String configuration) {
                    this.configuration = configuration;
          }

          public Marque getMarque() {
                    return marque;
          }

          public void setMarque(Marque marque) {
                    this.marque = marque;
          }


	public TypeMoteur getType() {
			return type;
	}


          public void setType(TypeMoteur type) {
                    this.type = type;
          }

          public Carburant getCarburant() {
                    return carburant;
          }

          public void setCarburant(Carburant carburant) {
                    this.carburant = carburant;
          }
          
        public boolean getDeleted(){
            return this.deleted;
        }
    
        public void setDeleted( boolean bool ){
            this.deleted = bool;
        }
}