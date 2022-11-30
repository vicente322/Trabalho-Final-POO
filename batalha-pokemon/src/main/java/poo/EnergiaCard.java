package poo;

public class EnergiaCard extends Card{
    private Tipo tipo;

    public EnergiaCard(String nome,String anId,String anImageId,Tipo tipo)
    {
        super(nome,anId,anImageId);
        this.tipo = tipo;
    }

    public Tipo getTipo() {return tipo;}

    public String toString()
    {
        return this.getNome();
    }
}
