package poo;

public class TreinadorCard extends Card{
    private int idEfeito;

    public TreinadorCard(String nome,String anId,String anImageId,int idEfeito)
    {
        super(nome,anId,anImageId);
        this.idEfeito = idEfeito;
    }

    public int getIdEfeito() {return idEfeito;}

    public String toString()
    {
        return this.getNome();
    }
}
