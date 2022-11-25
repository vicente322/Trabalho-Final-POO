package poo;

import java.util.*;


// Esta classe tem de ser um container de cartas observavel ...
public class CardDeck extends Observable{
    public static final int NCARDS = 6;
    private List<Card> cartas;
    private Card selected;
    
    public CardDeck(){ //Novo card deck.
       cartas = new ArrayList<Card>(NCARDS); //define numero de cartas ao criar lista
       selected = null;
       Random r = new Random();
       for(int i=0;i<NCARDS;i++){  // Pega cartas aleatoriamente. *Removido futuraamente*
           int n = r.nextInt(10)+1;
           Card c = new Card("C"+n,"img"+n,n);
           c.flip();
           cartas.add(c);
       }
    }
        
    public List<Card> getCards(){ //Retorna lista com as cartas do deck
        return(cartas);
    }

    public int getNumberOfCards(){ //Retorna numero de cartas. Numero restante no deck ou total?
        return(cartas.size());
    }
    
    public void removeSel(){ // Remove a carta selecionada
        if (selected == null){
            return;
        }
        cartas.remove(selected);
        selected = null;
        GameEvent gameEvent = new GameEvent(GameEvent.Target.DECK,GameEvent.Action.REMOVESEL,""); // Algum evento no jogo
        setChanged();
        notifyObservers(gameEvent);
    }    
        
    public void setSelectedCard(Card card){ //Escolhe qual carta esta selecionada
        selected = card;
    }
    
    public Card getSelectedCard(){ //Retorna carta selecionada
        return(selected);
    }
}

