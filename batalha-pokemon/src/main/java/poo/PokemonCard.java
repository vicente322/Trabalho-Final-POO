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
    private String evoluiDe;
    
    private int custoRecuo;
    private Tipo fraquezaTipo;
    private Tipo resistenciaTipo;
    private int resistenciaValor;
    private boolean queimado;
    private boolean envenenado;
    private String status3;
    

    /**
     * Construtor de carta de pokemon. Elementos incompletos para testar por partes.
     * @param nome Nome da carta
     * @param anId Id da Carta
     * @param anImageId Id da imagem da carta
     * @param defaultHP HP base
     * @param ataque1 Ataque 1 do pokemon
     * @param ataque2 Ataque 2 do pokemon
     */
    public PokemonCard(String nome, String anId, String anImageId, int defaultHP, Tipo tipo, String evoluiDe, Ataque ataque1, Ataque ataque2) {
        super(nome, anId, anImageId);
        this.defaultHP = defaultHP;
        this.currentHP = defaultHP;
        this.tipo = tipo;
        this.evoluiDe = evoluiDe;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.status3="none";
    }

    public PokemonCard(String nome, String anId, String anImageId, int defaultHP, Tipo tipo, String evoluiDe, Ataque ataque1) {
        super(nome, anId, anImageId);
        this.defaultHP = defaultHP;
        this.currentHP = defaultHP;
        this.tipo = tipo;
        this.evoluiDe = evoluiDe;
        this.ataque1 = ataque1;
        this.ataque2 = null;
        this.status3="none";
    }

    
    public PokemonCard (String nome, String anId, String anImageId, int defaultHP, Tipo tipo,
                        int custoRecuo, Tipo fraquezaTipo, Tipo resistenciaTipo, int resistenciaValor,
                        String evoluiDe, Ataque ataque1, Ataque ataque2){
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
        this.ataque2=ataque2;
        this.queimado=false;
        this.envenenado=false;
        this.status3="none";
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
        this.status3="none";
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
        this.status3="none";
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
        this.status3="none";
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
    
    public Tipo getTipo(){
        return tipo;
    }
    
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

    public String getEvoluiDe(){
        return evoluiDe;
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

    public void damageNoWeakness(int dano){
        currentHP -= dano;
    }

    public int getDamageTaken()
    {
        return defaultHP-currentHP;
    }
    /**
     * 
     * @param cura Quantidade de vida curada.
     * Cura a vida do pokemon, nao ultrapassando a vida base
     */
    public int heal(int cura){
        int priorHP = currentHP;
        currentHP += cura;
        if (currentHP>defaultHP){
            currentHP=defaultHP;
            return defaultHP-priorHP;
        }
        return cura;
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
        if (status.equalsIgnoreCase("dormindo")||status.equalsIgnoreCase("paralizado")||status.equalsIgnoreCase("confuso")) {status3 = status;}
    }
    public void curaStatus3(){
        status3="none";
    }

    public String getStatusText()
    {
        String str = "";
        if (envenenado==true) {str = str.concat("\nEnvenenado");}
        if (queimado==true) {str = str.concat("\nQueimado");}
        if (!status3.equals("none")) {str = str.concat("\n" + status3);}
        return str;
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
