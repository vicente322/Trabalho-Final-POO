package poo;

import java.util.*;

public class Card extends Observable{
    private String id;
    private String imageId;
    private int value;
    private boolean faceUp;
    
    public Card(String anId,String anImageId,int val){
        id = anId;
        imageId = anImageId;
        value = val;
        faceUp = true;
    }
    
    public String getId(){ //Retorna id da carta
        return(id);
    }
    
    public String getImageId(){ //Retorna id da imagem da carta
        return(imageId);
    }
    
    public int getValue(){ //Retorna valor da carta
        return(value);
    }
    
    public boolean isFacedUp(){ //confere se esta virada para cima
        return(faceUp);
    }
    
    public void flip(){ //vira a carta
        if (faceUp == true){
            faceUp = false;
        }else{
            faceUp = true;
        }
        setChanged();
        notifyObservers();
    }
}
        

