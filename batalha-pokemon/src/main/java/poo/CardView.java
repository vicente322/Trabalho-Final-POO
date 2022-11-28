package poo;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class CardView extends Button implements Observer{
      private Card card;
      private CardView thisCard;
      private CardObserver observer;

      public CardView(Card aCard, int btnHeight){
            super("");
            card = aCard;
            card.addObserver(this);
            thisCard = this;

            ImageView img = ImageFactory.getInstance().createImage(aCard.getImageId());
            img.setFitHeight(btnHeight);
            img.setPreserveRatio(true);

            super.setGraphic(img);

            this.setOnAction(e -> {
                  System.out.println(card.getNome());
                  System.out.println(card.getId());
            });
      }

      @Override
      public void update(Observable o, Object arg) {
            GameEvent ge = null;

            if (arg == null){
                  return;
            }
            
            
      }
      /**
       * 
       * @param obs Novo Observer
       */
      public void setCardObserver(CardObserver obs){
            observer = obs;
      }
      /**
       * 
       * @return Carta observada
       */
      public Card getCard(){
            return card;
      }
}
