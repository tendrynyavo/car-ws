package com.example.carws.model.primaire;

import com.example.carws.model.primaire.relation.Specificite;
import com.example.carws.utility.IdGenerator;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table( name = "moteur" )
public class Moteur{

	@Id
	@Column( name = "id_moteur" )
	@GenericGenerator( name = "custom-id", type = IdGenerator.class, parameters = {@Parameter(name = "prefix" , value = "MOT"), @Parameter( name = "sequence", value = "seq_moteur" ), @Parameter( name = "max_length", value = "7" ) }  )
    @GeneratedValue(generator = "custom-id" , strategy = GenerationType.IDENTITY)
	String id;

	@ManyToOne
	@JoinColumn(name = "id_marque")
	Marque marque;

	@ManyToOne
	@JoinColumn( name = "id_carburant" )
	Carburant carburant;

	double puissance;

	double cylindre;

	@ManyToOne
	@JoinColumn(name = "id_type")
	TypeMoteur type;

	String configuration;
          
	@OneToMany( mappedBy = "moteur",  fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	Set<Specificite> specifites;

	public Set<Specificite> getSpecifites() {
			return specifites;
	}

	public void setSpecifites(Set<Specificite> specifites) {
			this.specifites = specifites;
	}
          
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}

	public void setMarque( Marque marque ){
		this.marque = marque;
	}
	public Marque getMarque(){
		return this.marque;
	}

	public void setCarburant( Carburant carburant ){
		this.carburant = carburant;
	}
	public Carburant getCarburant(){
		return this.carburant;
	}

	public void setPuissance( double puissance ) throws Exception{
		if( puissance < 0 ) throw new Exception("La puissance de l'automobile ne doit pas etre negatif");
		this.puissance = puissance;
	}

	public double getPuissance(){
		return this.puissance;
	}

	public void setCylindre(double cylindre){
		this.cylindre = cylindre;
	}
	public double getCylindre(){
		return this.cylindre;
	}

	public void setConfiguration( String conf ){
		this.configuration = conf;
	}

	public String getConfiguration(){
		return this.configuration;
	}

	public TypeMoteur getType() {
			return type;
	}

	public void setType(TypeMoteur type) {
			this.type = type;
	}
            
}