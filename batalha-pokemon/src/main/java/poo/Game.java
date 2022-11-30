package poo;

import java.util.*;

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
      private int player, p1Life, p2Life;
      private int initialLife = 4;
      private int energiasFire, energiasWater, energiasSteel, energiasGrass;
      private int descPok1, descTrei1, descEner1, descPok2, descTrei2, descEner2;
      private List<Card> listDeck1,listDeck2;
      private Hand hand1,hand2;
      private PokemonCard nullCard;
      private boolean energizou;

      /**
       * 
       * @return uma instancia de Game
       */
      public static Game getInstance(){
            return game;
      }

      public void newGame()
      {
            game = new Game();
      }
      /**
       * Construtor de Game
       */
      private Game(){
            deckP1 = new CardDeck(1);
            deckP2 = new CardDeck(2);
            listDeck1 = CardDeck.createDeck1();
            System.out.println(listDeck1);
            listDeck2 = CardDeck.createDeck2();
            Collections.shuffle(listDeck1);
            Collections.shuffle(listDeck2);
            hand1 = new Hand(1);
            hand2 = new Hand(2);
            energizou = false;
            
            hand1.addCard(listDeck1.remove(0));
            hand1.addCard(listDeck1.remove(0));
            hand1.addCard(listDeck1.remove(0));
            hand1.addCard(listDeck1.remove(0));
            hand1.addCard(listDeck1.remove(0));


            hand2.addCard(listDeck2.remove(0));
            hand2.addCard(listDeck2.remove(0));
            hand2.addCard(listDeck2.remove(0));
            hand2.addCard(listDeck2.remove(0));
            hand2.addCard(listDeck2.remove(0));

            while (!hand1.checkContainsBasic())
            {
                  listDeck1.add(hand1.handRemoveFirst());
                  listDeck1.add(hand1.handRemoveFirst());
                  listDeck1.add(hand1.handRemoveFirst());
                  listDeck1.add(hand1.handRemoveFirst());
                  listDeck1.add(hand1.handRemoveFirst());
                  Collections.shuffle(listDeck1);
                  hand1.addCard(listDeck1.remove(0));
                  hand1.addCard(listDeck1.remove(0));
                  hand1.addCard(listDeck1.remove(0));
                  hand1.addCard(listDeck1.remove(0));
                  hand1.addCard(listDeck1.remove(0));

            }

            while (!hand2.checkContainsBasic())
            {
                  listDeck2.add(hand2.handRemoveFirst());
                  listDeck2.add(hand2.handRemoveFirst());
                  listDeck2.add(hand2.handRemoveFirst());
                  listDeck2.add(hand2.handRemoveFirst());
                  listDeck2.add(hand2.handRemoveFirst());
                  Collections.shuffle(listDeck1);
                  hand2.addCard(listDeck2.remove(0));
                  hand2.addCard(listDeck2.remove(0));
                  hand2.addCard(listDeck2.remove(0));
                  hand2.addCard(listDeck2.remove(0));
                  hand2.addCard(listDeck2.remove(0));
            }

            nullCard = new PokemonCard("null","null","imgBck",10,Tipo.Normal,"nada",new Ataque("null",0));

            Card c1 = null;
            fieldCardP1 = new FieldCard((PokemonCard)nullCard);
            Card c2 = null;
            fieldCardP2 = new FieldCard((PokemonCard)nullCard);

            p1Life = initialLife;
            p2Life = initialLife;
            player = 1;
            energiasFire = 0;
            energiasGrass = 0;
            energiasSteel = 0;
            energiasWater = 0;
      }
      /**
       * Alterna o jogador
       */
      public void nextPlayer(){
            player++;
            energizou = false;
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

      public List<Card> getListDeckP1()
      {
            return listDeck1;
      }

      public List<Card> getListDeckP2()
      {
            return listDeck2;
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

      public Hand getHandP1()
      {
            return hand1;
      }

      public void setHandP1(Hand hand)
      {
            hand1 = hand;
      }

      public Hand getHandP2()
      {
            return hand2;
      }

      public void setHandP2(Hand hand)
      {
            hand2 = hand;
      }

      public void reset(){
            //TO DO
      }

      public void energizou()
      {
            energizou = true;
      }

      public boolean getEnergizou()
      {
            return energizou;
      }

      public void setCardP1 (PokemonCard card)
      {
            fieldCardP1 = new FieldCard(card);
      }

      public void setCardP2 (PokemonCard card)
      {
            fieldCardP2 = new FieldCard(card);
      }

      public void setCard1Null()
      {
            fieldCardP1=new FieldCard((PokemonCard)nullCard);
      }

      public void setCard2Null()
      {
            fieldCardP2=new FieldCard((PokemonCard)nullCard);
      }

      public void addEnergia(Tipo tipo)
      {
            if (tipo==Tipo.Fire){energiasFire++;}
            else if (tipo==Tipo.Water){energiasWater++;}
            else if (tipo==Tipo.Steel){energiasSteel++;}
            else if (tipo==Tipo.Grass){energiasGrass++;}
      }

      public void clearEnergiasP1()
      {
            descEner1+=energiasFire;
            descEner2+=energiasGrass;
            energiasFire=0;
            energiasGrass=0;
      }

      public void clearEnergiasP2()
      {
            descEner2+=energiasWater;
            descEner2+=energiasSteel;
            energiasWater=0;
            energiasSteel=0;
      }

      public int getEnergias(Tipo tipo)
      {
            if (tipo==Tipo.Fire){return energiasFire;}
            else if (tipo==Tipo.Water){return energiasWater;}
            else if (tipo==Tipo.Steel){return energiasSteel;}
            else {return energiasGrass;}
      }

      public int getEnergiasP1() {return energiasFire+energiasGrass;}
      public int getEnergiasP2() {return energiasWater+energiasSteel;}

      public boolean checkCardP1Defeat()
      {
            if (fieldCardP1.getCard().getCurrentHP()<=0)
            {
                  p1Life--;
                  setCardP1(nullCard);
                  descPok1++;
                  clearEnergiasP1();
                  return true;
            }
            return false;
      }

      public void addDescartePokemon(int i)
      {
            if (i==1){descPok1++;}
            if (i==2){descPok2++;}
      }

      public void addDescarteTreinador(int i)
      {
            if (i==1){descTrei1++;}
            if (i==2){descTrei2++;}
      }

      public void addDescarteEnergia(int i)
      {
            if (i==1){descEner1++;}
            if (i==2){descEner2++;}
      }

      public int getTotalDescarteP1() {return descEner1+descPok1+descTrei1;}
      public int getTotalDescarteP2() {return descEner2+descPok2+descTrei2;}
      public int getDescPokP1() {return descPok1;}
      public int getDescPokP2() {return descPok2;}
      public int getDescTreiP1() {return descTrei1;}
      public int getDescTreiP2() {return descTrei2;}
      public int getDescEnerP1() {return descEner1;}
      public int getDescEnerP2() {return descEner2;}

      public boolean getFimDeJogo()
      {
            return (p1Life==0||p2Life==0);
      }

      public boolean getFimDeJogoPorCartas(int i)
      {
            if (i==1)
            {
                  return getListDeckP1().size()==0;
            }
            else {return getListDeckP2().size()==0;}
      }

      public boolean checkCardP2Defeat()
      {
            if (fieldCardP2.getCard().getCurrentHP()<=0)
            {
                  p2Life--;
                  setCardP2(nullCard);
                  descPok2++;
                  clearEnergiasP2();
                  return true;
            }
            return false;
      }

      public void play(Object objetoAcionado){
            GameEvent ge = null;

            if ((FieldCard)objetoAcionado == fieldCardP1){
                  if (player == 1){
                        ge = new GameEvent(GameEvent.Target.App, GameEvent.Action.PLayerFieldOption, "1");
                        setChanged();
                        notifyObservers((Object)ge);
                  }
            }
            else if ((FieldCard)objetoAcionado == fieldCardP2){
                  if (player == 2) {
                        ge = new GameEvent(GameEvent.Target.App, GameEvent.Action.PLayerFieldOption, "2");
                        setChanged();
                        notifyObservers((Object) ge);
                  }
            }
            

      }

}
