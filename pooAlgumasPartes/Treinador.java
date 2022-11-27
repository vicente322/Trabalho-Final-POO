public class Treinador extends Card{
    private int idEfeito;
    private Ataque tipo;
    private int cura;



    //carta e ação

    public Treinador(String nome,String anId,String anImageId, Ataque tipo, int idEfeito)
    {
        super(nome,anId,anImageId);
        this.tipo = tipo;
    }


    // carta efeito cura

    public Treinador(String nome, String anId, String anImageId, int cura)
    {
        super(nome, anId, anImageId);
        tipo = Ataque.cura;
        this.cura = cura;
        
    }



    public Acao getTipo() {
        return tipo;
    }

    public int getCura() {
        return cura;
    }

    public String toString() {
        return "TREINADOR -- " + getNome() + " : " + tipo + cura;
    }

    public int getIdEfeito(){
        return idEfeito;
    }


    // troca pelo que estiver mais à esquerda no baralho
    public void substituicao(CardDeck banco, CardDeck ativo, CardDeck mao) {

        if (banco.getCards().size() != 0) 
        {
            Card c = banco.getBaralho().get(0);
            for (Card card : ativo.getBaralho()) 
            {
                if (card instanceof Pokemon) 
                {
                    Pokemon p = (Pokemon) card;
                    if (p.getGeracaoAnterior()!=null) 
                    {
                        mao.getBaralho().add(p);
                    } else
                        banco.getBaralho().add(p);
                }
            }
            banco.getBaralho().remove(null);

            ativo.getBaralho().clear();

            ativo.getBaralho().add(c);
        } else 
        {
            System.out.println("Baralho vazio");
        }
    }

}
