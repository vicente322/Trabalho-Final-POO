package poo;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.layout.HBox;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-28
 */


public class FieldCardView extends HBox implements CardObserver, Observer{
      private int player;
      private FieldCard fieldCard;

      public FieldCardView(int nroPlayer){
            player = nroPlayer;
            fieldCard = null;

            if (player == 1){
                  fieldCard = Game.getInstance().getFieldP1();
            }
            else {
                  fieldCard = Game.getInstance().getFieldP2();
            }

            fieldCard.addObserver(this);
      }

      @Override
      public void cardSelected(CardView card) {
            Game.getInstance().play(fieldCard);
      }






      @Override
      public void update(Observable o, Object arg) {
            // TODO Auto-generated method stub
            
      }

      
      
}
