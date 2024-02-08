package com.example.carws.request;

import com.example.carws.model.annonce.*;

public class PhotoRequest{
	
	String photo;
	
	public void setPhoto( String p ){
		this.photo = p;
	}

	public String getPhoto(){
		return this.photo;
	}

	public AnnoncePhoto toAnnoncePhoto() throws Exception{
		AnnoncePhoto p = new AnnoncePhoto( this.getPhoto() );
		return p;
	}
}