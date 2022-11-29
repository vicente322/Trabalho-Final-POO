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

public class HandView extends HBox implements CardObserver, Observer{
      private int player;
      private Hand hand;
      private Card selectedCard;

      public HandView(int nroPlayer){
            player = nroPlayer;
            hand = null;

            if (player == 1){
                  hand = Game.getInstance().get
            }



      }

      @Override
      public void cardSelected(CardView card) {
            // TODO Auto-generated method stub
            
      }
      
      @Override
      public void update(Observable o, Object arg) {
            // TODO Auto-generated method stub

      }
}
