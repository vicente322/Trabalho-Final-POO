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

      public CardView(Card aCard){
            super("");
            card = aCard;
            card.addObserver(this);
            thisCard = this;

            ImageView img = ImageFactory.getInstance().createImage(aCard.getImageId());
            img.setFitHeight(300);
            img.setPreserveRatio(true);

            super.setGraphic(img);

            this.setOnAction(e -> {
                  if (observer != null){
                        observer.cardSelected(thisCard);
                  }
            });
      }

      @Override
      public void update(Observable o, Object arg) {
            // TODO Auto-generated method stub
            
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
