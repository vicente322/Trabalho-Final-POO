package poo;

import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author @gfgiaretta
 * 
 * @version 2022-11-24
 */

public class ImageFactory{
    private static ImageFactory imgf = new ImageFactory();
    private Map<String,Image> images;
    
    public static ImageFactory getInstance(){
        return(imgf);
    }
    
    private ImageFactory(){
        images = new HashMap<>();
    }
    
    private String id2File(String imgId){
        switch(imgId){
            case "bellsprout" : return("/imagens/Bellsprout.png");
            case "eevee" : return("/imagens/Eevee.png");
            case "farfetchd" : return("/imagens/Farfetchd.png");
            case "flareon" : return("/imagens/Flareon.png");
            case "gloom" : return("/imagens/Gloom.png");
            case "herdier" : return("/imagens/Herdier.png");
            case "lillipup" : return("/imagens/Lillipup.png");
            case "magmar" : return("/imagens/Magmar.png");
            case "ninetales" : return("/imagens/Ninetales.png");
            case "oddish" : return("/imagens/Oddish.png");
            case "vulpix" : return("/imagens/Vulpix.png");
            case "weepinbell" : return("/imagens/Weepinbell.png");
            case "hau" : return("/imagens/Hau.png");
            case "potion" : return("/imagens/Potion.png");
            case "fullheal" : return("/imagens/FullHeal.png");
            case "fireenergy" : return("/imagens/FireEnergy.png");
            case "grassenergy" : return("/imagens/GrassEnergy.png");
            case "alolansandshrew" : return("/imagens/AlolanSandshrew.png");
            case "alolansandslash" : return("/imagens/AlolanSandslash.png");
            case "aron" : return("/imagens/Aron.png");
            case "corvisquire" : return("/imagens/Corvisquire.png");
            case "lairon" : return("/imagens/Lairon.png");
            case "piplup" : return("/imagens/Piplup.png");
            case "prinplup" : return("/imagens/Prinplup.png");
            case "rookidee" : return("/imagens/Rookidee.png");
            case "skwovet" : return("/imagens/Skwovet.png");
            case "staravia" : return("/imagens/Staravia.png");
            case "starly" : return("/imagens/Starly.png");
            case "waterenergy" : return("/imagens/WaterEnergy.png");
            case "steelenergy" : return("/imagens/SteelEnergy.png");
            case "imgBck" : return("/imagens/Back.png");
            default: throw new IllegalArgumentException("Invalid image Id");
        }
    }
    
    public ImageView createImage(String imgId){
        Image img = images.get(imgId);
        if (img == null){
            img = new Image(id2File(imgId));
            images.put(imgId,img);
        }
        
        ImageView imgv = new ImageView(img);
        return(imgv);
    }
}