package poo;

import java.util.Observable;
import java.util.Observer;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class DeckView extends HBox implements Observer, CardObserver{
      private int player;
      private CardDeck cDeck;
      private Card selectedCard;


      public DeckView(int nroPlayer){
            super(4);
            this.setAlignment(Pos.CENTER);
            
            player = nroPlayer;
            cDeck = null;
            if (player == 1){
                  cDeck = Game.getInstance().getDeckP1();
            }
            else {
                  cDeck = Game.getInstance().getDeckP2();
            }
            cDeck.addObserver(this);

            for(Card card : cDeck.getCards()){
                  CardView cv = new CardView(card, 300);
                  cv.setCardObserver(this);
                  this.getChildren().add(cv);
            }
      }

      @Override
      public void update(Observable o, Object arg) {
            
            GameEvent ge = (GameEvent)arg;

            
            
      }

      @Override
      public void cardSelected(CardView card) {
            // TODO Auto-generated method stub
            
      }
      
      

}
