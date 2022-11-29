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
                  hand = Game.getInstance().getHandP1();
            }
            else {
                  hand = Game.getInstance().getHandP2();
            }

            hand.addObserver(this);
            
            for (Card card : hand.getCards()){
                  if (card != null){
                        CardView cv = new CardView(card, 300);
                        cv.setCardObserver(this);
                        this.getChildren().add(cv);
                  }                 
            }          
      }

      @Override
      public void cardSelected(CardView card) {
            hand.setSelectedCard(card.getCard());
            selectedCard = card.getCard();
            Game.getInstance().play(hand);
            
      }
      
      @Override
      public void update(Observable o, Object arg) {
            // Draw muda a HandView
            // Jogar carta também

      }
}
