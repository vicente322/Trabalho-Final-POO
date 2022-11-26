package poo;

import java.util.*;

/**
 * Class que define objetos Card
 * 
 * @author @gfgiaretta
 * @author @vicente322
 * 
 * @version 2022-11-25
 */

public abstract class Card extends Observable{
    private String nome;
    private String id;
    private String imageId;
    
    public Card(String nome,String anId,String anImageId){
        this.nome = nome;
        id = anId;
        imageId = anImageId;
    }
    
    public String getNome() {
        return nome;
    }

    public String getId(){
        return(id);
    }
    
    public String getImageId(){
        return(imageId);
    }
}