package poo;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-26
 */

public class Game {
      private static Game game = new Game();
      private Card pkmn1, pkmn2;
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
            pkmn1 = new PokemonCard("Aron", "aron-card", "aron", 60,
                                    new Ataque("Tackle", 10), new Ataque("Metal Claw", 30));
            pkmn2 = new PokemonCard("Eevee", "eevee-card", "eevee", 60,
                                    new Ataque("Tackle", 10), new Ataque("Lunge", 30));
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
       * @return Carta Pokemon do jogador 1
       */
      public Card getCardP1(){
            return pkmn1;
      }
      /**
       * 
       * @return Carta Pokemon do jogador 2
       */
      public Card getCardP2(){
            return pkmn2;
      }

      public void play(){

            //Compra carta

            //Faz acao 

            if (player == 1){

                  


            }
            else {

            }



            //Termina turno


      }

}
