 package poo;

import java.util.*;

/**
 * 
 * @author @gfgiaretta
 * 
 * @version 2022-11-24
 */

public class Card extends Observable{
    private String id;
    private String imageId;
    private boolean faceUp;
    private String nome;
    
    public Card(String nome, String anId, String anImageId){
        this.nome = nome;
        id = anId;
        imageId = anImageId;
        faceUp = true;
    }
    
    public String getId(){
        return(id);
    }
    
    public String getImageId(){
        return(imageId);
    }
    
    public boolean isFacedUp(){
        return(faceUp);
    }

    public String getNome() {
        return nome;
    }
    
    public void flip(){
        if (faceUp == true){
            faceUp = false;
        }else{
            faceUp = true;
        }
        setChanged();
        notifyObservers();
    }
}