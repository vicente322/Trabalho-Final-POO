package poo;

import javax.crypto.spec.DESKeySpec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * App da Batalha de Pokemon
 * 
 * @author vicente322
 * 
 * @version 2022-11-26
 */

public class App extends Application{
    private Button hnd1Btn, hnd2Btn, hnd1CloseBtn, hnd2CloseBtn;
    private Stage hnd1Stage, hnd2Stage;
    private Scene fieldScene, hnd1Scene, hnd2Scene;
    private FlowPane hnd1Pane, hnd2Pane;

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

        //Cria Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Cria CardDeck e sua imagem
        Label lbP2 = new Label("Jogador 2");
        grid.add(lbP2, 1, 0);
        CardDeck deck2 = new CardDeck(2);
        ImageView dck2CardView = ImageFactory.getInstance().createImage(deck2.draw().getImageId());
        dck2CardView.setFitHeight(250); //Ajusta altura da imagem
        dck2CardView.setFitWidth(188); //Ajusta largura da imagem
        grid.add(dck2CardView, 1, 1);

        // Cria CardDeck e sua imagem
        Label lbP1 = new Label("Jogador 1");
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

        launchP1Hand(grid); // Uso de metodos pra deixar a leitura do codigo mais facil
        launchP2Hand(grid);
        

        // Lanca primaryStage
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show(); 
    }

    public static void main(String args[]){
        launch(args);
    }    

}