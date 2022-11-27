package poo;

import java.util.Observable;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class Game extends Observable{
      private static Game game = new Game();
      private CardDeck deckP1, deckP2;
      private Card cardOnFieldP1, cardOnFieldP2;
      private int player;

      /**
       * 
       * @return uma instancia de Game
       */
      public static Game getInstance(){
            return game;
      }
      /**
       * Construtor de Game
       */
      private Game(){
            deckP1 = new CardDeck(1);
            deckP2 = new CardDeck(2);
            cardOnFieldP1 = deckP1.draw();
            cardOnFieldP2 = deckP2.draw();
            player = 1;
      }
      /**
       * Alterna o jogador
       */
      private void nextPlayer(){
            player++;
            if (player == 3){
                  player = 1;
            }
      }

      // Compra carta

      // Faz acao

      // Termina turno
      public void play(Card cartaAcionada){
            GameEvent ge = null;

            if (player == 1){
                  if(cartaAcionada == cardOnFieldP2){
                        
                  }
            }

      }

}
