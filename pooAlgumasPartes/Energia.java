public class Energia extends Card{
    private Tipo tipo;

    public Energia (String nome,String anId,String anImageId,Tipo tipo)
    {
        super(nome,anId,anImageId);
        this.tipo = tipo;
    }

    public Tipo getTipo() {return tipo;}
}
