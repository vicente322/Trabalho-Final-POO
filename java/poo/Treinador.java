package poo;
/**
 * @author @Gabriel 
 */
public class Treinador extends Card{
    private int idEfeito;

    public Treinador(String nome,String anId,String anImageId,int idEfeito)
    {
        super(nome,anId,anImageId);
        this.idEfeito = idEfeito;
    }

    public int getIdEfeito() {return idEfeito;}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
