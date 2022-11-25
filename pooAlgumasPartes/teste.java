import java.util.*;

public class teste {
    public static void main(String[] args)
    {
        Card p1 = new Pokemon("Bellsprout","c1","bellsprout",60,Tipo.Grass,1,Tipo.Fire,"nada",new Ataque("Blot",20,1,2,1,Tipo.Grass));
        Card p2 = new Pokemon("Eevee","c2","eevee",60,Tipo.Normal,1,Tipo.Fighting,"nada",new Ataque("Tackle",10,0,1,0,Tipo.Normal),new Ataque("Lunge", 30, 2, 2, 0, Tipo.Normal));
        Card p3 = new Pokemon("Farfetch'd","c3","farfetchd",80,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"nada",new Ataque("Leek Lash",20,3,2,0,Tipo.Normal));
        Card p4 = new Pokemon("Flareon","c4","flareon",100,Tipo.Fire,2,Tipo.Water,"Eevee",new Ataque("Vengeance",20,4,2,0,Tipo.Normal),new Ataque("Heat Tackle",90,5,3,1,Tipo.Fire));
        Card p5 = new Pokemon("Gloom","c5","gloom",80,Tipo.Grass,2,Tipo.Fire,"Oddish",new Ataque("Stinky Scent",0,6,1,1,Tipo.Grass),new Ataque("Razor Leaf",30,0,2,1,Tipo.Grass));
        Card p6 = new Pokemon("Herdier","c6","herdier",80,Tipo.Normal,1,Tipo.Fighting,"Lillipup",new Ataque("Bite",20,0,2,0,Tipo.Normal),new Ataque("Jump On",50,7,3,0,Tipo.Normal));
        Card p7 = new Pokemon("Lillipup","c7","lillipup",60,Tipo.Normal,1,Tipo.Fighting,"nada",new Ataque("Collect",0,8,1,0,Tipo.Normal),new Ataque("Tackle",20,0,2,0,Tipo.Normal));
        Card p8 = new Pokemon("Magmar","c8","magmar",90,Tipo.Fire,2,Tipo.Water,"nada",new Ataque("Low Kick",20,0,2,0,Tipo.Normal),new Ataque("Fiery Punch",70,0,3,2,Tipo.Fire));
        Card p9 = new Pokemon("Ninetales","c9","ninetales",120,Tipo.Fire,1,Tipo.Water,"Vulpix",new Ataque("Hex",30,9,1,1,Tipo.Fire),new Ataque("Flickering Flames",90,10,3,1,Tipo.Fire));
        Card p10 = new Pokemon("Oddish","c10","oddish",50,Tipo.Grass,1,Tipo.Fire,"nada",new Ataque("Poison Powder",0,11,1,1,Tipo.Grass));
        Card p11 = new Pokemon("Vulpix","c11","vulpix",60,Tipo.Fire,1,Tipo.Water,"nada",new Ataque("Singe",0,12,1,1,Tipo.Fire));
        Card p12 = new Pokemon("Weepinbell","c12","weepinbell",80,Tipo.Grass,2,Tipo.Fire,"Bellsprout",new Ataque("Burning Venom",0,13,1,1,Tipo.Grass),new Ataque("Ram",30,0,2,0,Tipo.Normal));

        Card t1 = new Treinador("Hau","c13","hau",18);
        Card t2 = new Treinador("Potion","c14","potion",19);
        Card t3 = new Treinador("Full Heal","c15","fullheal",20);

        Card e1 = new Energia("Fire Energy","c16","fireenergy",Tipo.Fire);
        Card e2 = new Energia("Grass Energy","c17","grassenergy",Tipo.Grass);

        ArrayList<Card> deck1= new ArrayList<>(Arrays.asList(p11,p11,p9,p1,p1,p12,p10,p10,p5,p2,p2,p4,p7,p7,p6,p3,p8,t1,t2,t2,e1,e1,e1,e1,e1,e2,e2,e2,e2,e2));
        Collections.shuffle(deck1);

        Card p13 = new Pokemon("Alolan Sandshrew","c18","alolansandshrew",60,Tipo.Water,1,Tipo.Steel,"nada",new Ataque("Fury Swipes",10,14,0,0,Tipo.Normal));
        Card p14 = new Pokemon("Alolan Sandslash","c19","alolansandslash",120,Tipo.Steel,2,Tipo.Fire,Tipo.Psychic,20,"Alolan Sandshrew",new Ataque("Metal Claw",20,0,1,1,Tipo.Steel),new Ataque("Tumbling Attack",80,15,3,2,Tipo.Steel));
        Card p15 = new Pokemon("Aron","c20","aron",60,Tipo.Steel,1,Tipo.Fire,Tipo.Psychic,20,"nada",new Ataque("Tackle",10,0,1,1,Tipo.Steel),new Ataque("Metal Claw",30,0,3,1,Tipo.Steel));
        Card p16 = new Pokemon("Lairon","c21","lairon",100,Tipo.Steel,3,Tipo.Fire,Tipo.Grass,30,"Aron",new Ataque("Knock Away",30,16,2,0,Tipo.Normal),new Ataque("Lunge Out",50,0,3,1,Tipo.Steel));
        Card p17 = new Pokemon("Corvisquire","c22","corvisquire",80,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"Rookidee",new Ataque("Fury Attack",30,14,2,0,Tipo.Normal));
        Card p18 = new Pokemon("Piplup","c23","piplup",70,Tipo.Water,1,Tipo.Electric,"nada",new Ataque("Peck",10,0,1,0,Tipo.Normal),new Ataque("Wave Splash",20,0,2,1,Tipo.Water));
        Card p19 = new Pokemon("Prinplup","c24","prinplup",90,Tipo.Water,2,Tipo.Electric,"Piplup",new Ataque("Bubble Beam",20,17,1,1,Tipo.Water),new Ataque("Wave Splash",40,0,2,1,Tipo.Water));
        Card p20 = new Pokemon("Rookidee","c25","rookidee",60,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"nada",new Ataque("Flap",10,0,1,0,Tipo.Normal),new Ataque("Glide",30,0,2,0,Tipo.Normal));
        Card p21 = new Pokemon("Skwovet","c26","skwovet",70,Tipo.Normal,1,Tipo.Fighting,"nada",new Ataque("Whimsy Tackle",40,2,1,0,Tipo.Normal));
        Card p22 = new Pokemon("Staravia","c27","staravia",80,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,20,"Starly",new Ataque("Flap",20,0,1,0,Tipo.Normal),new Ataque("Wing Attack",60,0,3,0,Tipo.Normal));
        Card p23 = new Pokemon("Starly","c28","starly",60,Tipo.Normal,1,Tipo.Electric,Tipo.Fighting,30,"nada",new Ataque("Claw",30,2,1,0,Tipo.Normal));

        Card e3 = new Energia("Water Energy","c29","waterenergy",Tipo.Water);
        Card e4 = new Energia("Steel Energy","c30","steelenergy",Tipo.Steel);

        ArrayList<Card> deck2 = new ArrayList<>(Arrays.asList(p13,p13,p14,p15,p15,p16,p20,p20,p17,p18,p18,p19,p23,p23,p22,p21,t1,t2,t3,t3,e3,e3,e3,e3,e3,e4,e4,e4,e4,e4));
        Collections.shuffle(deck2);



    }
}
