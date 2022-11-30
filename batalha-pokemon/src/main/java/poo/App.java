package poo;

import java.util.Observable;
import java.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import java.util.*;


/**
 * App da Batalha de Pokemon
 * Gerencia o front-end
 * 
 * @author @vicente322
 * @author @gfgiaretta
 * 
 * @version 2022-11-27
 */

public class App extends Application implements Observer{
    private FieldCardView fieldCardP1, fieldCardP2;
    private Button hnd1Btn, hnd2Btn, hnd1CloseBtn, hnd2CloseBtn, confirmNamesBtn,flipBtn,flipFecharBtn, closePopUpBtn;
    private Stage hnd1Stage, hnd2Stage, confirmNameStage, coinFlipStage, tripleCoinFlipStage, popUpStage;
    private Scene fieldScene, hnd1Scene, hnd2Scene, confirmNameScene, coinFlipScene, tripleCoinFlipScene, popUpScene;
    private GridPane grid, hnd1Pane, hnd2Pane, gridCoin, gridCoinTriple, popUpGrid;
    private Label playerTurn, lbP1, lbP2, infoPokemon1, infoPokemon2, infoDeck1, infoDeck2,popUpLabel;
    private String jogador1Nome, jogador2Nome;
    private TextField jogador1, jogador2;
    private ImageView cartaMaoP1, cartaJogoP1, cartaJogoP1Copia, cartaMaoP2, cartaJogoP2, cartaJogoP2Copia, coin, coin1, coin2, coin3,c1p1,c2p1,c3p1,c4p1,c1p2,c2p2,c3p2,c4p2;
    private ComboBox<String> cb1, cb2;
    private boolean acabou,turnFinished,reachedLoop,flipped,fimPorCartas,fimPorBasicos;
    private int numberOfHeads, winnerIfTie;

    /**
     * Metodo para tratar acao do botao para abrir mao do jogador 1
     * 
     * @param e Evento do botao
     *          Ao ser precionado, o botao mostra a nova tela e espera
     */
    public void trataBtnHand1(ActionEvent e) {
        hnd1Stage.showAndWait();
    }
    /**
     * Metodo para tratar acao do botao para passar o turno do jogador 1
     * 
     * @param e Evento do botao
     *          Ao ser precionado, o botao fecha a tela
     */
    public void trataBtnCloseHand1(ActionEvent e) {
        if (reachedLoop)
        {
            turnFinished = true;
            hnd1Stage.close();
        }
    }
    /**
     * Metodo para tratar acao do botao para abrir mao do jogador 2
     * 
     * @param e Evento do botao
     *          Ao ser precionado, o botao mostra a nova tela e espera
     */
    public void trataBtnHand2(ActionEvent e) {
        hnd2Stage.showAndWait();
    }
    /**
     * Metodo para tratar acao do botao para passar o turno do jogador 2
     * 
     * @param e Evento do botao
     *          Ao ser precionado, o botao fecha a tela
     */
    public void trataBtnCloseHand2(ActionEvent e) {
        if (reachedLoop)
        {
            turnFinished = true;
            hnd2Stage.close();
        }
    }
    /**
     * Metodo para tratar acao do botao "Confirmar" para mudar os nomes dos jogadores
     * @param e Evento do botao
     *          Ao ser pressionado, atualiza os nomes de P1 e P2 e fecha a janela.
     */
    public void trataBtnCloseConfirm(ActionEvent e) {
        jogador1Nome = jogador1.getText();
        jogador2Nome = jogador2.getText();
        lbP1.setText(jogador1Nome);
        lbP2.setText(jogador2Nome);
        updateLabels();
        confirmNameStage.close();
    }

    public void trataBtnUsarCartaP1(ActionEvent e,String str) {
        if (str==null) {System.out.println("Invalido");}
        else {
            Hand hand = Game.getInstance().getHandP1();
            Card c = Game.getInstance().getHandP1().getCardByName(str);
            if(c instanceof PokemonCard)
            {
                PokemonCard copyCard = (PokemonCard)c;
                if(copyCard.getEvoluiDe().equals("nada")&&Game.getInstance().getFieldP1().getCard().getNome().equals("null"))
                {
                    System.out.println(c.getImageId() + "JOGOU BASICO");
                    Game.getInstance().setCardP1(copyCard);
                    hand.removeCard(c);
                    Game.getInstance().setHandP1(hand);
                    cb1.getItems().remove(str);
                    hnd1Stage.close();
                }
                else if (copyCard.getEvoluiDe().equals(Game.getInstance().getFieldP1().getCard().getNome()))
                {
                    System.out.println(c.getImageId() + " JOGOU EVOLUCAO");
                    copyCard.damageNoWeakness(Game.getInstance().getFieldP1().getCard().getDamageTaken());
                    Game.getInstance().addDescartePokemon(1);
                    Game.getInstance().setCardP1(copyCard);
                    hand.removeCard(c);
                    Game.getInstance().setHandP1(hand);
                    cb1.getItems().remove(str);
                    updateLabels();
                }
            }
            else if (c instanceof TreinadorCard && Game.getInstance().getFieldP1().getCard().getNome()!="null")
            {
                TreinadorCard copyCard = (TreinadorCard)c;
                System.out.println(c.getImageId() + " JOGOU TREINADOR");
                int i = copyCard.getIdEfeito();
                if (i==18) {ativaHauP1();}
                else if (i==19) {Game.getInstance().getFieldP1().getCard().heal(20);}
                else if (i==20)
                {
                    Game.getInstance().getFieldP1().getCard().curaEnvenenado();
                    Game.getInstance().getFieldP1().getCard().curaQueimado();
                    Game.getInstance().getFieldP1().getCard().curaStatus3();
                }
                hand.removeCard(c);
                Game.getInstance().addDescarteTreinador(1);
                Game.getInstance().setHandP1(hand);
                cb1.getItems().remove(str);
                updateLabels();
            }
            else if (c instanceof EnergiaCard && Game.getInstance().getFieldP1().getCard().getNome()!="null"&& !Game.getInstance().getEnergizou())
            {
                EnergiaCard copyCard = (EnergiaCard)c;
                System.out.println(c.getImageId() + " JOGOU ENERGIA");
                Game.getInstance().energizou();
                Game.getInstance().addEnergia(copyCard.getTipo());
                hand.removeCard(c);
                Game.getInstance().setHandP1(hand);
                cb1.getItems().remove(str);
                updateLabels();
            }
        }
    }

    public void trataBtnShowCartaP1(ActionEvent e,String str) {
        if (str==null) {System.out.println("Invalido");}
        else {
            Card c = Game.getInstance().getHandP1().getCardByName(str);   
            cartaMaoP1.setImage(ImageFactory.getInstance().createImage(c.getImageId()).getImage());
        } 
    }

    public void trataBtnUsarCartaP2(ActionEvent e,String str) {
        if (str==null) {System.out.println("Invalido");}
        else {
            Hand hand = Game.getInstance().getHandP2();
            Card c = Game.getInstance().getHandP2().getCardByName(str);
            if(c instanceof PokemonCard)
            {
                PokemonCard copyCard = (PokemonCard)c;
                if(copyCard.getEvoluiDe().equals("nada")&&Game.getInstance().getFieldP2().getCard().getNome().equals("null"))
                {
                    System.out.println(c.getImageId() + " JOGOU BASICO");
                    Game.getInstance().setCardP2(copyCard);
                    hand.removeCard(c);
                    Game.getInstance().setHandP2(hand);
                    cb2.getItems().remove(str);
                    hnd2Stage.close();
                }
                else if (copyCard.getEvoluiDe().equals(Game.getInstance().getFieldP2().getCard().getNome()))
                {
                    System.out.println(c.getImageId() + " JOGOU EVOLUCAO");
                    copyCard.damageNoWeakness(Game.getInstance().getFieldP2().getCard().getDamageTaken());
                    Game.getInstance().addDescartePokemon(2);
                    Game.getInstance().setCardP2(copyCard);
                    hand.removeCard(c);
                    Game.getInstance().setHandP2(hand);
                    cb2.getItems().remove(str);
                    updateLabels();
                }
            }
            else if (c instanceof TreinadorCard && Game.getInstance().getFieldP2().getCard().getNome()!="null")
            {
                TreinadorCard copyCard = (TreinadorCard)c;
                System.out.println(c.getImageId() + " JOGOU TREINADOR");
                int i = copyCard.getIdEfeito();
                if (i==18) {ativaHauP2();}
                else if (i==19) {Game.getInstance().getFieldP2().getCard().heal(20);}
                else if (i==20)
                {
                    Game.getInstance().getFieldP2().getCard().curaEnvenenado();
                    Game.getInstance().getFieldP2().getCard().curaQueimado();
                    Game.getInstance().getFieldP2().getCard().curaStatus3();
                }
                hand.removeCard(c);
                Game.getInstance().addDescarteTreinador(2);
                Game.getInstance().setHandP2(hand);
                cb2.getItems().remove(str);
                updateLabels();
            }
            else if (c instanceof EnergiaCard && Game.getInstance().getFieldP2().getCard().getNome()!="null" && !Game.getInstance().getEnergizou())
            {
                EnergiaCard copyCard = (EnergiaCard)c;
                System.out.println(c.getImageId() + " JOGOU ENERGIA");
                Game.getInstance().energizou();
                Game.getInstance().addEnergia(copyCard.getTipo());
                hand.removeCard(c);
                Game.getInstance().setHandP2(hand);
                cb2.getItems().remove(str);
                updateLabels();
            }
        }
    }

    public void trataBtnShowCartaP2(ActionEvent e,String str) {
        if (str==null) {System.out.println("Invalido");}
        else {
            Card c = Game.getInstance().getHandP2().getCardByName(str);   
            cartaMaoP2.setImage(ImageFactory.getInstance().createImage(c.getImageId()).getImage());
        } 
    }

    public void tratarBtnAtk1P1(ActionEvent e)
    {
        Ataque atk = Game.getInstance().getFieldP1().getCard().getAtaque1();
        String status3 = Game.getInstance().getFieldP1().getCard().getStatus3();
        if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&verificaUsarAtaqueP1(atk)&&status3.equalsIgnoreCase("none"))
        {
            Game.getInstance().getFieldP2().getCard().damage(findDanoAtaqueP1(atk));
            turnFinished = true;
            hnd1Stage.close();
        }
        else if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&status3.equalsIgnoreCase("Confuso"))
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            if (numberOfHeads==1) {Game.getInstance().getFieldP2().getCard().damage(findDanoAtaqueP1(atk));}
            else {Game.getInstance().getFieldP1().getCard().damage(30);}
            turnFinished = true;
            hnd1Stage.close();
        }
    }

    public void tratarBtnAtk1P2(ActionEvent e)
    {
        Ataque atk = Game.getInstance().getFieldP2().getCard().getAtaque1();
        String status3 = Game.getInstance().getFieldP2().getCard().getStatus3();
        if(!Game.getInstance().getFieldP2().getCard().getNome().equals("null")&&verificaUsarAtaqueP2(atk)&&status3.equalsIgnoreCase("none"))
        {
            Game.getInstance().getFieldP1().getCard().damage(findDanoAtaqueP2(atk));
            turnFinished = true;
            hnd2Stage.close();
        }
        else if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&status3.equalsIgnoreCase("Confuso"))
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            if (numberOfHeads==1) {Game.getInstance().getFieldP1().getCard().damage(findDanoAtaqueP2(atk));}
            else {Game.getInstance().getFieldP2().getCard().damage(30);}
            turnFinished = true;
            hnd1Stage.close();
        }
    }

    public void tratarBtnAtk2P1(ActionEvent e)
    {
        if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&!(Game.getInstance().getFieldP1().getCard().getAtaque2()==null))
        {
            Ataque atk = Game.getInstance().getFieldP1().getCard().getAtaque2();
            String status3 = Game.getInstance().getFieldP1().getCard().getStatus3();
            if(verificaUsarAtaqueP1(atk)&&status3.equalsIgnoreCase("none"))
            {
                Game.getInstance().getFieldP2().getCard().damage(findDanoAtaqueP1(atk));
                turnFinished = true;
                hnd1Stage.close();
            }
            else if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&status3.equalsIgnoreCase("Confuso"))
            {
                flipped = false;
                while(!flipped)
                {
                    numberOfHeads = 0;
                    coinFlipStage.showAndWait();
                }
                if (numberOfHeads==1) {Game.getInstance().getFieldP2().getCard().damage(findDanoAtaqueP1(atk));}
                else {Game.getInstance().getFieldP1().getCard().damage(30);}
                turnFinished = true;
                hnd1Stage.close();
            }
        }
    }

    public void tratarBtnAtk2P2(ActionEvent e)
    {
        if (!Game.getInstance().getFieldP2().getCard().getNome().equals("null")&&!(Game.getInstance().getFieldP2().getCard().getAtaque2()==null))
        {
            Ataque atk = Game.getInstance().getFieldP2().getCard().getAtaque2();
            String status3 = Game.getInstance().getFieldP2().getCard().getStatus3();
            if(verificaUsarAtaqueP2(atk)&&status3.equalsIgnoreCase("none"))
            {
                Game.getInstance().getFieldP1().getCard().damage(findDanoAtaqueP2(atk));
                turnFinished = true;
                hnd2Stage.close();
            }
            else if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&status3.equalsIgnoreCase("Confuso"))
            {
                flipped = false;
                while(!flipped)
                {
                    numberOfHeads = 0;
                    coinFlipStage.showAndWait();
                }
                if (numberOfHeads==1) {Game.getInstance().getFieldP1().getCard().damage(findDanoAtaqueP2(atk));}
                else {Game.getInstance().getFieldP2().getCard().damage(30);}
                turnFinished = true;
                hnd1Stage.close();
            }
        }
    }

    public void tratarBtnRecuarP1(ActionEvent e)
    {
        int custo = Game.getInstance().getFieldP1().getCard().getCustoRecuo();
        String status3 = Game.getInstance().getFieldP1().getCard().getStatus3();
        if (!Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&Game.getInstance().getEnergiasP1()>=custo&&!(status3.equalsIgnoreCase("Paralizado")||status3.equalsIgnoreCase("Dormindo")))
        {
            Card c = Game.getInstance().getFieldP1().getCard().curaTudo();
            Game.getInstance().getHandP1().addCard(c);
            cb1.getItems().add(c.getNome());
            cb1.getItems().remove("null");
            Game.getInstance().setCard1Null();
            Game.getInstance().clearEnergiasP1();
            updateLabels();
        }
    }

    public void tratarBtnRecuarP2(ActionEvent e)
    {
        int custo = Game.getInstance().getFieldP2().getCard().getCustoRecuo();
        String status3 = Game.getInstance().getFieldP2().getCard().getStatus3();
        if (!Game.getInstance().getFieldP2().getCard().getNome().equals("null")&&Game.getInstance().getEnergiasP2()>=custo&&!(status3.equalsIgnoreCase("Paralizado")||status3.equalsIgnoreCase("Dormindo")))
        {
            Card c = Game.getInstance().getFieldP2().getCard().curaTudo();
            Game.getInstance().getHandP2().addCard(c);
            cb2.getItems().add(c.getNome());
            cb2.getItems().remove("null");
            Game.getInstance().setCard2Null();
            Game.getInstance().clearEnergiasP2();
            updateLabels();
        }
    }

    public void launchPopUp()
    {
        closePopUpBtn = new Button("OK");
        closePopUpBtn.setOnAction(e->{popUpStage.close();});
        popUpGrid = new GridPane();

        popUpGrid.add(closePopUpBtn,0,1);
        
        popUpLabel = new Label("PopUp");
        popUpGrid.add(popUpLabel,0,0);

        popUpGrid.setAlignment(Pos.CENTER);
        popUpGrid.setHgap(10);
        popUpGrid.setVgap(10);
        popUpGrid.setPadding(new Insets(25, 25, 25, 25));

        popUpScene = new Scene(popUpGrid);
        popUpStage = new Stage();
        popUpStage.setScene(popUpScene);
        popUpStage.setTitle("Aviso");
    }

    public void launchCoinFlipWindow(){
        flipBtn = new Button("Flip!");
        flipBtn.setOnAction(e->trataCoinFlip(e));
        gridCoin = new GridPane();

        flipFecharBtn = new Button("Fechar");
        flipFecharBtn.setOnAction(e->trataFecharCoinFlip(e));

        gridCoin.setAlignment(Pos.CENTER);
        gridCoin.setHgap(10);
        gridCoin.setVgap(10);
        gridCoin.setPadding(new Insets(25, 25, 25, 25));
        gridCoin.add(flipBtn,0,1);
        gridCoin.add(flipFecharBtn,0,2);

        coin = ImageFactory.getInstance().createImage("coinFront");
        coin.setFitHeight(100);
        coin.setPreserveRatio(true);
        gridCoin.add(coin,0,0);

        coinFlipScene = new Scene(gridCoin);
        coinFlipStage = new Stage();
        coinFlipStage.setScene(coinFlipScene);
        coinFlipStage.setTitle("Jogue a moeda.");
    }

    public void trataCoinFlip(ActionEvent e)
    {
        Random r = new Random();
        int i = (int)Math.round(Math.random());
        if (!flipped)
        {
            if (i == 0)
            {
                coin.setImage(ImageFactory.getInstance().createImage("coinBack").getImage());
            }
            else
            {
                coin.setImage(ImageFactory.getInstance().createImage("coinFront").getImage());
                numberOfHeads++;
            }
            flipped = true;
        }
    }

    public void trataFecharCoinFlip(ActionEvent e)
    {
        if (flipped)
        {
            coinFlipStage.close();
            tripleCoinFlipStage.close();
        }
    }

    public void launchTripleCoinFlipWindow(){
        flipBtn = new Button("Flip!");
        flipBtn.setOnAction(e->trataCoinFlipTriple(e));
        gridCoinTriple = new GridPane();

        flipFecharBtn = new Button("Fechar");
        flipFecharBtn.setOnAction(e->trataFecharCoinFlip(e));

        gridCoinTriple.setAlignment(Pos.CENTER);
        gridCoinTriple.setHgap(10);
        gridCoinTriple.setVgap(10);
        gridCoinTriple.setPadding(new Insets(25, 25, 25, 25));
        gridCoinTriple.add(flipBtn,1,1);
        gridCoinTriple.add(flipFecharBtn,1,2);

        coin1 = ImageFactory.getInstance().createImage("coinFront");
        coin1.setFitHeight(100);
        coin1.setPreserveRatio(true);
        gridCoinTriple.add(coin1,0,0);

        coin2 = ImageFactory.getInstance().createImage("coinFront");
        coin2.setFitHeight(100);
        coin2.setPreserveRatio(true);
        gridCoinTriple.add(coin2,1,0);

        coin3 = ImageFactory.getInstance().createImage("coinFront");
        coin3.setFitHeight(100);
        coin3.setPreserveRatio(true);
        gridCoinTriple.add(coin3,2,0);

        tripleCoinFlipScene = new Scene(gridCoinTriple);
        tripleCoinFlipStage = new Stage();
        tripleCoinFlipStage.setScene(tripleCoinFlipScene);
        tripleCoinFlipStage.setTitle("Jogue as moedas.");
    }

    public void trataCoinFlipTriple(ActionEvent e)
    {
        Random r = new Random();
        int i1 = (int)Math.round(Math.random());
        int i2 = (int)Math.round(Math.random());
        int i3 = (int)Math.round(Math.random());
        if (!flipped)
        {
            if (i1 == 0)
            {
                coin1.setImage(ImageFactory.getInstance().createImage("coinBack").getImage());
                
            }
            else
            {
                coin1.setImage(ImageFactory.getInstance().createImage("coinFront").getImage());
                numberOfHeads++;
            }

            if (i2 == 0)
            {
                coin2.setImage(ImageFactory.getInstance().createImage("coinBack").getImage());
                
            }
            else
            {
                coin2.setImage(ImageFactory.getInstance().createImage("coinFront").getImage());
                numberOfHeads++;
            }

            if (i3 == 0)
            {
                coin3.setImage(ImageFactory.getInstance().createImage("coinBack").getImage());
                
            }
            else
            {
                coin3.setImage(ImageFactory.getInstance().createImage("coinFront").getImage());
                numberOfHeads++;
            }
            flipped = true;
        }
    }

    /**
     * Armazena sequencia que cria e mostra a janela de inserção de nomes dos jogadores
     */
    public void launchNameWindow(){
        // Fecha a janela de informar nomes
        confirmNamesBtn = new Button("Confirmar");
        confirmNamesBtn.setOnAction(e -> trataBtnCloseConfirm(e));
        // Define janela de inserção de nomes
        GridPane gridNomes = new GridPane();
        gridNomes.setAlignment(Pos.CENTER);
        gridNomes.setHgap(10);
        gridNomes.setVgap(10);
        gridNomes.setPadding(new Insets(25, 25, 25, 25));
        gridNomes.add(confirmNamesBtn,1,4);
        // Lanca Stage para inserir nomes
        confirmNameScene = new Scene(gridNomes);
        confirmNameStage = new Stage();
        confirmNameStage.setScene(confirmNameScene);
        confirmNameStage.setTitle("Informe seus nomes.");

        Label lbP1InsertNome = new Label("Nome do Jogador 1:");
        gridNomes.add(lbP1InsertNome,0,2);
        jogador1 = new TextField();
        gridNomes.add(jogador1,1,2);
        Label lbP2InsertNome = new Label("Nome do Jogador 2:");
        gridNomes.add(lbP2InsertNome,0,3);
        jogador2 = new TextField();
        gridNomes.add(jogador2,1,3);

        confirmNameStage.show();
    }
    /**
     * Armazena sequencia que organiza a mao do jogador 1
     * 
     * @param grid GridPane do Stage principal
     */
    public void launchP1Hand(GridPane grid, int btnX, int btnY){
        // Cria botao da mao do jogador 1
        hnd1Btn = new Button("Mao do Jogador 1");
        hnd1Btn.setOnAction(e -> trataBtnHand1(e));
        grid.add(hnd1Btn, btnX, btnY);
        // Fecha a janela da mao do jogador 1
        hnd1CloseBtn = new Button("Encerrar Turno");
        hnd1CloseBtn.setOnAction(e -> trataBtnCloseHand1(e));
        // Define janela da mao do jogador 1
        hnd1Pane = new GridPane();
        hnd1Pane.setHgap(20);
        hnd1Pane.setVgap(10);
        hnd1Pane.setStyle("-fx-background-color:blue;-fx-padding:10px;");
        hnd1Pane.add(hnd1CloseBtn,2,4);

        List<String> cardsP1 = Game.getInstance().getHandP1().getCardNomes();
        cb1 = new ComboBox<String>(FXCollections.observableList(cardsP1));
        hnd1Pane.add(cb1,1,1);

        Button hnd1UseBtn = new Button("Usar");
        hnd1UseBtn.setOnAction(e -> trataBtnUsarCartaP1(e, cb1.getValue()));
        hnd1Pane.add(hnd1UseBtn,2,2);

        Button hnd1ShowBtn = new Button("Mostrar");
        hnd1ShowBtn.setOnAction(e -> trataBtnShowCartaP1(e, cb1.getValue()));
        hnd1Pane.add(hnd1ShowBtn,2,3);

        cartaMaoP1 = ImageFactory.getInstance().createImage("imgBck");
        cartaMaoP1.setFitHeight(200);
        cartaMaoP1.setPreserveRatio(true);
        hnd1Pane.add(cartaMaoP1,2,1);

        Label labCartaAtual = new Label("Pokémon Ativo:");
        hnd1Pane.add(labCartaAtual,0,0);
        Label labCartasMao = new Label("Sua Mão:");
        hnd1Pane.add(labCartasMao,2,0);

        cartaJogoP1Copia = ImageFactory.getInstance().createImage(Game.getInstance().getFieldP1().getCard().getImageId());
        cartaJogoP1Copia.setFitHeight(200);
        cartaJogoP1Copia.setPreserveRatio(true);
        hnd1Pane.add(cartaJogoP1Copia,0,1);

        Button hnd1Atk1Btn = new Button("Ataque 1");
        hnd1Atk1Btn.setOnAction(e->tratarBtnAtk1P1(e));
        hnd1Pane.add(hnd1Atk1Btn,0,2);

        Button hnd1Atk2Btn = new Button("Ataque 2");
        hnd1Atk2Btn.setOnAction(e->tratarBtnAtk2P1(e));
        hnd1Pane.add(hnd1Atk2Btn,0,3);

        Button hnd1RecuarBtn = new Button("Recuar");
        hnd1RecuarBtn.setOnAction(e->tratarBtnRecuarP1(e));
        hnd1Pane.add(hnd1RecuarBtn,0,4);

        // Lanca Stage para mao do jogador 1
        hnd1Scene = new Scene(hnd1Pane);
        hnd1Stage = new Stage();
        hnd1Stage.setScene(hnd1Scene);
        hnd1Stage.setTitle("Player 1 Hand");
    }
    /**
     * Armazena sequencia que organiza a mao do jogador 2
     * 
     * @param grid GridPane do Stage principal
     */
    public void launchP2Hand(GridPane grid, int btnX, int btnY){
        // Cria botao da mao do jogador 2
        hnd2Btn = new Button("Mao do Jogador 2");
        hnd2Btn.setOnAction(e -> trataBtnHand2(e));
        grid.add(hnd2Btn, btnX, btnY);
        // Fecha a janela da mao do jogador 1
        hnd2CloseBtn = new Button("Encerrar Turno");
        hnd2CloseBtn.setOnAction(e -> trataBtnCloseHand2(e));
        // Define janela da mao do jogador 1
        hnd2Pane = new GridPane();
        hnd2Pane.setHgap(20);
        hnd2Pane.setVgap(10);
        hnd2Pane.setStyle("-fx-background-color:blue;-fx-padding:10px;");
        hnd2Pane.add(hnd2CloseBtn,2,4);

        List<String> cardsP2 = Game.getInstance().getHandP2().getCardNomes();
        cb2 = new ComboBox<String>(FXCollections.observableList(cardsP2));
        hnd2Pane.add(cb2,1,1);

        Button hnd2UseBtn = new Button("Usar");
        hnd2UseBtn.setOnAction(e -> trataBtnUsarCartaP2(e, cb2.getValue()));
        hnd2Pane.add(hnd2UseBtn,2,2);

        Button hnd2ShowBtn = new Button("Mostrar");
        hnd2ShowBtn.setOnAction(e -> trataBtnShowCartaP2(e, cb2.getValue()));
        hnd2Pane.add(hnd2ShowBtn,2,3);

        cartaMaoP2 = ImageFactory.getInstance().createImage("imgBck");
        cartaMaoP2.setFitHeight(200);
        cartaMaoP2.setPreserveRatio(true);
        hnd2Pane.add(cartaMaoP2,2,1);

        Label labCartaAtual = new Label("Pokémon Ativo:");
        hnd1Pane.add(labCartaAtual,0,0);
        Label labCartasMao = new Label("Sua Mão:");
        hnd1Pane.add(labCartasMao,2,0);

        cartaJogoP2Copia = ImageFactory.getInstance().createImage(Game.getInstance().getFieldP2().getCard().getImageId());
        cartaJogoP2Copia.setFitHeight(200);
        cartaJogoP2Copia.setPreserveRatio(true);
        hnd2Pane.add(cartaJogoP2Copia,0,1);

        Button hnd2Atk1Btn = new Button("Ataque 1");
        hnd2Atk1Btn.setOnAction(e->tratarBtnAtk1P2(e));
        hnd2Pane.add(hnd2Atk1Btn,0,2);

        Button hnd2Atk2Btn = new Button("Ataque 2");
        hnd2Atk2Btn.setOnAction(e->tratarBtnAtk2P2(e));
        hnd2Pane.add(hnd2Atk2Btn,0,3);

        Button hnd2RecuarBtn = new Button("Recuar");
        hnd2RecuarBtn.setOnAction(e->tratarBtnRecuarP2(e));
        hnd2Pane.add(hnd2RecuarBtn,0,4);

        // Lanca Stage para mao do jogador 1
        hnd2Scene = new Scene(hnd2Pane);
        hnd2Stage = new Stage();
        hnd2Stage.setScene(hnd2Scene);
        hnd2Stage.setTitle("Player 2 Hand");
    }
    /**
     * Metodo que guarda os comandos do lado do jogador 1
     * @param grid GridPane onde tudo sera colocado
     * 
     * O metodo esta divido em blocos para facilitar a visualizacao
     * 
     * O primeiro bloco adiciona o Label do jogador 1
     * 
     * O segundo bloco adiciona o deck do jogador, criando uma imagem da primeira carta retirada
     * Futuramente essa carta sera um botao para selecionar as acoes da carta (Ataque, zoom)
     *  *****TEM QUE SER ADAPTADO PARA SOMENTE REAGIR AO GAME*****
     * 
     * O terceiro bloco cria uma imagem para representar o deck. Futuramente pode ser um botao para o proprio deck
     * 
     * O quarto bloco adiciona Label para dar informacoes da carta no campo
     * 
     * O quinto bloco adiciona Label para dar informacoes do deck e da pilha de descarte
     * 
     * O sexto bloco/linha adiciona o botao da mao do jogador
     *  
     */
    public void launchP1Field(GridPane grid){
        
        GridPane gridP1 = new GridPane();
        gridP1.setHgap(15);
        gridP1.setVgap(10);
        gridP1.setPadding(new Insets(25, 25, 25, 25));

        lbP1 = new Label("Jogador 1");
        gridP1.add(lbP1, 2, 1);

        fieldCardP1 = new FieldCardView(1);
        cartaJogoP1 = ImageFactory.getInstance().createImage("imgBck");
        cartaJogoP1.setFitHeight(250);
        cartaJogoP1.setPreserveRatio(true);
        gridP1.add(cartaJogoP1, 2, 0);

        ImageView deck1View = ImageFactory.getInstance().createImage("imgBck");
        deck1View.setFitHeight(200);
        deck1View.setPreserveRatio(true);
        gridP1.add(deck1View, 3, 0);

        PokemonCard pc = fieldCardP1.getFieldCard().getCard();


        infoPokemon1 = new Label(
            pc.getNome() + "    HP: " + pc.getCurrentHP() + "\n\nEnergias(" + Game.getInstance().getEnergiasP1() +"):\nFire: "
            + Game.getInstance().getEnergias(Tipo.Fire) + "\nGrass: " + Game.getInstance().getEnergias(Tipo.Grass) +
            "\n\nStatus:" + Game.getInstance().getFieldP1().getCard().getStatusText() +
            "\n\nPilha de Descarte(" + Game.getInstance().getTotalDescarteP1() + "):\nPokémon: " + Game.getInstance().getDescPokP1()
            + "\nTreinador: " + Game.getInstance().getDescTreiP1() + "\nEnergia: " + Game.getInstance().getDescEnerP1()
        );
        gridP1.add(infoPokemon1, 1, 0);

        infoDeck1 = new Label(
            "Deck: " + Game.getInstance().getListDeckP1().size()
        );
        gridP1.add(infoDeck1, 4, 0);

        launchP1Hand(gridP1, 1, 1);

        GridPane lifeBar = new GridPane();
        lifeBar.setHgap(5);
        ImageView c1p1 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c2p1 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c3p1 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c4p1 = ImageFactory.getInstance().createImage("fullheart");
        c1p1.setFitHeight(20);
        c1p1.setFitWidth(20);
        c2p1.setFitHeight(20);
        c2p1.setFitWidth(20);
        c3p1.setFitHeight(20);
        c3p1.setFitWidth(20);
        c4p1.setFitHeight(20);
        c4p1.setFitWidth(20);
        lifeBar.add(c1p1, 0, 0);
        lifeBar.add(c2p1, 1, 0);
        lifeBar.add(c3p1, 2, 0);
        lifeBar.add(c4p1, 3, 0);
        gridP1.add(lifeBar, 3, 1);

        grid.add(gridP1, 0, 2);

    }

    public void launchP2Field(GridPane grid){

        GridPane gridP2 = new GridPane();
        gridP2.setHgap(15);
        gridP2.setVgap(15);
        gridP2.setPadding(new Insets(25, 25, 25, 25));

        lbP2 = new Label("Jogador 2");
        gridP2.add(lbP2, 2, 0);

        fieldCardP2 = new FieldCardView(2);
        cartaJogoP2 = ImageFactory.getInstance().createImage("imgBck");
        cartaJogoP2.setFitHeight(250);
        cartaJogoP2.setPreserveRatio(true);
        gridP2.add(cartaJogoP2, 2, 1);

        ImageView deck2View = ImageFactory.getInstance().createImage("imgBck");
        deck2View.setFitHeight(200);
        deck2View.setFitWidth(150);
        gridP2.add(deck2View, 1, 1);

        PokemonCard pc = fieldCardP2.getFieldCard().getCard();
        infoPokemon2 = new Label(
            pc.getNome() + "    HP: " + pc.getCurrentHP() + "\n\nEnergias(" + Game.getInstance().getEnergiasP2() +"):\nSteel: "
            + Game.getInstance().getEnergias(Tipo.Steel) + "\nWater: " + Game.getInstance().getEnergias(Tipo.Water) +
            "\n\nStatus:" + Game.getInstance().getFieldP2().getCard().getStatusText() + 
            "\n\nPilha de Descarte(" + Game.getInstance().getTotalDescarteP2() + "):\nPokémon: " + Game.getInstance().getDescPokP2()
            + "\nTreinador: " + Game.getInstance().getDescTreiP2() + "\nEnergia: " + Game.getInstance().getDescEnerP2()
        );
        gridP2.add(infoPokemon2, 3, 1);

        infoDeck2 = new Label(
            "Deck: " + Game.getInstance().getListDeckP2().size()
        );
        gridP2.add(infoDeck2, 0, 1);

        launchP2Hand(gridP2, 3, 0);

        GridPane lifeBar = new GridPane();
        lifeBar.setHgap(5);
        c1p2 = ImageFactory.getInstance().createImage("fullheart");
        c2p2 = ImageFactory.getInstance().createImage("fullheart");
        c3p2 = ImageFactory.getInstance().createImage("fullheart");
        c4p2 = ImageFactory.getInstance().createImage("fullheart");
        c1p2.setFitHeight(20);
        c1p2.setFitWidth(20);
        c2p2.setFitHeight(20);
        c2p2.setFitWidth(20);
        c3p2.setFitHeight(20);
        c3p2.setFitWidth(20);
        c4p2.setFitHeight(20);
        c4p2.setFitWidth(20);
        lifeBar.add(c1p2, 0, 0);
        lifeBar.add(c2p2, 1, 0);
        lifeBar.add(c3p2, 2, 0);
        lifeBar.add(c4p2, 3, 0);
        gridP2.add(lifeBar, 1, 0);

        grid.add(gridP2, 0, 1);

    }
    /**
     * Metodo que guarda instrucoes dos comandos da barra superior
     * @param grid GridPane principal onde ficara a barra de comandos
     */
    public void launchTopCommands(GridPane grid, Stage primaryStage){
        GridPane gridTopCmd = new GridPane();
        gridTopCmd.setHgap(50);
        gridTopCmd.setVgap(10);
        gridTopCmd.setPadding(new Insets(25, 25, 25, 25));
        
        Button nextBtn = new Button("Passar turno");
        nextBtn.setOnAction(e -> {
            Game.getInstance().nextPlayer();
            updateLabels();
        });
        gridTopCmd.add(nextBtn, 0, 0);

        Button changeNameBtn = new Button("Mudar Nomes");
        changeNameBtn.setOnAction(e -> launchNameWindow());
        gridTopCmd.add(changeNameBtn, 1, 0);

        Button resetBtn = new Button("Reiniciar");
        resetBtn.setOnAction(e -> {
            acabou=true;
            turnFinished=true;
            flipped = true;
            reachedLoop=true;
            primaryStage.close();
            hnd1Stage.close();
            hnd2Stage.close();
            confirmNameStage.close();
            coinFlipStage.close();
            tripleCoinFlipStage.close();
            
            Game.getInstance().newGame();
            Stage newStage = new Stage();
            try{
                start(newStage);
            }
            catch(Exception ex)
            {
                System.out.println(e);
            }
        });
        gridTopCmd.add(resetBtn, 2, 0);

        Button exitBtn = new Button("Sair");
        exitBtn.setOnAction(e -> {
            acabou=true;
            turnFinished=true;
            flipped = true;
            reachedLoop=true;
            primaryStage.close();
            hnd1Stage.close();
            hnd2Stage.close();
            confirmNameStage.close();
            coinFlipStage.close();
            tripleCoinFlipStage.close();
            System.exit(0);
        });
        gridTopCmd.add(exitBtn, 3, 0);

        playerTurn = new Label();
        if (Game.getInstance().getPlayer() == 1){
            playerTurn.setText("Vez de " + jogador1Nome);
        }
        else {
            playerTurn.setText("Vez de " + jogador2Nome);
        }
        gridTopCmd.add(playerTurn, 4, 0);

        grid.add(gridTopCmd, 0, 0);

    }
   
    @Override
    public void start(Stage primaryStage) throws Exception {
        Game.getInstance().addObserver(this);
        reachedLoop=false;
        winnerIfTie = 0;
        fimPorBasicos = false;
        fimPorCartas = false;

        primaryStage.setTitle("JavaFX - Batalha Pokemon");
        jogador1Nome = "Jogador 1";
        jogador2Nome = "Jogador 2";

        //Cria Grid
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        launchP1Field(grid);
        launchP2Field(grid);
        launchTopCommands(grid, primaryStage);
      
        
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show();

        launchNameWindow();

        launchCoinFlipWindow();
        launchTripleCoinFlipWindow();
        launchPopUp();

        popUpLabel.setText("Vez de " + jogador1Nome);
        popUpStage.showAndWait();

        trataBtnHand1(null);
        
        popUpLabel.setText("Vez de " + jogador2Nome);
        popUpStage.showAndWait();

        playerTurn.setText("Vez de " + jogador2Nome);

        trataBtnHand2(null);

        updateLabels();

        popUpLabel.setText("Vez de " + jogador1Nome);
        popUpStage.showAndWait();

        turnFinished=false;
        reachedLoop=true;
        playerTurn.setText("Vez de " + jogador1Nome);
        while (!acabou)
        {
            if(Game.getInstance().getFimDeJogo())
            {
                acabou = true;
            }
            else if(Game.getInstance().getPlayer()==1&&Game.getInstance().getFimDeJogoPorCartas(1))
            {
                acabou = true;
                fimPorCartas = true;
            }
            else if(Game.getInstance().getPlayer()==1&&Game.getInstance().getFieldP1().getCard().getNome().equals("null")&&!Game.getInstance().getHandP1().checkContainsBasic())
            {
                acabou = true;
                fimPorBasicos = true;
            }
            else if (Game.getInstance().getPlayer()==2&&Game.getInstance().getFimDeJogoPorCartas(2))
            {
                acabou = true;
                fimPorCartas = true;
            }
            else if(Game.getInstance().getPlayer()==2&&Game.getInstance().getFieldP2().getCard().getNome().equals("null")&&!Game.getInstance().getHandP2().checkContainsBasic())
            {
                acabou = true;
                fimPorBasicos = true;
            }
            else if (Game.getInstance().getPlayer()==1&&!turnFinished)
            {
                playerTurn.setText("Vez de " + jogador1Nome);
                Card c = Game.getInstance().getListDeckP1().remove(0);
                Game.getInstance().getHandP1().addCard(c);
                cb1.getItems().add(c.getNome());
                cb1.getItems().remove("null");
                while(!turnFinished)
                {
                    trataBtnHand1(null);
                    updateLabels();
                }
                if (Game.getInstance().getFieldP1().getCard().getStatus3().equalsIgnoreCase("Paralizado")) {Game.getInstance().getFieldP1().getCard().curaStatus3();}
                p1CuraDormindo();
                p2EffectPoison();
                p1EffectPoison();
                p2EffectBurn();
                p1EffectBurn();
                Game.getInstance().checkCardP2Defeat();
                Game.getInstance().checkCardP1Defeat();
                winnerIfTie=1;
                acabou = Game.getInstance().getFimDeJogo();
                updateLabels();
            }
            else if (Game.getInstance().getPlayer()==1)
            {
                if(Game.getInstance().getFieldP2().getCard().getNome().equals("null"))
                {
                    popUpLabel.setText(jogador2Nome + ", selecione um Pokémon ativo");
                    popUpStage.showAndWait();
                    trataBtnHand2(null);
                    updateLabels();
                }
                if(Game.getInstance().getFieldP1().getCard().getNome().equals("null"))
                {
                    popUpLabel.setText(jogador1Nome + ", selecione um Pokémon ativo");
                    popUpStage.showAndWait();
                    trataBtnHand1(null);
                    updateLabels();
                }
                else 
                {
                    popUpLabel.setText("Vez de " + jogador2Nome);
                    popUpStage.showAndWait();
                }
                turnFinished=false;
                Game.getInstance().nextPlayer();
            }
            else if (Game.getInstance().getPlayer()==2&&!turnFinished)
            {
                playerTurn.setText("Vez de " + jogador2Nome);
                Card c = Game.getInstance().getListDeckP2().remove(0);
                Game.getInstance().getHandP2().addCard(c);
                cb2.getItems().add(c.getNome());
                cb2.getItems().remove("null");
                while(!turnFinished)
                {
                    trataBtnHand2(null);
                    updateLabels();
                }
                if (Game.getInstance().getFieldP2().getCard().getStatus3().equalsIgnoreCase("Paralizado")) {Game.getInstance().getFieldP2().getCard().curaStatus3();}
                p2CuraDormindo();
                p2EffectPoison();
                p1EffectPoison();
                p2EffectBurn();
                p1EffectBurn();
                Game.getInstance().checkCardP1Defeat();
                Game.getInstance().checkCardP2Defeat();
                winnerIfTie=2;
                updateLabels();
                acabou = Game.getInstance().getFimDeJogo();
            }
            else if (Game.getInstance().getPlayer()==2)
            {
                acabou = Game.getInstance().getFimDeJogo();
                if(Game.getInstance().getFieldP1().getCard().getNome().equals("null"))
                {
                    popUpLabel.setText(jogador1Nome + ", selecione um Pokémon ativo");
                    popUpStage.showAndWait();
                    trataBtnHand1(null);
                    updateLabels();
                }
                if(Game.getInstance().getFieldP2().getCard().getNome().equals("null"))
                {
                    popUpLabel.setText(jogador2Nome + ", selecione um Pokémon ativo");
                    popUpStage.showAndWait();
                    trataBtnHand2(null);
                    updateLabels();
                }
                else
                {
                    popUpLabel.setText("Vez de " + jogador1Nome);
                    popUpStage.showAndWait();
                }
                turnFinished=false;
                Game.getInstance().nextPlayer();
            }
        }

        //VERIFICA VENCEDOR
        if (!fimPorBasicos&&!fimPorCartas)
        {
            System.out.println("O jogador " + winnerIfTie + "venceu");
            System.out.println("fim por vidas");
        }
        else if (fimPorBasicos||fimPorCartas)
        {
            if (Game.getInstance().getPlayer()==1)
            {
                System.out.println("O jogador 2 venceu");
                System.out.println("fim basico ou cartas");
            }
            else
            {
                System.out.println("O jogador 1 venceu");
                System.out.println("fim basico ou cartas");
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        
        if (arg == null){
            return;
        }

        GameEvent ge = (GameEvent) arg;

        if (ge.getTarget() == GameEvent.Target.App){

            switch(ge.getAction()){
                case PLayerFieldOption:
                    GridPane pOpPane = new GridPane();
                    pOpPane.setAlignment(Pos.CENTER);
                    pOpPane.setVgap(10);
                    pOpPane.setStyle("-fx-background-color:tan");
                    pOpPane.setMinSize(100, 200);

                    Button ataque1 = new Button("Ataque 1");
                    pOpPane.add(ataque1, 0, 0);

                    if (fieldCardP1.getFieldCard().getCard().getAtaque2() != null){
                        Button ataque2 = new Button("Ataque 2");
                        pOpPane.add(ataque2, 0, 1);
                    }

                    Button zoom = new Button("Zoom");
                    pOpPane.add(zoom, 0, 2);
                    Button cancel = new Button("Cancelar");
                    pOpPane.add(cancel, 0, 3);

                    Scene pOpScene = new Scene(pOpPane);
                    Stage pOpStage = new Stage();
                    pOpStage.setScene(pOpScene);
                    pOpStage.setTitle("Options");
                    pOpStage.show();

            }


        }

    }

    public void updateLabels() {
        PokemonCard pc1 = fieldCardP1.getFieldCard().getCard();
        PokemonCard pc2 = fieldCardP2.getFieldCard().getCard();

        infoPokemon1.setText(Game.getInstance().getFieldP1().getCard().getNome() + "    HP: " + Game.getInstance().getFieldP1().getCard().getCurrentHP() + "\n\nEnergias(" + Game.getInstance().getEnergiasP1() +"):\nFire: "
        + Game.getInstance().getEnergias(Tipo.Fire) + "\nGrass: " + Game.getInstance().getEnergias(Tipo.Grass)+ 
        "\n\nStatus:" + Game.getInstance().getFieldP1().getCard().getStatusText() +
        "\n\nPilha de Descarte(" + Game.getInstance().getTotalDescarteP1() + "):\nPokémon: " + Game.getInstance().getDescPokP1()
        + "\nTreinador: " + Game.getInstance().getDescTreiP1() + "\nEnergia: " + Game.getInstance().getDescEnerP1());

        infoPokemon2.setText(Game.getInstance().getFieldP2().getCard().getNome() + "    HP: " + Game.getInstance().getFieldP2().getCard().getCurrentHP() + "\n\nEnergias(" + Game.getInstance().getEnergiasP2() +"):\nSteel: "
        + Game.getInstance().getEnergias(Tipo.Steel) + "\nWater: " + Game.getInstance().getEnergias(Tipo.Water) + 
        "\n\nStatus:" + Game.getInstance().getFieldP2().getCard().getStatusText() +
        "\n\nPilha de Descarte(" + Game.getInstance().getTotalDescarteP2() + "):\nPokémon: " + Game.getInstance().getDescPokP2()
        + "\nTreinador: " + Game.getInstance().getDescTreiP2() + "\nEnergia: " + Game.getInstance().getDescEnerP2());

        infoDeck1.setText("Deck: " + Game.getInstance().getListDeckP1().size());
        infoDeck2.setText("Deck: " + Game.getInstance().getListDeckP2().size());        
        lbP1.setText(jogador1Nome);
        lbP2.setText(jogador2Nome);

        Card c1 = Game.getInstance().getFieldP1().getCard();
        cartaJogoP1Copia.setImage(ImageFactory.getInstance().createImage(c1.getImageId()).getImage());
        cartaJogoP1.setImage(ImageFactory.getInstance().createImage(c1.getImageId()).getImage());

        Card c2 = Game.getInstance().getFieldP2().getCard();
        cartaJogoP2Copia.setImage(ImageFactory.getInstance().createImage(c2.getImageId()).getImage());
        cartaJogoP2.setImage(ImageFactory.getInstance().createImage(c2.getImageId()).getImage());

        Image img = ImageFactory.getInstance().createImage("emptyheart").getImage();
        if (Game.getInstance().getP1Life()<4) {c1p1.setImage(img);}
        if (Game.getInstance().getP1Life()<3) {c2p1.setImage(img);}
        if (Game.getInstance().getP1Life()<2) {c3p1.setImage(img);}
        if (Game.getInstance().getP1Life()<1) {c4p1.setImage(img);}

        if (Game.getInstance().getP2Life()<4) {c1p2.setImage(img);}
        if (Game.getInstance().getP2Life()<3) {c2p2.setImage(img);}
        if (Game.getInstance().getP2Life()<2) {c3p2.setImage(img);}
        if (Game.getInstance().getP2Life()<1) {c4p2.setImage(img);}
    }

    public boolean verificaUsarAtaqueP1(Ataque atk)
    {
        Tipo ener = atk.getTipoEnergia();
        return (Game.getInstance().getEnergias(ener)>=atk.getCustoTipo()&&Game.getInstance().getEnergiasP1()>=atk.getCustoTotal());
    }

    public boolean verificaUsarAtaqueP2(Ataque atk)
    {
        Tipo ener = atk.getTipoEnergia();
        return (Game.getInstance().getEnergias(ener)>=atk.getCustoTipo()&&Game.getInstance().getEnergiasP2()>=atk.getCustoTotal());
    }

    public void ativaHauP1()
    {
        int limit;
        if (Game.getInstance().getListDeckP1().size()>=3)
        {
            limit=3;
        }
        else {limit=Game.getInstance().getListDeckP1().size();}
        for (int pos=0;pos<limit;pos++)
        {
            Card c = Game.getInstance().getListDeckP1().remove(0);
            Game.getInstance().getHandP1().addCard(c);
            cb1.getItems().add(c.getNome());
            cb1.getItems().remove("null");
        }
    }

    public void ativaHauP2()
    {
        int limit;
        if (Game.getInstance().getListDeckP2().size()>=3)
        {
            limit=3;
        }
        else {limit=Game.getInstance().getListDeckP2().size();}
        for (int pos=0;pos<limit;pos++)
        {
            Card c = Game.getInstance().getListDeckP2().remove(0);
            Game.getInstance().getHandP2().addCard(c);
            cb2.getItems().add(c.getNome());
            cb2.getItems().remove("null");
        }
    }

    public int findDanoAtaqueP2(Ataque atk)
    {
        PokemonCard copyP1 = Game.getInstance().getFieldP1().getCard();
        PokemonCard copyP2 = Game.getInstance().getFieldP2().getCard();
        int dano = atk.getDano();

        if (atk.getIdEfeito()==1) {Game.getInstance().getFieldP2().getCard().heal(10);}
        else if (atk.getIdEfeito()==2)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano*=numberOfHeads;
        }
        else if (atk.getIdEfeito()==3) {dano+=copyP1.getDamageTaken();}
        else if (atk.getIdEfeito()==4) {dano+=(10*Game.getInstance().getDescPokP2());}
        else if (atk.getIdEfeito()==5) {Game.getInstance().getFieldP2().getCard().damage(10);}
        else if (atk.getIdEfeito()==6) {Game.getInstance().getFieldP1().getCard().setStatus3("Confuso");}
        else if (atk.getIdEfeito()==7)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano+=(20*numberOfHeads);
        }
        else if (atk.getIdEfeito()==8)
        {
            if (Game.getInstance().getListDeckP2().size()!=0) 
            {
                Card c = Game.getInstance().getListDeckP2().remove(0);
                Game.getInstance().getHandP2().addCard(c);
                cb2.getItems().add(c.getNome());
                cb2.getItems().remove("null");
            }
        }
        else if (atk.getIdEfeito()==9)
        {
            if(copyP1.getQueimado()||copyP1.getEnvenenado()||!copyP1.getStatus3().equals("none"))
            {
                dano+=90;
            }
        }
        else if (atk.getIdEfeito()==10) {Game.getInstance().getFieldP1().getCard().setStatus3("Dormindo");}
        else if (atk.getIdEfeito()==11) {Game.getInstance().getFieldP1().getCard().setEnvenenado();}
        else if (atk.getIdEfeito()==12) {Game.getInstance().getFieldP1().getCard().setQueimado();}
        else if (atk.getIdEfeito()==13)
        {
            Game.getInstance().getFieldP1().getCard().setEnvenenado();
            Game.getInstance().getFieldP1().getCard().setQueimado();
        }
        else if (atk.getIdEfeito()==14) 
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                tripleCoinFlipStage.showAndWait();
            }
            dano*=numberOfHeads;
        }
        else if (atk.getIdEfeito()==15)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano+=(40*numberOfHeads);
        }
        else if (atk.getIdEfeito()==16)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano+=(30*numberOfHeads);
        }
        else if (atk.getIdEfeito()==17) 
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            if(numberOfHeads==1) {Game.getInstance().getFieldP1().getCard().setStatus3("Paralizado");}
        }

        if (copyP1.getFraquezaTipo()==copyP2.getTipo()) {dano*=2;}
        if (copyP1.getResistenciaTipo()==copyP2.getTipo()) {dano-=copyP1.getResistenciaValor();}

        return dano;
    }

    public int findDanoAtaqueP1(Ataque atk)
    {
        PokemonCard copyP1 = Game.getInstance().getFieldP1().getCard();
        PokemonCard copyP2 = Game.getInstance().getFieldP2().getCard();
        int dano = atk.getDano();

        if (atk.getIdEfeito()==1) {Game.getInstance().getFieldP1().getCard().heal(10);}
        else if (atk.getIdEfeito()==2)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano*=numberOfHeads;
        }
        else if (atk.getIdEfeito()==3) {dano+=copyP2.getDamageTaken();}
        else if (atk.getIdEfeito()==4) {dano+=(10*Game.getInstance().getDescPokP1());}
        else if (atk.getIdEfeito()==5) {Game.getInstance().getFieldP1().getCard().damage(10);}
        else if (atk.getIdEfeito()==6) {Game.getInstance().getFieldP2().getCard().setStatus3("Confuso");}
        else if (atk.getIdEfeito()==7)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano+=(20*numberOfHeads);
        }
        else if (atk.getIdEfeito()==8)
        {
            if (Game.getInstance().getListDeckP1().size()!=0) 
            {
                Card c = Game.getInstance().getListDeckP1().remove(0);
                Game.getInstance().getHandP1().addCard(c);
                cb1.getItems().add(c.getNome());
                cb1.getItems().remove("null");
            }
        }
        else if (atk.getIdEfeito()==9)
        {
            if(copyP2.getQueimado()||copyP2.getEnvenenado()||!copyP2.getStatus3().equals("none"))
            {
                dano+=90;
            }
        }
        else if (atk.getIdEfeito()==10) {Game.getInstance().getFieldP2().getCard().setStatus3("Dormindo");}
        else if (atk.getIdEfeito()==11) {Game.getInstance().getFieldP2().getCard().setEnvenenado();}
        else if (atk.getIdEfeito()==12) {Game.getInstance().getFieldP2().getCard().setQueimado();}
        else if (atk.getIdEfeito()==13)
        {
            Game.getInstance().getFieldP2().getCard().setEnvenenado();
            Game.getInstance().getFieldP2().getCard().setQueimado();
        }
        else if (atk.getIdEfeito()==14) 
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                tripleCoinFlipStage.showAndWait();
            }
            dano*=numberOfHeads;
        }
        else if (atk.getIdEfeito()==15)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano+=(40*numberOfHeads);
        }
        else if (atk.getIdEfeito()==16)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            dano+=(30*numberOfHeads);
        }
        else if (atk.getIdEfeito()==17)
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            if(numberOfHeads==1) {Game.getInstance().getFieldP2().getCard().setStatus3("Paralizado");}
        }

        if (copyP2.getFraquezaTipo()==copyP1.getTipo()) {dano*=2;}
        if (copyP2.getResistenciaTipo()==copyP1.getTipo()) {dano-=copyP2.getResistenciaValor();}

        return dano;
    }

    public void p1CuraDormindo()
    {
        if (Game.getInstance().getFieldP1().getCard().getStatus3().equalsIgnoreCase("Dormindo"))
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            if (numberOfHeads==1) {Game.getInstance().getFieldP1().getCard().curaStatus3();}
        }
    }

    public void p2CuraDormindo()
    {
        if (Game.getInstance().getFieldP2().getCard().getStatus3().equalsIgnoreCase("Dormindo"))
        {
            flipped = false;
            while(!flipped)
            {
                numberOfHeads = 0;
                coinFlipStage.showAndWait();
            }
            if (numberOfHeads==1) {Game.getInstance().getFieldP2().getCard().curaStatus3();}
        }
    }

    public void p1EffectPoison()
    {
        if (Game.getInstance().getFieldP1().getCard().getEnvenenado())
        {
            Game.getInstance().getFieldP1().getCard().damage(10);
        }
    }

    public void p2EffectPoison()
    {
        if (Game.getInstance().getFieldP2().getCard().getEnvenenado())
        {
            Game.getInstance().getFieldP2().getCard().damage(10);
        }
    }

    public void p1EffectBurn()
    {
        if(Game.getInstance().getFieldP1().getCard().getQueimado())
        {
            Game.getInstance().getFieldP1().getCard().damage(20);
            if (Game.getInstance().getFieldP1().getCard().getCurrentHP()>=0)
            {
                flipped = false;
                while(!flipped)
                {
                    numberOfHeads = 0;
                    coinFlipStage.showAndWait();
                }
                if (numberOfHeads==1) {Game.getInstance().getFieldP1().getCard().curaQueimado();}
            }
        }
    }

    public void p2EffectBurn()
    {
        if(Game.getInstance().getFieldP2().getCard().getQueimado())
        {
            Game.getInstance().getFieldP2().getCard().damage(20);
            if (Game.getInstance().getFieldP2().getCard().getCurrentHP()>=0)
            {
                flipped = false;
                while(!flipped)
                {
                    numberOfHeads = 0;
                    coinFlipStage.showAndWait();
                }
                if (numberOfHeads==1) {Game.getInstance().getFieldP2().getCard().curaQueimado();}
            }
        }
    }

    public static void main(String args[]){
        launch(args);
    }
}