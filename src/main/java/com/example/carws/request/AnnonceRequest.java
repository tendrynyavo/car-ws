package com.example.carws.request;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.model.annonce.DetailsAnnonce;
import com.example.carws.model.annonce.AnnoncePhoto;

public class AnnonceRequest {
    
    Annonce annonce;
    DetailsAnnonce details;
    AnnoncePhoto[] photos;

    public void setAnnonce(Annonce annonce){
        this.annonce = annonce;
    }

    public Annonce getAnnonce(){
        return this.annonce;
    }

    public void setDetails(DetailsAnnonce details){
        this.details = details;
    }

    public DetailsAnnonce getDetails(){
        return this.details;
    }

    public void setPhotos(AnnoncePhoto[] photos){
        this.photos = photos;
    }

    public AnnoncePhoto[] getPhotos(){
        return this.photos;
    }

    public AnnonceRequest(){

    }

}
