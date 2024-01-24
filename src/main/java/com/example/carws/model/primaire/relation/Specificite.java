package com.example.carws.model.primaire.relation;

import jakarta.persistence.*;
import com.example.carws.model.primaire.*;

@Entity
@Table( name = "specificite" )
public class Specificite{
	@Id
	@Column(name = "id_specificite")
	Integer id;
	@ManyToOne
        @JoinColumn(name="id_modele")
	Modele modele;
	@ManyToOne(targetEntity = Moteur.class)
        @JoinColumn(name="id_moteur")
	Moteur moteur;

          public Integer getId() {
                    return id;
          }

          public void setId(Integer id) {
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