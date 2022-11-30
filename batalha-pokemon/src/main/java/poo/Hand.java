package poo;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Classe Hand
 * Resposavel por estrururar a mao do jogador
 * 
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class Hand extends Observable{
      private ArrayList<Card> cards;
      private int player;

      /**
       * Construtor de Hand
       * @param nroPlayer Numero do jogador a quem pertence a mao
       */
      public Hand(int nroPlayer){
            cards = new ArrayList<>();
            player = nroPlayer;
      }
      /**
       * 
       * @param card Carta adicionada na mao
       */
      public void addCard(Card card){
            cards.add(card);
      }
      /**
       * 
       * @param card Carta a ser removida
       * @return true se a carta foi encontrada e removida, false caso contrario
       */
      public boolean removeCard(Card card){
            return cards.remove(card);
      }
      /**
       * 
       * @return ArrayList de cartas da mao
       */
      public ArrayList<Card> getCards(){
            return cards;
      }

      public ArrayList<String> getCardNomes(){
            ArrayList<String> lst = new ArrayList<>();
            for (Card c:cards)
            {
                  lst.add(c.getNome());
            }
            return lst;
      }

      public Card getCardByName(String name)
      {
            for (Card c:cards)
            {
                  if (c.getNome().equals(name))
                  {
                        return c;
                  }
            }
            return null;
      }

      //RETORNAR FALSE SE MAO NÃO CONTEM POKEMON BASICO
      public boolean checkContainsBasic()
      {
            for (Card c:cards)
            {
                  if(c instanceof PokemonCard)
                  {
                        PokemonCard copyCard = (PokemonCard)c;
                        if (copyCard.getEvoluiDe().equals("nada")) {return true;}
                  }
            }
            return false;
      }

      public Card handRemoveFirst()
      {
            return cards.remove(0);
      }



}
