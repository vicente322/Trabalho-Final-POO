package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

/**
 * 
 * @author @vicente322
 * 
 * @version 2022-11-26
 */

public class CardDeck extends Observable{
    private ArrayList<Card> cartas;

    /**
     * Construtor de CardDeck
     * Escolhe de forma aleatoria qual deck ira criar
     */
    public CardDeck(){
        cartas = new ArrayList<>();
        Random r = new Random();
        int deckNum = r.nextInt(2) + 1;

        if (deckNum == 1){
            cartas.add(new PokemonCard("Eevee", "eevee-card", "eevee",
                    60, new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
            cartas.add(new PokemonCard("Piplup", "piplup-card", "piplup",
                    70, new Ataque("Peck", 10),
                    new Ataque("Wave Splash", 20)));
        }
        else if (deckNum == 2){
            cartas.add(new PokemonCard("Aron", "aron-card", "aron",
                    60, new Ataque("Tackle", 10),
                    new Ataque("Metal Claw", 30)));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card", "rookidee",
                    60, new Ataque("Flap", 10),
                    new Ataque("Glide", 30)));
        }

        Collections.shuffle(cartas);
    }
    /**
     * Construtor de CardDeck indicando qual deck criar.
     * @param deckNum numero do deck que se deseja criar.
     */
    public CardDeck(int deckNum){
        cartas = new ArrayList<>();

        if (deckNum == 1) {
            cartas.add(new PokemonCard("Eevee", "eevee-card", "eevee",
                    60, new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
            cartas.add(new PokemonCard("Piplup", "piplup-card", "piplup",
                    70, new Ataque("Peck", 10),
                    new Ataque("Wave Splash", 20)));
        }
        else if (deckNum == 2) {
            cartas.add(new PokemonCard("Aron", "aron-card", "aron",
                    60, new Ataque("Tackle", 10),
                    new Ataque("Metal Claw", 30)));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card", "rookidee",
                    60, new Ataque("Flap", 10),
                    new Ataque("Glide", 30)));
        }
        
        Collections.shuffle(cartas);
    }
    /**
     * 
     * @return Cartas do Deck
     */
    public ArrayList<Card> getCards(){
        return cartas;
    }
    /**
     * Embaralha as cartas do Deck
     */
    public void shuffle(){
        Collections.shuffle(cartas);
    }
    /**
     * Remove a carta na primeira posicao de 
     * cartas e retorna a carta removida
     * @return Carta removida
     */
    public Card draw(){
        return cartas.remove(0);
    }
    /**
     * Adiciona uma carta ao Deck
     * @param c carta a ser adicionada
     */
    public void addCard(Card c){
        cartas.add(c);
    }
    /**
     * Retorna numero de cartas restantes no baralho
     * @return numero de cartas no baralho
     */
    public int getNCards(){
        return cartas.size();
    }
    public String toString(){
        String s = "Deck:";

        for(int i = 0; i < cartas.size(); i++){
            s = s + "\n" +cartas.get(i).toString();
        }

        return s;
    }
}