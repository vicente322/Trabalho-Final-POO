package poo;

import java.util.Observable;

/**
 * Classe Game
 * Gerencia o back-end do jogo
 * 
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class Game extends Observable{
      private static Game game = new Game();
      private CardDeck deckP1, deckP2;
      private Card cardOnFieldP1, cardOnFieldP2; //Vao virar PokemonCard. Por hora ainda nao por ser tirado direto do deck pode dar erro.
      private int player, p1Life, p2Life;
      private int initialLife = 3;

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
            p1Life = initialLife;
            p2Life = initialLife;
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
      /**
       * 
       * @return Deck do player 1
       */
      public CardDeck getDeckP1(){
            return deckP1;
      }
      /**
       * 
       * @return Deck do player 2
       */
      public CardDeck getDeckP2(){
            return deckP2;
      }
      /**
       * 
       * @return Vidas do player 1
       */
      public int getP1Life(){
            return p1Life;
      }
      /**
       * 
       * @return Vidas do player 2
       */
      public int getP2Life(){
            return p2Life;
      }

      public void play(Card cartaAcionada){
            GameEvent ge = null;

            if (cartaAcionada == cardOnFieldP1){
                  if (player != 1){
                        // ge = new GameEvent(GameEvent.Target.App, GameEvent.Action.NotMyCard, "");
                        setChanged();
                        notifyObservers();
                        //Acoes na carta do adversário
                        // zoom?
                  }
                  else {
                        // ge = new GameEvent(GameEvent.Target.App, GameEvent.Action.FieldCard, "");
                  }
            }
            // else if (hand.contains(cartaAcionada)){
                  // ge = new GameEvent(GameEvent.Target.App, GameEvent.Action.HandCard, "");
            // }

      }

}
