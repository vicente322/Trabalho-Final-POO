package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Random;

/**
 * 
 * @author @vicente322
 * @author @alvarocgm
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
            cartas.add(new PokemonCard("Eevee", "eevee-card1", "eevee", 60,Tipo.Normal,1,Tipo.Fighting,null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Lunge", 30, 1,2, Tipo.Normal)));
            cartas.add(new PokemonCard("Eevee", "eevee-card2", "eevee", 60,Tipo.Normal,1,Tipo.Fighting,null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Lunge", 30, 1,2, Tipo.Normal)));
            cartas.add(new PokemonCard("Vulpix", "vulpix-card1", "vulpix", 60, Tipo.Fire, 1, Tipo.Water, null, new Ataque("Singe", 0, 2, 1, Tipo.Fire)));
            cartas.add(new PokemonCard("Vulpix", "vulpix-card2", "vulpix", 60, Tipo.Fire, 1, Tipo.Water, null, new Ataque("Singe", 0, 2, 1, Tipo.Fire)));
            cartas.add(new PokemonCard("Ninetales", "ninetales-card", "ninetales", 120, Tipo.Fire, 1, Tipo.Water,  "Vulpix", new Ataque("Hex", 30, 3, 1, Tipo.Fire), new Ataque("Flickering Flames", 90, 4, 3, Tipo.Fire)));
            cartas.add(new PokemonCard("Bellsprout", "bellsprout-card1", "bellsprout", 60, Tipo.Grass, 1, Tipo.Water, null, new Ataque("Blot", 20, 5, 2, Tipo.Grass)));
            cartas.add(new PokemonCard("Bellsprout", "bellsprout-card2", "bellsprout", 60, Tipo.Grass, 1, Tipo.Water, null, new Ataque("Blot", 20, 5, 2, Tipo.Grass)));
            cartas.add(new PokemonCard("Weepibell", "weepibell-card", "weepinbell", 80, Tipo.Grass, 2, Tipo.Fire, "Bellsprout", new Ataque("Burning Venom", 0, 6, 1, Tipo.Grass), new Ataque("Ram", 30, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Oddish", "oddish-card1", "oddish", 50, Tipo.Grass, 1, Tipo.Grass, null, new Ataque("Poison Powder", 0, 7, 1, Tipo.Grass)));
            cartas.add(new PokemonCard("Oddish", "oddish-card2", "oddish", 50, Tipo.Grass, 1, Tipo.Grass, null, new Ataque("Poison Powder", 0, 7, 1, Tipo.Grass)));
            cartas.add(new PokemonCard("Gloom", "gloom-card", "gloom", 80, Tipo.Grass, 2, Tipo.Fire, "Oddish", new Ataque("Stinky Scent", 0, 8, 1, Tipo.Grass), new Ataque("Razor Leaf", 30, 0, 2, Tipo.Grass)));
            cartas.add(new PokemonCard("Flareon", "flareon-card", "flareon", 100, Tipo.Fire, 2, Tipo.Water, "Eevee", new Ataque("Vengeance", 20, 9, 2, Tipo.Normal), new Ataque("Heat Tackle", 90, 10, 3, Tipo.Fire)));
            cartas.add(new PokemonCard("Lillipup", "lillipup-card1", "lillipup", 60, Tipo.Normal, 1, Tipo.Fighting, null, new Ataque("Collect", 0, 11, 1, Tipo.Normal), new Ataque("Tackle", 20, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Lillipup", "lillipup-card2", "lillipup", 60, Tipo.Normal, 1, Tipo.Fighting, null, new Ataque("Collect", 0, 11, 1, Tipo.Normal), new Ataque("Tackle", 20, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Herdier", "herdier-card", "herdier", 80, Tipo.Normal, 1, Tipo.Fighting, "Lillipup", new Ataque("Bite", 20, 0, 2, Tipo.Normal), new Ataque("Jump On", 50, 12, 3, Tipo.Normal)));
            cartas.add(new PokemonCard("Farfetch'd", "fartechd-card", "farfetchd", 80, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Leek Lash", 20, 13, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Magmar", "magmar-card", "magmar", 90, Tipo.Fire, 2, Tipo.Water, null, new Ataque("Low Kick", 20, 0, 2, Tipo.Normal), new Ataque("Fiery Punch", 70, 0, 3, Tipo.Fire)));
            cartas.add(new Treinador("Hau", "hau-card", "hau", 14));
            cartas.add(new Treinador("Potion", "potion-card1", "potion", 15));
            cartas.add(new Treinador("Potion", "potion-card2", "potion", 15));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card1", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card2", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card3", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card4", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card5", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card1", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card2", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card3", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card4", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card5", "grassenergy", Tipo.Grass));
        }
        else if (deckNum == 2){
            cartas.add(new PokemonCard("Aron", "aron-card1", "aron",60, Tipo.Steel, 1, Tipo.Fire, null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Metal Claw", 30, 0, 3, Tipo.Normal )));
            cartas.add(new PokemonCard("Aron", "aron-card2", "aron",60, Tipo.Steel, 1, Tipo.Fire, null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Metal Claw", 30, 0, 3, Tipo.Normal )));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card1", "rookidee",60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Flap", 10, 0, 1, Tipo.Normal), new Ataque("Glide", 30, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card2", "rookidee",60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Flap", 10, 0, 1, Tipo.Normal), new Ataque("Glide", 30, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Piplup", "piplup-card1","piplup", 70, Tipo.Water, 1, Tipo.Electric, null, new Ataque("Peck", 10, 0, 1, Tipo.Water), new Ataque("Wave Splash", 20, 0, 2, Tipo.Water)));
            cartas.add(new PokemonCard("Piplup", "piplup-card2", "piplup", 70, Tipo.Water, 1, Tipo.Electric, null, new Ataque("Peck", 10, 0, 1, Tipo.Water), new Ataque("Wave Splash", 20, 0, 2, Tipo.Water)));
            cartas.add(new PokemonCard("Starly", "starly-card1", "starly", 60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Claw", 30, 0, 1, Tipo.Normal)));
            cartas.add(new PokemonCard("Starly", "starly-card2", "starly", 60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Claw", 30, 0, 1, Tipo.Normal)));
            cartas.add(new PokemonCard("Alolan Sandshrew", "alolanSandshrew-card1", "alolansandshrew", 60, Tipo.Water, 1, Tipo.Steel, null, new Ataque("Fury Swipes", 10, 16, 0, Tipo.Normal)));
            cartas.add(new PokemonCard("Alolan Sandshrew", "alolanSandshrew-card2", "alolansandshrew", 60, Tipo.Water, 1, Tipo.Steel, null, new Ataque("Fury Swipes", 10, 16, 0, Tipo.Normal)));
            cartas.add(new PokemonCard("Alolan Sandslash", "alolanSandslash-card", "alolansandslash", 120, Tipo.Steel, 2, Tipo.Fire, "Alolan Sandshrew", new Ataque("Metal Claw", 20, 0, 1, Tipo.Steel), new Ataque("Tumbling Attack", 80, 17, 3, Tipo.Steel)));
            cartas.add(new PokemonCard("Lairon", "lairon-card", "lairon", 100, Tipo.Steel, 3, Tipo.Fire, "Aron", new Ataque("Knock Away", 30, 18, 2, Tipo.Normal), new Ataque("Lunge Out", 50, 0, 3, Tipo.Steel)));
            cartas.add(new PokemonCard("Corvisquire", "corvisquire-card", "corvisquire", 80, Tipo.Normal, 2, Tipo.Electric, "Rookidee", new Ataque("Fury Attack", 30, 19, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Prinplup", "prinplup-card", "prinplup", 90, Tipo.Water, 2, Tipo.Electric, "Piplup", new Ataque("Bubble Beam", 20, 20, 1, Tipo.Water), new Ataque("Wave Splash", 40, 0, 2, Tipo.Water)));
            cartas.add(new PokemonCard("Staravia", "staravia-card", "staravia", 80, Tipo.Normal, 1, Tipo.Electric, "Starly", new Ataque("Flap", 20, 0, 1, Tipo.Normal), new Ataque("Wing Attack", 60, 0, 3, Tipo.Normal)));
            cartas.add(new PokemonCard("Skowvet", "skowvet-card", "skowvet", 70, Tipo.Normal, 1, Tipo.Fighting, null, new Ataque("Whimsy Tackle", 40, 1, 1, Tipo.Normal)));
            cartas.add(new Treinador("Hau", "hau-card", "hau", 14));
            cartas.add(new Treinador("Potion", "potion-card1", "potion", 15));
            cartas.add(new Treinador("Potion", "potion-card2", "potion", 15));
            cartas.add(new Treinador("Potion", "potion-card3", "potion", 15));
            cartas.add(new Energia("Water Energy", "waterenergy-card1", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card2", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card3", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card4", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card5", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Steel Energy", "steelenergy-card1", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card2", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card3", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card4", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card5", "steelenergy", Tipo.Steel));
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
            cartas.add(new PokemonCard("Eevee", "eevee-card1", "eevee", 60,Tipo.Normal,1,Tipo.Fighting,null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Lunge", 30, 1,2, Tipo.Normal)));
            cartas.add(new PokemonCard("Eevee", "eevee-card2", "eevee", 60,Tipo.Normal,1,Tipo.Fighting,null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Lunge", 30, 1,2, Tipo.Normal)));
            cartas.add(new PokemonCard("Vulpix", "vulpix-card1", "vulpix", 60, Tipo.Fire, 1, Tipo.Water, null, new Ataque("Singe", 0, 2, 1, Tipo.Fire)));
            cartas.add(new PokemonCard("Vulpix", "vulpix-card2", "vulpix", 60, Tipo.Fire, 1, Tipo.Water, null, new Ataque("Singe", 0, 2, 1, Tipo.Fire)));
            cartas.add(new PokemonCard("Ninetales", "ninetales-card", "ninetales", 120, Tipo.Fire, 1, Tipo.Water, 
            "Vulpix", new Ataque("Hex", 30, 3, 1, Tipo.Fire), new Ataque("Flickering Flames", 90, 4, 3, Tipo.Fire)));
            cartas.add(new PokemonCard("Bellsprout", "bellsprout-card1", "bellsprout", 60, Tipo.Grass, 1, Tipo.Water, null, new Ataque("Blot", 20, 5, 2, Tipo.Grass)));
            cartas.add(new PokemonCard("Bellsprout", "bellsprout-card2", "bellsprout", 60, Tipo.Grass, 1, Tipo.Water, null, new Ataque("Blot", 20, 5, 2, Tipo.Grass)));
            cartas.add(new PokemonCard("Weepibell", "weepibell-card", "weepinbell", 80, Tipo.Grass, 2, Tipo.Fire, "Bellsprout", new Ataque("Burning Venom", 0, 6, 1, Tipo.Grass), new Ataque("Ram", 30, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Oddish", "oddish-card1", "oddish", 50, Tipo.Grass, 1, Tipo.Grass, null, new Ataque("Poison Powder", 0, 7, 1, Tipo.Grass)));
            cartas.add(new PokemonCard("Oddish", "oddish-card2", "oddish", 50, Tipo.Grass, 1, Tipo.Grass, null, new Ataque("Poison Powder", 0, 7, 1, Tipo.Grass)));
            cartas.add(new PokemonCard("Gloom", "gloom-card", "gloom", 80, Tipo.Grass, 2, Tipo.Fire, "Oddish", new Ataque("Stinky Scent", 0, 8, 1, Tipo.Grass), new Ataque("Razor Leaf", 30, 0, 2, Tipo.Grass)));
            cartas.add(new PokemonCard("Flareon", "flareon-card", "flareon", 100, Tipo.Fire, 2, Tipo.Water, "Eevee", new Ataque("Vengeance", 20, 9, 2, Tipo.Normal), new Ataque("Heat Tackle", 90, 10, 3, Tipo.Fire)));
            cartas.add(new PokemonCard("Lillipup", "lillipup-card1", "lillipup", 60, Tipo.Normal, 1, Tipo.Fighting, null, new Ataque("Collect", 0, 11, 1, Tipo.Normal), new Ataque("Tackle", 20, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Lillipup", "lillipup-card2", "lillipup", 60, Tipo.Normal, 1, Tipo.Fighting, null, new Ataque("Collect", 0, 11, 1, Tipo.Normal), new Ataque("Tackle", 20, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Herdier", "herdier-card", "herdier", 80, Tipo.Normal, 1, Tipo.Fighting, "Lillipup", new Ataque("Bite", 20, 0, 2, Tipo.Normal), new Ataque("Jump On", 50, 12, 3, Tipo.Normal)));
            cartas.add(new PokemonCard("Farfetch'd", "fartechd-card", "farfetchd", 80, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Leek Lash", 20, 13, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Magmar", "magmar-card", "magmar", 90, Tipo.Fire, 2, Tipo.Water, null, new Ataque("Low Kick", 20, 0, 2, Tipo.Normal), new Ataque("Fiery Punch", 70, 0, 3, Tipo.Fire)));
            cartas.add(new Treinador("Hau", "hau-card", "hau", 14));
            cartas.add(new Treinador("Potion", "potion-card1", "potion", 15));
            cartas.add(new Treinador("Potion", "potion-card2", "potion", 15));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card1", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card2", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card3", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card4", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Fire Energy", "fireEnergy-card5", "fireenergy", Tipo.Fire));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card1", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card2", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card3", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card4", "grassenergy", Tipo.Grass));
            cartas.add(new Energia("Grass Energy", "grassEnergy-card5", "grassenergy", Tipo.Grass));
        }
        else if (deckNum == 2) {
            cartas.add(new PokemonCard("Aron", "aron-card1", "aron",60, Tipo.Steel, 1, Tipo.Fire, null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Metal Claw", 30, 0, 3, Tipo.Normal )));
            cartas.add(new PokemonCard("Aron", "aron-card2", "aron",60, Tipo.Steel, 1, Tipo.Fire, null, new Ataque("Tackle", 10, 0, 1, Tipo.Normal), new Ataque("Metal Claw", 30, 0, 3, Tipo.Normal )));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card1", "rookidee",60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Flap", 10, 0, 1, Tipo.Normal), new Ataque("Glide", 30, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card2", "rookidee",60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Flap", 10, 0, 1, Tipo.Normal), new Ataque("Glide", 30, 0, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Piplup", "piplup-card1", "piplup", 70, Tipo.Water, 1, Tipo.Electric, null, new Ataque("Peck", 10, 0, 1, Tipo.Water), new Ataque("Wave Splash", 20, 0, 2, Tipo.Water)));
            cartas.add(new PokemonCard("Piplup", "piplup-card2", "piplup", 70, Tipo.Water, 1, Tipo.Electric, null, new Ataque("Peck", 10, 0, 1, Tipo.Water), new Ataque("Wave Splash", 20, 0, 2, Tipo.Water)));
            cartas.add(new PokemonCard("Starly", "starly-card1", "starly", 60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Claw", 30, 0, 1, Tipo.Normal)));
            cartas.add(new PokemonCard("Starly", "starly-card2", "starly", 60, Tipo.Normal, 1, Tipo.Electric, null, new Ataque("Claw", 30, 0, 1, Tipo.Normal)));
            cartas.add(new PokemonCard("Alolan Sandshrew", "alolanSandshrew-card1", "alolansandshrew", 60, Tipo.Water, 1, Tipo.Steel, null, new Ataque("Fury Swipes", 10, 16, 0, Tipo.Normal)));
            cartas.add(new PokemonCard("Alolan Sandshrew", "alolanSandshrew-card2", "alolansandshrew", 60, Tipo.Water, 1, Tipo.Steel, null, new Ataque("Fury Swipes", 10, 16, 0, Tipo.Normal)));
            cartas.add(new PokemonCard("Alolan Sandslash", "alolanSandslash-card", "alolansandslash", 120, Tipo.Steel, 2, Tipo.Fire, "Alolan Sandshrew", new Ataque("Metal Claw", 20, 0, 1, Tipo.Steel), new Ataque("Tumbling Attack", 80, 17, 3, Tipo.Steel)));
            cartas.add(new PokemonCard("Lairon", "lairon-card", "lairon", 100, Tipo.Steel, 3, Tipo.Fire, "Aron", new Ataque("Knock Away", 30, 18, 2, Tipo.Normal), new Ataque("Lunge Out", 50, 0, 3, Tipo.Steel)));
            cartas.add(new PokemonCard("Corvisquire", "corvisquire-card", "corvisquire", 80, Tipo.Normal, 2, Tipo.Electric, "Rookidee", new Ataque("Fury Attack", 30, 19, 2, Tipo.Normal)));
            cartas.add(new PokemonCard("Prinplup", "prinplup-card", "prinplup", 90, Tipo.Water, 2, Tipo.Electric, "Piplup", new Ataque("Bubble Beam", 20, 20, 1, Tipo.Water), new Ataque("Wave Splash", 40, 0, 2, Tipo.Water)));
            cartas.add(new PokemonCard("Staravia", "staravia-card", "staravia", 80, Tipo.Normal, 1, Tipo.Electric, "Starly", new Ataque("Flap", 20, 0, 1, Tipo.Normal), new Ataque("Wing Attack", 60, 0, 3, Tipo.Normal)));
            cartas.add(new PokemonCard("Skowvet", "skowvet-card", "skowvet", 70, Tipo.Normal, 1, Tipo.Fighting, null, new Ataque("Whimsy Tackle", 40, 1, 1, Tipo.Normal)));
            cartas.add(new Treinador("Hau", "hau-card", "hau", 14));
            cartas.add(new Treinador("Potion", "potion-card1", "potion", 15));
            cartas.add(new Treinador("Potion", "potion-card2", "potion", 15));
            cartas.add(new Treinador("Potion", "potion-card3", "potion", 15));
            cartas.add(new Energia("Water Energy", "waterenergy-card1", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card2", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card3", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card4", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Water Energy", "waterenergy-card5", "waterenergy", Tipo.Water));
            cartas.add(new Energia("Steel Energy", "steelenergy-card1", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card2", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card3", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card4", "steelenergy", Tipo.Steel));
            cartas.add(new Energia("Steel Energy", "steelenergy-card5", "steelenergy", Tipo.Steel));
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
