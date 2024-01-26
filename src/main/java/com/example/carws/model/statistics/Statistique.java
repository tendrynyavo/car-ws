package com.example.carws.model.statistics;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table( name = "v_stats" )
public class Statistique {
	
	@Id
	@Column( name = "nom" )
	String label;
	@Column( name = "total" )
	Integer nombreAnnonce;
	@Column( name = "annee" )
	Integer annee;

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return this.label;
	}

	public void setNombreAnnonce( Integer nombre ){
		this.nombreAnnonce = nombre;
	}

	public Integer getNombreAnnonce(){
		return this.nombreAnnonce;
	}

	public void setAnnee( Integer an ){
		this.annee = an;
	}

	public Integer getAnnee(){
		return this.annee;
	}

	public String[] getMonthFromStatistics( Statistique[] stats ){
		List<String> month = new ArrayList<>();
		for( Statistique stat : stats ){
			month.add( stat.getLabel() );
		}
		return month.toArray( new String[0] );
	}

}