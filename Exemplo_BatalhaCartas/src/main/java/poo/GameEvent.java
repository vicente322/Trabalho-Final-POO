package poo;

public class GameEvent{
    public enum Target {DECK,GWIN}; //A quem se direciona o evento. Ao Deck ou ao Game Window
    public enum Action {INVPLAY,MUSTCLEAN,ENDGAME,REMOVESEL}; //Qual a acao tomada
                                                              //play invertida, deve limpar,
                                                              // fim de jogo, remove selecionado
    
    private Target target;
    private Action action;
    private String arg;
    
    public GameEvent(Target aTarget,Action anAction,String anArg){
        target = aTarget;
        action = anAction;
        arg = anArg;
    }
    
    public Target getTarget(){
        return(target);
    }
    
    public Action getAction(){
        return(action);
    }
    
    public String getArg(){
        return(arg);
    }
    
    public String toString(){
        return target + ":"+ action + ":" + arg;
    }
}

