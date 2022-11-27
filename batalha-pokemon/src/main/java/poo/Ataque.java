package poo;

/**
 * 
 * @author @gfgiaretta
 * @author @vicente322
 * 
 * @version 2022-11-26
 */

public class Ataque {
    private String nome;
        private int dano;
        // private int idEfeito;
        // private int custoTotal;
        // private int custoTipo;
        // private Tipo tipoEnergia;

        /**
         * Construtor temporario e mais simples para Ataque
         * @param nome Nome do Ataque
         * @param dano Dano que o Ataque causa
         */
        public Ataque (String nome, int dano){
            this.nome = nome;
            this.dano = dano;
        }

        /*
        public Ataque (String nome,int dano,int idEfeito,int custoTotal,int custoTipo, Tipo tipoEnergia){
            this.nome = nome;
            this.dano = dano;
            this.idEfeito = idEfeito;
            this.custoTotal = custoTotal;
            this.custoTipo = custoTipo;
            this.tipoEnergia = tipoEnergia;
        }
        */

        /**
         * 
         * @return Nome do Ataque
         */
        public String getNome(){
            return nome;
        }
        /**
         * 
         * @return Dano do Ataque
         */
        public int getDano(){
            return dano;
        }
        
        /*
        public int getIdEfeito() {return idEfeito;}
        public int getCustoTotal() {return custoTotal;}
        public int getCustoTipo() {return custoTipo;}
        public Tipo getTipoEnergia(){return tipoEnergia;}
        */
    }
