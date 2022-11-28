package poo;

/**
 * Classe GameEvent
 * Gera estruturas para comunicar entre as classes
 *  
 * @author @vicente322
 * 
 * @version 2022-11-27
 */

public class GameEvent {
      public enum Target {Deck,FieldCard};
      public enum Action {Draw};
      
      private Target target;
      private Action action;
      private String arg;

      /**
       * Construtor de GameEvent
       * @param target O alvo do evento
       * @param action A acao a ser realizada pelo alvo
       * @param arg Argumentos que complementem a acao
       */
      public GameEvent(Target target, Action action, String arg){
            this.target = target;
            this.action = action;
            this.arg = arg;
      }
      /**
       * 
       * @return O alvo do evento
       */
      public Target getTarget(){
            return target;
      }
      /**
       * 
       * @return Acao que o alvo deve realizar
       */
      public Action getAction(){
            return action;
      }
      /**
       * 
       * @return Argumento que complementa a acao
       */
      public String getArg(){
            return arg;
      }
      /**
       * 
       * @param target novo Alvo do GameEvent
       */
      public void setTarget(Target target){
            this.target = target;
      }
      /**
       * 
       * @param action Nova acao do GameEvent
       */
      public void setAction(Action action){
            this.action = action;
      }
      /**
       * 
       * @param arg Novo Argumento do GameEvent
       */
      public void setArg(String arg){
            this.arg = arg;
      }
      
      public String toString(){
            return target + ":" + action + ":" + arg;
      }
}
