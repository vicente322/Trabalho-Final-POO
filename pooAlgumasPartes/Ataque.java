public class Ataque {
    private String nome;
        private int dano;
        private int idEfeito;
        private int custoTotal;
        private int custoTipo;
        private Tipo tipoEnergia;

        public Ataque (String nome,int dano,int idEfeito,int custoTotal,int custoTipo, Tipo tipoEnergia)
        {
            this.nome = nome;
            this.dano = dano;
            this.idEfeito = idEfeito;
            this.custoTotal = custoTotal;
            this.custoTipo = custoTipo;
            this.tipoEnergia = tipoEnergia;
        }

        public String getNome() {return nome;}
        public int getDano(){return dano;};
        public int getIdEfeito() {return idEfeito;}
        public int getCustoTotal() {return custoTotal;}
        public int getCustoTipo() {return custoTipo;}
        public Tipo getTipoEnergia(){return tipoEnergia;}
}
