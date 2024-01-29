package com.example.carws.model.statistics;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table( name = "commission" )
public class Commission {
	
	@Id
	@Column( name = "id_commission" )
	Integer id;

	@Column( name = "minimum" )
	Integer minimum;

	@Column( name = "maximum" )
	Integer maximum;

    @Column( name = "commission" )
	Integer commission;


	public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getMaximum(){
        return this.maximum;
    }

    public void setMaximum(Integer maximum){
        this.maximum = maximum;
    }

    public Integer getMinimum(){
        return this.minimum;
    }

    public void setMinimum(Integer minimum){
        this.minimum = minimum;
    }

    public Integer getCommission(){
        return this.commission;
    }

    public void setCommission(Integer commission){
        this.commission = commission;
    }

    public Commission(){
        
    }

}