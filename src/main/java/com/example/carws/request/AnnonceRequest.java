package com.example.carws.request;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.model.annonce.AnnoncePhoto;
import com.example.carws.model.annonce.DetailsAnnonce;
import java.util.List;
import java.util.ArrayList;
import com.example.carws.model.annonce.AnnoncePhoto;

public class AnnonceRequest {

    // PhotoRequest[] photos;
    Annonce annonce;
    DetailsAnnonce details;
    AnnoncePhoto[] photos;

    public void setAnnonce(Annonce annonce){
        System.out.println("Ato be fotsiny");
        this.annonce = annonce;
    }

    // public void setPhotos( PhotoRequest[] photos ){
    //     this.photos = photos;
    // }
    // public PhotoRequest[] getPhotos(){
    //     return this.photos;
    // }
    public void setPhotos( AnnoncePhoto[] photos ){
        this.photos = photos;
    }
    public AnnoncePhoto[] getPhotos(){
        return this.photos;
    }

    public Annonce getAnnonce() throws Exception{
        // formatAnnonce();
        return this.annonce;
    }

    // public void formatAnnonce() throws Exception{
    //     try{
    //         List<AnnoncePhoto> pics = new ArrayList<>();
    //         for( int i = 0; i < this.getPhotos().length ; i++ ){
    //             pics.add(this.getPhotos()[i].toAnnoncePhoto());
    //         }
    //         this.annonce.setPhotos( pics );

    //     }catch(Exception e){
    //         e.printStackTrace();
    //         throw e;
    //     }
    // }

    public void setDetails(DetailsAnnonce details){
        this.details = details;
    }

    public DetailsAnnonce getDetails(){
        return this.details;
    }

    public AnnonceRequest(){
    }

}
