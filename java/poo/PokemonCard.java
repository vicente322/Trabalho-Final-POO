package poo;
/**
 * 
 * @author @gfgiaretta
 * @author @vicente322
 * 
 * @version 2022-11-26
 */

public class PokemonCard extends Card{
    
    private int defaultHP;
    private int currentHP;
    private Tipo tipo;
    private Ataque ataque1;
    private Ataque ataque2;
    
    private int custoRecuo;
    private Tipo fraquezaTipo;
    private Tipo resistenciaTipo;
    private int resistenciaValor;
    private String evoluiDe;
    private boolean queimado;
    private boolean envenenado;
    private String status3;
    

  

    
    public PokemonCard (String nome, String anId, String anImageId, int defaultHP, int i,
                        int custoRecuo, Tipo fraquezaTipo, int j, Tipo electric,
                        String evoluiDe, Ataque ataque1, Ataque ataque2){
        super(nome,anId,anImageId);
        this.defaultHP = defaultHP;
        this.currentHP = defaultHP;
         this.tipo = i;
         this.custoRecuo = custoRecuo;
         this.fraquezaTipo = fraquezaTipo;
         this.resistenciaTipo = j;
         this.resistenciaValor = electric;
         this.evoluiDe = evoluiDe;
         this.ataque1 = ataque1;
         this.ataque2=ataque2;
         this.queimado=false;
         this.envenenado=false;
         this.status3=null;
    }

    public PokemonCard (String nome, String anId, String anImageId, int defaultHP, Tipo tipo,
                        int custoRecuo, Tipo fraquezaTipo, Tipo resistenciaTipo, int resistenciaValor,
                        String evoluiDe, Ataque ataque1)
    {
        super(nome,anId,anImageId);
        this.defaultHP = defaultHP;
        this.currentHP = defaultHP;
         this.tipo = tipo;
         this.custoRecuo = custoRecuo;
         this.fraquezaTipo = fraquezaTipo;
         this.resistenciaTipo = resistenciaTipo;
         this.resistenciaValor = resistenciaValor;
         this.evoluiDe = evoluiDe;
         this.ataque1 = ataque1;
         this.ataque2=null;
         this.queimado=false;
         this.envenenado=false;
         this.status3=null;
    }

    public PokemonCard (String nome,String anId,String anImageId,int defaultHP,Tipo tipo,int custoRecuo,Tipo fraquezaTipo,String evoluiDe,Ataque ataque1, Ataque ataque2)
    {
        super(nome,anId,anImageId);
        this.defaultHP = defaultHP;
        this.currentHP = defaultHP;
         this.tipo = tipo;
         this.custoRecuo = custoRecuo;
         this.fraquezaTipo = fraquezaTipo;
         this.resistenciaTipo = null;
         this.resistenciaValor = 0;
         this.evoluiDe = evoluiDe;
         this.ataque1 = ataque1;
         this.ataque2=ataque2;
         this.queimado=false;
         this.envenenado=false;
         this.status3=null;
    }

    public PokemonCard (String nome,String anId,String anImageId,int defaultHP,Tipo tipo,int custoRecuo,Tipo fraquezaTipo,String evoluiDe,Ataque ataque1)
    {
        super(nome,anId,anImageId);
        this.defaultHP = defaultHP;
        this.currentHP = defaultHP;
        this.tipo = tipo;
         this.custoRecuo = custoRecuo;
         this.fraquezaTipo = fraquezaTipo;
         this.resistenciaTipo = null;
         this.resistenciaValor = 0;
         this.evoluiDe = evoluiDe;
         this.ataque1 = ataque1;
         this.ataque2=null;
         this.queimado=false;
         this.envenenado=false;
         this.status3=null;
    }
    
    
    /**
     * 
     * @return HP base do pokemon
     */
    public int getDefaultHP(){
        return defaultHP;
    }
    /**
     * 
     * @return HP atual do pokemon
     */
    public int getCurrentHP(){
        return currentHP;
    }
    
    /*
    public Tipo getTipo(){
        return tipo;
    }
    */

    /**
     * 
     * @return Ataque 1 do pokemon
     */
    public Ataque getAtaque1(){
        return ataque1;
    }
    /**
     * 
     * @return Ataque 2 do pokemon, se houer. Caso nao haja, retorna null
     */
    public Ataque getAtaque2(){
        return ataque2;
    }

    
    public int getCustoRecuo(){
        return custoRecuo;
    }
    public Tipo getFraquezaTipo(){
        return fraquezaTipo;
    }
    public Tipo getResistenciaTipo(){
        return resistenciaTipo;
    }
    public int getResistenciaValor(){
        return resistenciaValor;
    }
    public String getEvoluiDe(){
        return evoluiDe;
    }
    public boolean getQueimado(){
        return queimado;
    }
    public boolean getEnvenenado(){
        return envenenado;
    }
    public String getStatus3(){
        return status3;
    }
    

    /**
     * 
     * @param dano Dano recebido
     */
    public void damage(int dano){
        currentHP -= dano;
    }
    /**
     * 
     * @param cura Quantidade de vida curada.
     * Cura a vida do pokemon, nao ultrapassando a vida base
     */
    public void heal(int cura){
        currentHP += cura;
        if (currentHP>defaultHP){
            currentHP=defaultHP;
        }
    }
    
    
    public void setQueimado(){
        queimado=true;
    }
    public void curaQueimado(){
        queimado=false;
    }
    public void setEnvenenado(){
        envenenado=true;
    }
    public void curaEnvenenado(){
        envenenado=false;
    }
    public void setStatus3(String status){
        if (status.equalsIgnoreCase("dormindo")||status.equalsIgnoreCase("paralizado")) {status3 = status;}
    }
    public void curaStatus3(){
        status3=null;
    }

    public PokemonCard curaTudo(){
        currentHP = defaultHP;
        curaEnvenenado();
        curaQueimado();
        curaStatus3();
        return this;
    }
    
    
    @Override
    public String toString() {
        String s = super.getNome() + "[" + super.getId() + "]";
        return s;
    }
}
