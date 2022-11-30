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
      private FieldCard fieldCardP1, fieldCardP2; //Vao virar PokemonCard. Por hora ainda nao por ser tirado direto do deck pode dar erro.
      private Hand handP1, handP2;
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

            Card c1 = null;
            while (!(c1 instanceof PokemonCard)){
                  deckP1.addCard(c1);
                  deckP1.shuffle();
                  c1 = deckP1.draw();
            }
            fieldCardP1 = new FieldCard((PokemonCard)c1);

            Card c2 = null;
            while (!(c2 instanceof PokemonCard)){
                  deckP2.addCard(c2);
                  deckP2.shuffle();
                  c2 = deckP2.draw();
            }
            fieldCardP2 = new FieldCard((PokemonCard)c2);

            handP1 = new Hand(deckP1.draw());

            handP2 = new Hand(deckP2.draw());

            p1Life = initialLife;
            p2Life = initialLife;
            player = 1;
      }
      /**
       * Alterna o jogador
       */
      public void nextPlayer(){
            player++;
            if (player == 3){
                  player = 1;
            }
      }
      /**
       * 
       * @return Numero do plaeyr atual
       */
      public int getPlayer(){
            return player;
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
       * @return Hand do player 1
       */
      public Hand getHandP1(){
            return handP1;
      }
      /**
       * 
       * @return Hand do player 2
       */
      public Hand getHandP2(){
            return handP2;
      }
      /**
       * 
       * @return Vidas do player 1
       */
      public int getP1Life() {
            return p1Life;
      }
      /**
       * 
       * @return Vidas do player 2
       */
      public int getP2Life(){
            return p2Life;
      }
      /**
       * 
       * @return Vida inicial
       */
      public int getInitialLife(){
            return initialLife;
      }
      /**
       * 
       * @return Field Card do jogador 1
       */
      public FieldCard getFieldP1(){
            return fieldCardP1;
      }
      /**
       * 
       * @return Field Card do jogador 2
       */
      public FieldCard getFieldP2(){
            return fieldCardP2;
      }
      /**
       * Metodo para resetar todos elementos do jogo
       */
      public void reset(){
            //TO DO
      }
      /**
       * Dependendo do objeto acionado, lanca um GameEvent
       * 
       * @param objetoAcionado uma das partes que chamou o ply()
       */
      public void play(Object objetoAcionado){
            GameEvent ge = null;

            if ((FieldCard)objetoAcionado == fieldCardP1){
                  if (player == 1){
                        ge = new GameEvent(GameEvent.Target.App,
                                          GameEvent.Action.PLayerFieldOption,
                                          "1");
                        setChanged();
                        notifyObservers((Object)ge);
                  }
            }
            else if ((FieldCard)objetoAcionado == fieldCardP2){
                  if (player == 2) {
                        ge = new GameEvent(GameEvent.Target.App,
                                          GameEvent.Action.PLayerFieldOption,
                                          "2");
                        setChanged();
                        notifyObservers((Object) ge);
                  }
            }
      }
}
