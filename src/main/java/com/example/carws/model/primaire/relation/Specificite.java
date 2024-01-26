package com.example.carws.model.primaire.relation;

import jakarta.persistence.*;
import com.example.carws.model.primaire.*;

import com.example.carws.utility.IdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table( name = "specificite" )
public class Specificite{
        @Id
	@Column( name = "id_specificite" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "SPC"), @Parameter( name = "sequence", value = "seq_specificite" ), @Parameter( name = "max_length", value = "7" ) }  )
        @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

	@ManyToOne
        @JoinColumn(name="id_modele")
	Modele modele;

	@ManyToOne(targetEntity = Moteur.class)
        @JoinColumn(name="id_moteur")
	Moteur moteur;

          public String getId() {
                    return id;
          }

          public void setId(String id) {
                    this.id = id;
          }

          public Modele getModele() {
                    return modele;
          }

          public void setModele(Modele modele) {
                    this.modele = modele;
          }

          public Moteur getMoteur() {
                    return moteur;
          }

          public void setMoteur(Moteur moteur) {
                    this.moteur = moteur;
          }
    
          

}