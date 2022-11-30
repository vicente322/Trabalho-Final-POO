package poo;

import java.nio.file.Paths;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Classe para criar Image das cartas
 * 
 * @author @gfgiaretta
 * @author @vicente322
 * 
 * @version 2022-11-25
 */

public class ImageFactory{
    private static ImageFactory imgf = new ImageFactory();
    private Map<String,Image> images;
    private String currDir;
    private String fileDir;
    
    public static ImageFactory getInstance(){
      return(imgf);
    }
    
    private ImageFactory(){
        images = new HashMap<>();
    }
    
    private String id2File(String imgId){
        switch(imgId){
            case "bellsprout" : return("/Bellsprout.png");
            case "eevee" : return("/Eevee.png");
            case "farfetchd" : return("/Farfetchd.png");
            case "flareon" : return("/Flareon.png");
            case "gloom" : return("/Gloom.png");
            case "herdier" : return("/Herdier.png");
            case "lillipup" : return("/Lillipup.png");
            case "magmar" : return("/Magmar.png");
            case "ninetales" : return("/Ninetales.png");
            case "oddish" : return("/Oddish.png");
            case "vulpix" : return("/Vulpix.png");
            case "weepinbell" : return("/Weepinbell.png");
            case "hau" : return("/Hau.png");
            case "potion" : return("/Potion.png");
            case "fullheal" : return("/FullHeal.png");
            case "fireenergy" : return("/FireEnergy.png");
            case "grassenergy" : return("/GrassEnergy.png");
            case "alolansandshrew" : return("/AlolanSandshrew.png");
            case "alolansandslash" : return("/AlolanSandslash.png");
            case "aron" : return("/Aron.png");
            case "corvisquire" : return("/Corvisquire.png");
            case "lairon" : return("/Lairon.png");
            case "piplup" : return("/Piplup.png");
            case "prinplup" : return("/Prinplup.png");
            case "rookidee" : return("/Rookidee.png");
            case "skwovet" : return("/Skwovet.png");
            case "staravia" : return("/Staravia.png");
            case "starly" : return("/Starly.png");
            case "waterenergy" : return("/WaterEnergy.png");
            case "steelenergy" : return("/SteelEnergy.png");
            case "imgBck" : return("/Back.png");
            case "imgBckGrey" : return("/BackGrey.png");
            case "fullheart" : return("/fullHeart.png");
            case "halfheart": return ("/halfHeart.png");
            case "emptyheart": return ("/emptyHeart.png");
            case "coinFront": return ("/coinFront.png");
            case "coinBack": return ("/coinBack.png");
            case "pokeBall": return ("/pokeBall.png");
            default: throw new IllegalArgumentException("Invalid image Id");
        }
    }
    
    public ImageView createImage(String imgId){
        Image img = images.get(imgId);
        if (img == null){
            currDir = Paths.get("").toAbsolutePath().toString();
            currDir = currDir.replace("\\", "/");
            fileDir = "file:///" + currDir + "/src/main/resources/imagens";
            img = new Image(fileDir + id2File(imgId));
            images.put(imgId,img);
        }
        
        ImageView imgv = new ImageView(img);
        return(imgv);
    }
}