package poo;

import java.util.Observable;
import java.util.Observer;
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
    private Button hnd1Btn, hnd2Btn, hnd1CloseBtn, hnd2CloseBtn;
    private Stage hnd1Stage, hnd2Stage;
    private Scene fieldScene, hnd1Scene, hnd2Scene;
    private FlowPane hnd1Pane, hnd2Pane;
    private Label lbP1, lbP2, infoPokemon1, infoPokemon2, infoDeck1, infoDeck2;

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
     * O ultimo bloco cria o Label com as informacoes do pokemon e do deck
     *  **SEPARAR INFORMACOES DO DECK DO POKEMON**
     * 
     * COISA A SEREM ADICIONADAS:
     * - Vidas do jogador em coracoes
     * 
     */
    public void launchP1Field(GridPane grid){
        
        lbP1 = new Label("Jogador 1 (Vidas: 2)");
        grid.add(lbP1, 2, 4);

        CardDeck deck1 = new CardDeck(1);
        ImageView dck1CardView = ImageFactory.getInstance().createImage(deck1.draw().getImageId());
        dck1CardView.setFitHeight(250);
        dck1CardView.setFitWidth(188);
        grid.add(dck1CardView, 2, 3);

        ImageView deck1View = ImageFactory.getInstance().createImage("imgBck");
        deck1View.setFitHeight(200);
        deck1View.setFitWidth(150);
        grid.add(deck1View, 3, 3);

        infoPokemon1 = new Label(
            "*Nome Pokemon*    HP: 40\n\nEnergias(3):\nFogo: 1\nGrama: 2\n\nStatus:\nEnvenenado\nQueimado\nParalizado"
        );
        grid.add(infoPokemon1, 1, 3);

        infoDeck1 = new Label(
            "Deck: 14\n\nPilha de Descarte(11):\nPokemon: 5\nTreinador: 1\nEnergia: 5"
        );
        grid.add(infoDeck1, 4, 3);

        launchP1Hand(grid, 1, 4);
    }

    public void launchP2Field(GridPane grid){

        this.lbP2 = new Label("Jogador 2 (Vidas: 3)");
        grid.add(lbP2, 2, 1);
        CardDeck deck2 = new CardDeck(2);
        ImageView dck2CardView = ImageFactory.getInstance().createImage(deck2.draw().getImageId());
        dck2CardView.setFitHeight(250); // Ajusta altura da imagem
        dck2CardView.setFitWidth(188); // Ajusta largura da imagem
        grid.add(dck2CardView, 2, 2);

        ImageView deck2View = ImageFactory.getInstance().createImage("imgBck");
        deck2View.setFitHeight(200);
        deck2View.setFitWidth(150);
        grid.add(deck2View, 1, 2);

        infoPokemon2 = new Label(
            "*Nome Pokemon*    HP: 50\n\nEnergias(4):\nFogo: 3\nGrama: 1\n\nStatus:\nEnvenenado\nParalizado"
        );
        grid.add(infoPokemon2, 3, 2);

        infoDeck2 = new Label(
            "Deck: 22\n\nPilha de Descarte(5):\nPokemon: 1\nTreinador: 1\nEnergia: 3"
        );
        grid.add(infoDeck2, 0, 2);

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

        launchP1Field(grid);
        launchP2Field(grid);

        launchP2Hand(grid);
      
        Button resetBtn = new Button();
        resetBtn.setText("Reiniciar");
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateLabels();
            }
        });
        grid.add(resetBtn,2,0);

        // Lanca primaryStage
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show(); 
    }
    
    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub

    }

    public void updateLabels(){
        infoPokemon1.setText("*Nome Pokemon*    HP: 60\n\nEnergias(0):\n\n\n\nStatus:");
        infoPokemon2.setText("*Nome Pokemon*    HP: 60\n\nEnergias(0):\n\n\n\nStatus:");
        infoDeck1.setText("Deck: 30\n\nPilha de Descarte(0):");
        infoDeck2.setText("Deck: 30\n\nPilha de Descarte(0):");
        lbP1.setText("Jogador 1 (Vidas: 4)");
        lbP2.setText("Jogador 1 (Vidas: 4)");
    }

    public static void main(String args[]){
        launch(args);
    }
    
    

}