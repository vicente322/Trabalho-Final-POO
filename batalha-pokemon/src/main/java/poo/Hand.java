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
      private Card selected;

      /**
       * Construtor de Hand
       * @param nroPlayer Numero do jogador a quem pertence a mao
       */
      public Hand(Card card){
            cards = new ArrayList<>();
            cards.add(card);
            selected = null;
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
            return(cards);
      }

      public void setSelectedCard(Card card){
            selected = card;
      }

      public Card getSelecteCard(){
            return selected;
      }



}
