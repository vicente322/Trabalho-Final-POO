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
    private Label lbP1, lbP2, info1, info2;
    private String jogador1Nome,jogador2Nome;
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
     * Armazena sequencia que organiza a mao do jogador 1
     * @param e Evento do botao
     *          Ao ser pressionado, atualiza os nomes de P1 e P2 e fecha a janela.
     */

    public void trataBtnCloseConfirm(ActionEvent e) {
        jogador1Nome = jogador1.getText();
        jogador2Nome = jogador2.getText();
        lbP1.setText(jogador1Nome + " (Vidas: 4)");
        lbP2.setText(jogador2Nome + " (Vidas: 4)");
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
     * @param grid GridPane do Stage principal
     */
    public void launchP1Hand(GridPane grid){
        // Cria botao da mao do jogador 1
        hnd1Btn = new Button("Mao do Jogador 1");
        hnd1Btn.setOnAction(e -> trataBtnHand1(e));
        grid.add(hnd1Btn, 2, 3);
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
    public void launchP2Hand(GridPane grid){
        // Cria botao da mao do jogador 2
        hnd2Btn = new Button("Mao do Jogador 2");
        hnd2Btn.setOnAction(e -> trataBtnHand2(e));
        grid.add(hnd2Btn, 0, 0);
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
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX - Batalha Pokemon");
        jogador1Nome = "Jogador 1";
        jogador2Nome = "Jogador 2";

        //Cria Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Cria CardDeck e sua imagem
        this.lbP2 = new Label("Jogador 2 (Vidas: 3)");
        grid.add(lbP2, 1, 0);
        CardDeck deck2 = new CardDeck(2);
        ImageView dck2CardView = ImageFactory.getInstance().createImage(deck2.draw().getImageId());
        dck2CardView.setFitHeight(250); //Ajusta altura da imagem
        dck2CardView.setFitWidth(188); //Ajusta largura da imagem
        grid.add(dck2CardView, 1, 1);

        // Cria CardDeck e sua imagem
        this.lbP1 = new Label("Jogador 1 (Vidas: 2)");
        grid.add(lbP1, 1, 3);
        CardDeck deck1 = new CardDeck(1);
        ImageView dck1CardView = ImageFactory.getInstance().createImage(deck1.draw().getImageId());
        dck1CardView.setFitHeight(250);
        dck1CardView.setFitWidth(188);
        grid.add(dck1CardView, 1, 2);

        //Cria deck do jogador 1
        ImageView deck1View = ImageFactory.getInstance().createImage("imgBck");
        deck1View.setFitHeight(200);
        deck1View.setFitWidth(150);
        grid.add(deck1View, 2, 2);

        //Cria deck do jogador 2
        ImageView deck2View = ImageFactory.getInstance().createImage("imgBck");
        deck2View.setFitHeight(200);
        deck2View.setFitWidth(150);
        grid.add(deck2View, 0, 1);

        this.info1 = new Label("HP: 40      Baralho: 17\n\nEnergias(3):\nFogo: 1\nGrama: 2\n\nStatus:\nEnvenenado\nQueimado\nParalizado\n\nPilha de Descarte(11):\nPokemon: 5\nTreinador: 1\nEnergia: 5");
        grid.add(info1, 0, 2);

        this.info2 = new Label("HP: 50      Baralho: 18\n\nEnergias(3):\nAgua: 2\nMetal: 1\n\nStatus:\nEnvenenado\nQueimado\nDormindo\n\nPilha de Descarte(7):\nPokemon: 3\nTreinador: 1\nEnergia: 3");
        grid.add(info2, 2, 1);

        Button resetBtn = new Button();
        resetBtn.setText("Reiniciar");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateLabels();
            }
        });
        grid.add(resetBtn,2,0);

        launchP1Hand(grid); // Uso de metodos pra deixar a leitura do codigo mais facil
        launchP2Hand(grid);
        launchNameWindow();
        

        // Lanca primaryStage
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub

    }

    public void updateLabels()
    {
        info1.setText("HP: 20      Baralho: 16\n\nEnergias(4):\nFogo: 2\nGrama: 2\n\nStatus:\n\nQueimado\nParalizado\n\nPilha de Descarte(13):\nPokemon: 7\nTreinador: 1\nEnergia: 5");
        info2.setText("HP: 50      Baralho: 24\n\nEnergias(0):\n\n\n\nStatus:\n\n\n\n\nPilha de Descarte(0):\nPokemon: 0\nTreinador: 0\nEnergia: 0");
        lbP1.setText(jogador1Nome + " (Vidas: 4)");
        lbP2.setText(jogador2Nome + " (Vidas: 4)");
    }

    public static void main(String args[]){
        launch(args);
    }
    
    

}