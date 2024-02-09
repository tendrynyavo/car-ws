package com.example.carws.request;

import com.example.carws.model.annonce.Annonce;
import com.example.carws.model.annonce.AnnoncePhoto;
import com.example.carws.model.annonce.DetailsAnnonce;
import java.util.List;
import java.util.ArrayList;
import com.example.carws.model.annonce.AnnoncePhoto;

public class AnnonceRequest {

    // PhotoRequest[] photos;

    String[] photos;

    AnnonceOnlyRequest annonce;
    DetailRequest details;
    // AnnoncePhoto[] photos;

    public void setAnnonce(AnnonceOnlyRequest annonce){
        System.out.println("Ato be fotsiny");
        this.annonce = annonce;
    }

    // public void setPhotos( PhotoRequest[] photos ){
    //     this.photos = photos;
    // }
    
    // public PhotoRequest[] getPhotos(){
    //     return this.photos;
    // }
    // public void setPhotos( AnnoncePhoto[] photos ){
    //     this.photos = photos;
    // }
    // public AnnoncePhoto[] getPhotos(){
    //     return this.photos;
    // }

    public AnnonceOnlyRequest getAnnonce() throws Exception{
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
    // 
    // public List<AnnoncePhoto> getAnnoncesPhotos() throws Exception{
    //     List<AnnoncePhoto> pics = new ArrayList<>();
    //     for( PhotoRequest photo : this.getPhotos() ){
    //         pics.add( photo.toAnnoncePhoto() );
    //     }
    //     // return pics.toArray(new AnnoncePhoto[0]);
    //     return pics;
    // }

    public void setDetails(DetailRequest details){
        this.details = details;
    }

    public DetailRequest getDetails(){
        return this.details;
    }

    public AnnonceRequest(){
    }

    public void setPhotos(String[] pics){
        this.photos = pics;
    }

    public String[] getPhotos(){
        return this.photos;
    }

    public List<AnnoncePhoto> getAnnoncesPhotosFromString() throws Exception{
        List<AnnoncePhoto> picss = new ArrayList<>();
        for( String photo : this.getPhotos() ){
            AnnoncePhoto an = new AnnoncePhoto();
            an.setPhoto( photo );
            picss.add( an );
        }
        // return pics.toArray(new AnnoncePhoto[0]);
        return picss;
    }

}
