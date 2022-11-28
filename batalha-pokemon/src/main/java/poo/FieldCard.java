package poo;

import java.util.Observable;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class FieldCard extends Observable{
      private PokemonCard fieldCard;

      public FieldCard(PokemonCard fieldCard){
            this.fieldCard = fieldCard;
      }
      /**
       * 
       * @return Carta do campo
       */
      public PokemonCard getCard(){
            return fieldCard;
      }
      /**
       * 
       * @param card Nova carta do campo
       */
      public void setCard(PokemonCard card){
            fieldCard = card;
      }
}
