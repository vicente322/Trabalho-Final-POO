public class Treinador extends Card{
    private int idEfeito;

    public Treinador(String nome,String anId,String anImageId,int idEfeito)
    {
        super(nome,anId,anImageId);
        this.idEfeito = idEfeito;
    }

    public int getIdEfeito() {return idEfeito;}
}
