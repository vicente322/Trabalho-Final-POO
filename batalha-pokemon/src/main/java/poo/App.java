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
import javafx.scene.layout.HBox;

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
    private HandView handViewP1, handViewP2;
    private Button hnd2Btn, hnd2CloseBtn, confirmNamesBtn;
    private Stage hnd1Stage, hnd2Stage, confirmNameStage, pOpStage;
    private Scene fieldScene, hnd2Scene, confirmNameScene;
    private Label playerTurn, lbP1, lbP2, infoPokemon1, infoPokemon2, infoDeck1, infoDeck2;
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
        updateLabels();
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
        
        Button hnd1Btn = new Button("Mao do Jogador 1");
        hnd1Btn.setOnAction(e -> trataBtnHand1(e));
        grid.add(hnd1Btn, btnX, btnY);

        // Define janela da mao do jogador 1
        GridPane hnd1Pane = new GridPane();
        hnd1Pane.setHgap(20);
        hnd1Pane.setStyle("-fx-background-color:blue;-fx-padding:10px;");
        hnd1Pane.setMinSize(225, 300);

        Button hnd1CloseBtn = new Button("Fechar");
        hnd1CloseBtn.setOnAction(e -> trataBtnCloseHand1(e));
        hnd1Pane.add(hnd1CloseBtn, 0, 1);

        handViewP1 = new HandView(1);
        hnd1Pane.add(handViewP1, 0, 0);
        // Lanca Stage para mao do jogador 1
        Scene hnd1Scene = new Scene(hnd1Pane);
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

        handViewP2 = new HandView(2);

        // Define janela da mao do jogador 2
        GridPane hnd2Pane = new GridPane();
        hnd2Pane.setHgap(20);
        hnd2Pane.setStyle("-fx-background-color:red;-fx-padding:10px;");
        hnd2Pane.add(handViewP2, 0, 0);
        hnd2Pane.add(hnd2CloseBtn, 0, 1);
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
     */
    public void launchP1Field(GridPane grid){
        
        GridPane gridP1 = new GridPane();
        gridP1.setHgap(15);
        gridP1.setVgap(10);
        gridP1.setPadding(new Insets(25, 25, 25, 25));

        lbP1 = new Label("Jogador 1");
        gridP1.add(lbP1, 2, 1);

        
        CardDeck deck1 = new CardDeck(1);

        fieldCardP1 = new FieldCardView(1);
        gridP1.add(fieldCardP1, 2, 0);

        ImageView deck1View = ImageFactory.getInstance().createImage("imgBck");
        deck1View.setFitHeight(200);
        deck1View.setPreserveRatio(true);
        gridP1.add(deck1View, 3, 0);

        PokemonCard pc = fieldCardP1.getFieldCard().getCard();
        infoPokemon1 = new Label(
            pc.getNome() + "    HP: " + pc.getCurrentHP()
        );
        gridP1.add(infoPokemon1, 1, 0);

        infoDeck1 = new Label(
            "Deck: " + deck1.getNCards()
        );
        gridP1.add(infoDeck1, 4, 0);

        launchP1Hand(gridP1, 1, 1);

        // GridPane lifeBar = new GridPane();
        // lifeBar.setHgap(5);
        // ImageView c1 = ImageFactory.getInstance().createImage("fullheart");
        // ImageView c2 = ImageFactory.getInstance().createImage("fullheart");
        // ImageView c3 = ImageFactory.getInstance().createImage("fullheart");
        // c1.setFitHeight(20);
        // c1.setFitWidth(20);
        // c2.setFitHeight(20);
        // c2.setFitWidth(20);
        // c3.setFitHeight(20);
        // c3.setFitWidth(20);
        // lifeBar.add(c1, 0, 0);
        // lifeBar.add(c2, 1, 0);
        // lifeBar.add(c3, 2, 0);
        // gridP1.add(lifeBar, 3, 1);


        LifeView life = new LifeView(1,25);
        gridP1.add(life, 3, 1);            
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
        gridP2.add(fieldCardP2, 2, 1);

        ImageView deck2View = ImageFactory.getInstance().createImage("imgBck");
        deck2View.setFitHeight(200);
        deck2View.setFitWidth(150);
        gridP2.add(deck2View, 1, 1);

        PokemonCard pc = fieldCardP2.getFieldCard().getCard();
        infoPokemon2 = new Label(
            pc.getNome() + "    HP: " + pc.getCurrentHP()
        );
        gridP2.add(infoPokemon2, 3, 1);

        infoDeck2 = new Label(
            "Deck: " + Game.getInstance().getDeckP2().getNCards()
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
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateLabels();
            }
        });
        gridTopCmd.add(resetBtn, 2, 0);

        Button exitBtn = new Button("Sair");
        exitBtn.setOnAction(e -> {
            hnd1Stage.close();
            hnd2Stage.close();
            confirmNameStage.close();
            primaryStage.close();
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
        launchTopCommands(grid, primaryStage);
      
        
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show();

        launchNameWindow();
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
                    cancel.setOnAction(e -> pOpStage.close());
                    pOpPane.add(cancel, 0, 3);

                    Scene pOpScene = new Scene(pOpPane);
                    pOpStage = new Stage();
                    pOpStage.setScene(pOpScene);
                    pOpStage.setTitle("Options");
                    pOpStage.show();

            }


        }

    }

    public void updateLabels() {
        PokemonCard pc1 = fieldCardP1.getFieldCard().getCard();
        PokemonCard pc2 = fieldCardP2.getFieldCard().getCard();

        infoPokemon1.setText(pc1.getNome() + "    HP: " + pc1.getCurrentHP());;
        infoPokemon2.setText(pc2.getNome() + "    HP: " + pc2.getCurrentHP());
        infoDeck1.setText("Deck: " + Game.getInstance().getDeckP1().getNCards());
        infoDeck2.setText("Deck: " + Game.getInstance().getDeckP2().getNCards());        
        lbP1.setText(jogador1Nome);
        lbP2.setText(jogador2Nome);

        if (Game.getInstance().getPlayer() == 1) {
            playerTurn.setText("Vez de " + jogador1Nome);
        } else {
            playerTurn.setText("Vez de " + jogador2Nome);
        }
    }

    public static void main(String args[]){
        launch(args);
    }
}