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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;


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
    private Button hnd1Btn, hnd2Btn, hnd1CloseBtn, hnd2CloseBtn, confirmNamesBtn;
    private Stage hnd1Stage, hnd2Stage, confirmNameStage;
    private Scene fieldScene, hnd1Scene, hnd2Scene, confirmNameScene;
    private FlowPane hnd1Pane, hnd2Pane;
    private Label lbP1, lbP2, infoPokemon1, infoPokemon2, infoDeck1, infoDeck2;
    private String jogador1Nome, jogador2Nome;
    private TextField jogador1, jogador2;

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
     * Metodo para tratar acao do botao para fechar mao do jogador 1
     * 
     * @param e Evento do botao
     *          Ao ser precionado, o botao fecha a tela
     */
    public void trataBtnCloseHand1(ActionEvent e) {
        hnd1Stage.close();
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
     * Metodo para tratar acao do botao para fechar mao do jogador 2
     * 
     * @param e Evento do botao
     *          Ao ser precionado, o botao fecha a tela
     */
    public void trataBtnCloseHand2(ActionEvent e) {
        hnd2Stage.close();
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
        confirmNameStage.close();
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
        hnd1CloseBtn = new Button("Fechar");
        hnd1CloseBtn.setOnAction(e -> trataBtnCloseHand1(e));
        // Define janela da mao do jogador 1
        hnd1Pane = new FlowPane();
        hnd1Pane.setHgap(20);
        hnd1Pane.setStyle("-fx-background-color:blue;-fx-padding:10px;");
        hnd1Pane.getChildren().add(hnd1CloseBtn);
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
        // Fecha a janela da mao do jogador 2
        hnd2CloseBtn = new Button("Fechar");
        hnd2CloseBtn.setOnAction(e -> trataBtnCloseHand2(e));
        // Define janela da mao do jogador 2
        hnd2Pane = new FlowPane();
        hnd2Pane.setHgap(20);
        hnd2Pane.setStyle("-fx-background-color:red;-fx-padding:10px;");
        hnd2Pane.getChildren().add(hnd2CloseBtn);
        // Lanca Stage para mao do jogador 2
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
     * COISA A SEREM ADICIONADAS:
     * - Vidas do jogador em coracoes
     * 
     */
    public void launchP1Field(GridPane grid){
        
        GridPane gridP1 = new GridPane();
        gridP1.setHgap(15);
        gridP1.setVgap(10);
        gridP1.setPadding(new Insets(25, 25, 25, 25));

        lbP1 = new Label("Jogador 1");
        gridP1.add(lbP1, 2, 1);
        
        CardDeck deck1 = new CardDeck(1);
        CardView fieldCard = new CardView(deck1.draw());
        fieldCard.setStyle("-fx-border-width: 225; -fx-border-height: 300");
        gridP1.add(fieldCard, 2, 0);

        ImageView deck1View = ImageFactory.getInstance().createImage("imgBck");
        deck1View.setFitHeight(200);
        deck1View.setFitWidth(150);
        gridP1.add(deck1View, 3, 0);

        infoPokemon1 = new Label(
            "*Nome Pokemon*    HP: 40\n\nEnergias(3):\nFogo: 1\nGrama: 2\n\nStatus:\nEnvenenado\nQueimado\nParalizado"
        );
        gridP1.add(infoPokemon1, 1, 0);

        infoDeck1 = new Label(
            "Deck: 14\n\nPilha de Descarte(11):\nPokemon: 5\nTreinador: 1\nEnergia: 5"
        );
        gridP1.add(infoDeck1, 4, 0);

        launchP1Hand(gridP1, 1, 1);

        GridPane lifeBar = new GridPane();
        lifeBar.setHgap(5);
        ImageView c1 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c2 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c3 = ImageFactory.getInstance().createImage("fullheart");
        c1.setFitHeight(20);
        c1.setFitWidth(20);
        c2.setFitHeight(20);
        c2.setFitWidth(20);
        c3.setFitHeight(20);
        c3.setFitWidth(20);
        lifeBar.add(c1, 0, 0);
        lifeBar.add(c2, 1, 0);
        lifeBar.add(c3, 2, 0);
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
        CardDeck deck2 = new CardDeck(2);
        ImageView dck2CardView = ImageFactory.getInstance().createImage(deck2.draw().getImageId());
        dck2CardView.setFitHeight(300); // Ajusta altura da imagem
        dck2CardView.setFitWidth(225); // Ajusta largura da imagem
        gridP2.add(dck2CardView, 2, 1);

        ImageView deck2View = ImageFactory.getInstance().createImage("imgBck");
        deck2View.setFitHeight(200);
        deck2View.setFitWidth(150);
        gridP2.add(deck2View, 1, 1);

        infoPokemon2 = new Label(
            "*Nome Pokemon*    HP: 50\n\nEnergias(4):\nFogo: 3\nGrama: 1\n\nStatus:\nEnvenenado\nParalizado"
        );
        gridP2.add(infoPokemon2, 3, 1);

        infoDeck2 = new Label(
            "Deck: 22\n\nPilha de Descarte(5):\nPokemon: 1\nTreinador: 1\nEnergia: 3"
        );
        gridP2.add(infoDeck2, 0, 1);

        launchP2Hand(gridP2, 3, 0);

        GridPane lifeBar = new GridPane();
        lifeBar.setHgap(5);
        ImageView c1 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c2 = ImageFactory.getInstance().createImage("fullheart");
        ImageView c3 = ImageFactory.getInstance().createImage("emptyheart");
        c1.setFitHeight(20);
        c1.setFitWidth(20);
        c2.setFitHeight(20);
        c2.setFitWidth(20);
        c3.setFitHeight(20);
        c3.setFitWidth(20);
        lifeBar.add(c1, 0, 0);
        lifeBar.add(c2, 1, 0);
        lifeBar.add(c3, 2, 0);
        gridP2.add(lifeBar, 1, 0);

        grid.add(gridP2, 0, 1);

    }

    public void launchTopCommands(GridPane grid){
        GridPane gridTopCmd = new GridPane();
        gridTopCmd.setHgap(50);
        gridTopCmd.setVgap(10);
        gridTopCmd.setPadding(new Insets(25, 25, 25, 25));
        
        Button changeNameBtn = new Button("Mudar Nomes");
        changeNameBtn.setOnAction(e -> launchNameWindow());
        gridTopCmd.add(changeNameBtn, 1, 0);

        Button resetBtn = new Button();
        resetBtn.setText("Reiniciar");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateLabels();
            }
        });
        gridTopCmd.add(resetBtn, 2, 0);

        grid.add(gridTopCmd, 0, 0);

    }
   
    @Override
    public void start(Stage primaryStage) throws Exception {
        Game.getInstance().addObserver(this);

        primaryStage.setTitle("JavaFX - Batalha Pokemon");
        jogador1Nome = "Jogador 1";
        jogador2Nome = "Jogador 2";

        //Cria Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        launchP1Field(grid);
        launchP2Field(grid);
        launchTopCommands(grid);
      
        
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show();

        launchNameWindow();
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub

    }

    public void updateLabels() {
        infoPokemon1.setText("*Nome Pokemon*    HP: 60\n\nEnergias(0):\n\n\n\nStatus:");
        infoPokemon2.setText("*Nome Pokemon*    HP: 60\n\nEnergias(0):\n\n\n\nStatus:");
        infoDeck1.setText("Deck: 30\n\nPilha de Descarte(0):");
        infoDeck2.setText("Deck: 30\n\nPilha de Descarte(0):");
        lbP1.setText(jogador1Nome);
        lbP2.setText(jogador2Nome);
    }

    public static void main(String args[]){
        launch(args);
    }
    
    

}