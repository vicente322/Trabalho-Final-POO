package poo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.*;

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
                    60,Tipo.Normal,"nada", new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
            cartas.add(new PokemonCard("Piplup", "piplup-card", "piplup",
                    70,Tipo.Water,"nada", new Ataque("Peck", 10),
                    new Ataque("Wave Splash", 20)));
        }
        else if (deckNum == 2){
            cartas.add(new PokemonCard("Aron", "aron-card", "aron",
                    60,Tipo.Steel,"nada", new Ataque("Tackle", 10),
                    new Ataque("Metal Claw", 30)));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card", "rookidee",
                    60,Tipo.Normal,"nada", new Ataque("Flap", 10),
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
                    60,Tipo.Normal,"nada", new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
            cartas.add(new PokemonCard("Eevee", "eevee-card", "eevee",
                    60,Tipo.Normal,"nada", new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
        }
        else if (deckNum == 2) {
            cartas.add(new PokemonCard("Aron", "aron-card", "aron",
                    60,Tipo.Steel,"nada", new Ataque("Tackle", 10),
                    new Ataque("Metal Claw", 30)));
            cartas.add(new PokemonCard("Rookidee", "rookidee-card", "rookidee",
                    60,Tipo.Normal,"nada", new Ataque("Flap", 10),
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

    /*public static ArrayList<Card> createDeck1()
    {
        ArrayList<Card> lst = new ArrayList<>();
            lst.add(new PokemonCard("Eevee", "eevee-card", "eevee",
                    60,Tipo.Normal,"nada", new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
            lst.add(new PokemonCard("Eevee", "eevee-card", "eevee",
                    60,Tipo.Normal,"nada", new Ataque("Tackle", 10),
                    new Ataque("Lunge", 30)));
            lst.add(new PokemonCard("Oddish","oddish-card","oddish",
                    50,Tipo.Grass,"nada",new Ataque("Poison Powder",0)));
            lst.add(new PokemonCard("Oddish","oddish-card","oddish",
                    50,Tipo.Grass,"nada",new Ataque("Poison Powder",0)));
            lst.add(new PokemonCard("Vulpix","vulpix-card","vulpix",
                    60,Tipo.Fire,"nada",new Ataque("Singe",0)));
            lst.add(new PokemonCard("Vulpix","vulpix-card","vulpix",
                    60,Tipo.Fire,"nada",new Ataque("Singe",0)));
            lst.add(new PokemonCard("Bellsprout","bellsprout-card","bellsprout",
                    60,Tipo.Grass,"nada",new Ataque("Blot",20)));
            lst.add(new PokemonCard("Bellsprout","bellsprout-card","bellsprout",
                    60,Tipo.Grass,"nada",new Ataque("Blot",20)));
            lst.add(new PokemonCard("Gloom","gloom-card","gloom",
                    80,Tipo.Grass,"Oddish",new Ataque("Stinky Scent",0),
                    new Ataque("Razor Leaf",30)));
            lst.add(new PokemonCard("Flareon","flareon-card","flareon",
                    100,Tipo.Fire,"Eevee",new Ataque("Vengeance",20),
                    new Ataque("Heat Tackle", 90)));
            lst.add(new PokemonCard("Weepinbell","weepinbell-card","weepinbell",
                    80,Tipo.Grass,"Bellsprout",new Ataque("Burning Venom",0),
                    new Ataque("Ram",30)));

            lst.add(new TreinadorCard("Potion","potion-card","potion",19));
            lst.add(new TreinadorCard("Potion","potion-card","potion",19));
            lst.add(new TreinadorCard("Hau","hau-card","hau",18));

            lst.add(new EnergiaCard("Fire Energy","fireenergy-card","fireenergy",Tipo.Fire));
            lst.add(new EnergiaCard("Fire Energy","fireenergy-card","fireenergy",Tipo.Fire));
            lst.add(new EnergiaCard("Fire Energy","fireenergy-card","fireenergy",Tipo.Fire));
            lst.add(new EnergiaCard("Grass Energy","grassenergy-card","grassenergy",Tipo.Grass));
            lst.add(new EnergiaCard("Grass Energy","grassenergy-card","grassenergy",Tipo.Grass));
            lst.add(new EnergiaCard("Grass Energy","grassenergy-card","grassenergy",Tipo.Grass));

                    Collections.shuffle(lst);
                    return lst;
    }*/

    public static ArrayList<Card> createDeck1()
    {
        Card p1 = new PokemonCard("Bellsprout","bellsprout-card","bellsprout",60,Tipo.Grass,1,Tipo.Fire,"nada",new Ataque("Blot",20,1,2,1,Tipo.Grass));
        Card p2 = new PokemonCard("Eevee","eevee-card","eevee",60,Tipo.Normal,1,Tipo.Fighting,"nada",new Ataque("Tackle",10,0,1,0,Tipo.Normal),new Ataque("Lunge", 30, 2, 2, 0, Tipo.Normal));
        Card p3 = new PokemonCard("Farfetch'd","farfetchd-card","farfetchd",80,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"nada",new Ataque("Leek Lash",20,3,2,0,Tipo.Normal));
        Card p4 = new PokemonCard("Flareon","flareon-card","flareon",100,Tipo.Fire,2,Tipo.Water,"Eevee",new Ataque("Vengeance",20,4,2,0,Tipo.Normal),new Ataque("Heat Tackle",90,5,3,1,Tipo.Fire));
        Card p5 = new PokemonCard("Gloom","gloom-card","gloom",80,Tipo.Grass,2,Tipo.Fire,"Oddish",new Ataque("Stinky Scent",0,6,1,1,Tipo.Grass),new Ataque("Razor Leaf",30,0,2,1,Tipo.Grass));
        Card p6 = new PokemonCard("Herdier","herdier-card","herdier",80,Tipo.Normal,1,Tipo.Fighting,"Lillipup",new Ataque("Bite",20,0,2,0,Tipo.Normal),new Ataque("Jump On",50,7,3,0,Tipo.Normal));
        Card p7 = new PokemonCard("Lillipup","lillipup-card","lillipup",60,Tipo.Normal,1,Tipo.Fighting,"nada",new Ataque("Collect",0,8,1,0,Tipo.Normal),new Ataque("Tackle",20,0,2,0,Tipo.Normal));
        Card p8 = new PokemonCard("Magmar","magmar-card","magmar",90,Tipo.Fire,2,Tipo.Water,"nada",new Ataque("Low Kick",20,0,2,0,Tipo.Normal),new Ataque("Fiery Punch",70,0,3,2,Tipo.Fire));
        Card p9 = new PokemonCard("Ninetales","ninetales-card","ninetales",120,Tipo.Fire,1,Tipo.Water,"Vulpix",new Ataque("Hex",30,9,1,1,Tipo.Fire),new Ataque("Flickering Flames",90,10,3,1,Tipo.Fire));
        Card p10 = new PokemonCard("Oddish","oddish-card","oddish",50,Tipo.Grass,1,Tipo.Fire,"nada",new Ataque("Poison Powder",0,11,1,1,Tipo.Grass));
        Card p11 = new PokemonCard("Vulpix","vulpix-card","vulpix",60,Tipo.Fire,1,Tipo.Water,"nada",new Ataque("Singe",0,12,1,1,Tipo.Fire));
        Card p12 = new PokemonCard("Weepinbell","weepinbell-card","weepinbell",80,Tipo.Grass,2,Tipo.Fire,"Bellsprout",new Ataque("Burning Venom",0,13,1,1,Tipo.Grass),new Ataque("Ram",30,0,2,0,Tipo.Normal));

        Card t1 = new TreinadorCard("Hau","hau-card","hau",18);
        Card t2 = new TreinadorCard("Poção","potion-card","potion",19);

        Card e1 = new EnergiaCard("Energia de Fogo","fireenergy-card","fireenergy",Tipo.Fire);
        Card e2 = new EnergiaCard("Energia de Planta","grassenergy-card","grassenergy",Tipo.Grass);

        ArrayList<Card> deck1= new ArrayList<>(Arrays.asList(p11,p11,p9,p1,p1,p12,p10,p10,p5,p2,p2,p4,p7,p7,p6,p3,p8,t1,t2,t2,e1,e1,e1,e1,e1,e2,e2,e2,e2,e2));
        Collections.shuffle(deck1);
        return deck1;
    }

    public static ArrayList<Card> createDeck2()
    {
        Card p13 = new PokemonCard("Alolan Sandshrew","alolansandshrew-card","alolansandshrew",60,Tipo.Water,1,Tipo.Steel,"nada",new Ataque("Fury Swipes",10,14,0,0,Tipo.Normal));
        Card p14 = new PokemonCard("Alolan Sandslash","alolansandslash-card","alolansandslash",120,Tipo.Steel,2,Tipo.Fire,Tipo.Psychic,20,"Alolan Sandshrew",new Ataque("Metal Claw",20,0,1,1,Tipo.Steel),new Ataque("Tumbling Attack",80,15,3,2,Tipo.Steel));
        Card p15 = new PokemonCard("Aron","aron-card","aron",60,Tipo.Steel,1,Tipo.Fire,Tipo.Psychic,20,"nada",new Ataque("Tackle",10,0,1,1,Tipo.Steel),new Ataque("Metal Claw",30,0,3,1,Tipo.Steel));
        Card p16 = new PokemonCard("Lairon","lairon-card","lairon",100,Tipo.Steel,3,Tipo.Fire,Tipo.Grass,30,"Aron",new Ataque("Knock Away",30,16,2,0,Tipo.Normal),new Ataque("Lunge Out",50,0,3,1,Tipo.Steel));
        Card p17 = new PokemonCard("Corvisquire","corvisquire-card","corvisquire",80,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"Rookidee",new Ataque("Fury Attack",30,14,2,0,Tipo.Normal));
        Card p18 = new PokemonCard("Piplup","piplup-card","piplup",70,Tipo.Water,1,Tipo.Electric,"nada",new Ataque("Peck",10,0,1,0,Tipo.Normal),new Ataque("Wave Splash",20,0,2,1,Tipo.Water));
        Card p19 = new PokemonCard("Prinplup","prinplup-card","prinplup",90,Tipo.Water,2,Tipo.Electric,"Piplup",new Ataque("Bubble Beam",20,17,1,1,Tipo.Water),new Ataque("Wave Splash",40,0,2,1,Tipo.Water));
        Card p20 = new PokemonCard("Rookidee","rookidee-card","rookidee",60,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"nada",new Ataque("Flap",10,0,1,0,Tipo.Normal),new Ataque("Glide",30,0,2,0,Tipo.Normal));
        Card p21 = new PokemonCard("Skwovet","skwovet-card","skwovet",70,Tipo.Normal,1,Tipo.Fighting,"nada",new Ataque("Whimsy Tackle",40,2,1,0,Tipo.Normal));
        Card p22 = new PokemonCard("Staravia","staravia-card","staravia",80,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,20,"Starly",new Ataque("Flap",20,0,1,0,Tipo.Normal),new Ataque("Wing Attack",60,0,3,0,Tipo.Normal));
        Card p23 = new PokemonCard("Starly","starly-card","starly",60,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"nada",new Ataque("Claw",30,2,1,0,Tipo.Normal));

        Card e3 = new EnergiaCard("Energia de Água","waterenergy-card","waterenergy",Tipo.Water);
        Card e4 = new EnergiaCard("Energia de Metal","steelenergy-card","steelenergy",Tipo.Steel);

        Card t1 = new TreinadorCard("Hau","hau-card","hau",18);
        Card t2 = new TreinadorCard("Poção","potion-card","potion",19);
        Card t3 = new TreinadorCard("Full Heal","fullheal-card","fullheal",20);

        ArrayList<Card> deck2 = new ArrayList<>(Arrays.asList(p13,p13,p14,p15,p15,p16,p20,p20,p17,p18,p18,p19,p23,p23,p22,p21,t1,t2,t3,t3,e3,e3,e3,e3,e3,e4,e4,e4,e4,e4));
        Collections.shuffle(deck2);
        return deck2;

    }

    /* 
    public static ArrayList<Card> createDeck2()
    {
        ArrayList<Card> lst = new ArrayList<>();
            lst.add(new PokemonCard("Aron", "aron-card", "aron",
                    60,Tipo.Steel,"nada", new Ataque("Tackle", 10),
                    new Ataque("Metal Claw", 30)));
            lst.add(new PokemonCard("Rookidee", "rookidee-card", "rookidee",
                    60,Tipo.Normal,"nada", new Ataque("Flap", 10),
                    new Ataque("Glide", 30)));
            lst.add(new PokemonCard("Aron", "aron-card", "aron",
                    60,Tipo.Steel,"nada", new Ataque("Tackle", 10),
                    new Ataque("Metal Claw", 30)));
            lst.add(new PokemonCard("Rookidee", "rookidee-card", "rookidee",
                    60,Tipo.Normal,"nada", new Ataque("Flap", 10),
                    new Ataque("Glide", 30)));
            lst.add(new PokemonCard("Piplup", "piplup-card", "piplup",
                    70,Tipo.Water,"nada", new Ataque("Peck", 10),
                    new Ataque("Wave Splash", 20)));
            lst.add(new PokemonCard("Piplup", "piplup-card", "piplup",
                    70,Tipo.Water,"nada", new Ataque("Peck", 10),
                    new Ataque("Wave Splash", 20)));
            lst.add(new PokemonCard("Alolan Sandshrew","alolansandshrew-card","alolansandshrew",
                    60,Tipo.Water,"nada",new Ataque("Fury Swipes",10)));
            lst.add(new PokemonCard("Alolan Sandshrew","alolansandshrew-card","alolansandshrew",
                    60,Tipo.Water,"nada",new Ataque("Fury Swipes",10)));
            lst.add(new PokemonCard("Lairon","lairon-card","lairon",
                    100,Tipo.Steel,"Aron",new Ataque("Knock Away",30),
                    new Ataque("Lunge Out",50)));
            lst.add(new PokemonCard("Corvisquire","corvisquire-card","corvisquire",
                    80,Tipo.Normal,"Rookidee",new Ataque("Fury Attack",30)));
            lst.add(new PokemonCard("Alolan Sandslash","alolansandslash-card","alolansandslash",
                    120,Tipo.Steel,"Alolan Sandshrew",new Ataque("Metal Claw",20),
                    new Ataque("Tumbling Attack",80)));
            lst.add(new PokemonCard("Skwovet","skwovet-card","skwovet",
                    70,Tipo.Normal,"nada",new Ataque("Whimsy Tackle",40)));

            lst.add(new TreinadorCard("Potion","potion-card","potion",19));
            lst.add(new TreinadorCard("Hau","hau-card","hau",18));

            lst.add(new EnergiaCard("Steel Energy","steelenergy-card","steelenergy",Tipo.Steel));
            lst.add(new EnergiaCard("Steel Energy","steelenergy-card","steelenergy",Tipo.Steel));
            lst.add(new EnergiaCard("Steel Energy","steelenergy-card","steelenergy",Tipo.Steel));
            lst.add(new EnergiaCard("Water Energy","waterenergy-card","waterenergy",Tipo.Water));
            lst.add(new EnergiaCard("Water Energy","waterenergy-card","waterenergy",Tipo.Water));
            lst.add(new EnergiaCard("Water Energy","waterenergy-card","waterenergy",Tipo.Water));

                Collections.shuffle(lst);
                return lst;
    }*/
}