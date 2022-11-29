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
      public enum Target {App};
      public enum Action {PLayerFieldOption};
      
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
            
      public String toString(){
            return target + ":" + action + ":" + arg;
      }
}
