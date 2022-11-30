package poo;
import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class LifeView extends HBox implements Observer {
    private int player;
    private int life;
    private int initialLife;
    
    /**
     * @param nroPlayer
     * @param lifeSize
     */
    public LifeView(int nroPlayer, int lifeSize) {
        GridPane grid = new GridPane();
        player = nroPlayer;
        initialLife = Game.getInstance().getInitialLife();
            
            
        life = 0;

        if(player == 1){
            life = Game.getInstance().getP1Life();        

        }
        else{
            life  = Game.getInstance().getP2Life();
        }

        for(int i = 0; i<initialLife; i++){
            ImageView heart = ImageFactory.getInstance().createImage("fullheart");
            this.getChildren().add(heart);
            heart.setPreserveRatio(true);
            heart.setFitHeight(lifeSize);
                
                
                
                

        }

    }








    @Override
    public void update(Observable o, Object arg) {
       
    }

   
    
}
