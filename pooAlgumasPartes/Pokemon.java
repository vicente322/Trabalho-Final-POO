import java.util.*;

public class Pokemon extends Card{
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

    public Pokemon (String nome,String anId,String anImageId,int defaultHP,Tipo tipo,int custoRecuo,Tipo fraquezaTipo,Tipo resistenciaTipo,int resistenciaValor,String evoluiDe,Ataque ataque1, Ataque ataque2)
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
        this.ataque2=ataque2;
        this.queimado=false;
        this.envenenado=false;
        this.status3=null;
    }

    public Pokemon (String nome,String anId,String anImageId,int defaultHP,Tipo tipo,int custoRecuo,Tipo fraquezaTipo,Tipo resistenciaTipo,int resistenciaValor,String evoluiDe,Ataque ataque1)
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

    public Pokemon (String nome,String anId,String anImageId,int defaultHP,Tipo tipo,int custoRecuo,Tipo fraquezaTipo,String evoluiDe,Ataque ataque1, Ataque ataque2)
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

    public Pokemon (String nome,String anId,String anImageId,int defaultHP,Tipo tipo,int custoRecuo,Tipo fraquezaTipo,String evoluiDe,Ataque ataque1)
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

    public int getHP(){return currentHP;}
    public Tipo getTipo() {return tipo;}
    public Ataque getAtaque1() {return ataque1;}
    public Ataque getAtaque2() {return ataque2;}
    public int getCustoRecuo() {return custoRecuo;}
    public Tipo getFraquezaTipo() {return fraquezaTipo;}
    public Tipo getResistenciaTipo() {return resistenciaTipo;}
    public int getResistenciaValor() {return resistenciaValor;}
    public String getEvoluiDe() {return evoluiDe;}
    public boolean getQueimado() {return queimado;}
    public boolean getEnvenenado() {return envenenado;}
    public String getStatus3() {return status3;}

    public void damage(int dano) {currentHP-=dano;}
    public void heal(int dano) 
    {
        currentHP+=dano;
        if (currentHP>defaultHP){currentHP=defaultHP;}
    }

    public void setQueimado() {queimado=true;}
    public void curaQueimado() {queimado=false;}
    public void setEnvenenado() {envenenado=true;}
    public void curaEnvenenado() {envenenado=false;}
    public void setStatus3(String status)
    {
        if (status.equalsIgnoreCase("dormindo")||status.equalsIgnoreCase("paralizado")) {status3 = status;}
    }
    public void curaStatus3(){status3=null;}

    public Pokemon curaTudo()
    {
        currentHP = defaultHP;
        curaEnvenenado();
        curaQueimado();
        curaStatus3();
        return this;
    }
}
