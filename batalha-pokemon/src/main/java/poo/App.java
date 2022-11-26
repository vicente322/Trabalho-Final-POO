package poo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * App da Batalha de Pokemon
 * 
 * @author vicente322
 * 
 * @version 2022-11-25
 */

public class App extends Application{
    private Button hnd1Btn, hnd1CloseBtn;
    private Stage hnd1Stage;
    private Scene fieldScene, hnd1Scene;
    private FlowPane hnd1Pane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX - Batalha Pokemon");

        //Cria Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Cria Card Aron e sua imagem
        Card aron = new Card("Aron", "aron-card", "aron");
        ImageView aronImg = ImageFactory.getInstance().createImage(aron.getImageId());
        aronImg.setFitHeight(200); //Ajusta altura da imagem
        aronImg.setFitWidth(150); //Ajusta largura da imagem
        grid.add(aronImg, 0, 0);

        // Cria Card Eevee e sua imagem
        Card eevee = new Card("Eevee", "eevee-card", "eevee");
        ImageView eeveeImg = ImageFactory.getInstance().createImage(eevee.getImageId());
        eeveeImg.setFitHeight(200);
        eeveeImg.setFitWidth(150);
        grid.add(eeveeImg, 0, 1);

        hnd1Btn = new Button("Mao do Jogador 1");
        hnd1Btn.setOnAction(e -> trataBtnHand1(e));
        grid.add(hnd1Btn, 0, 2);

        hnd1CloseBtn = new Button("Fechar");
        hnd1CloseBtn.setOnAction(e -> trataBtnCloseHand1(e));

        hnd1Pane = new FlowPane();
        hnd1Pane.setHgap(20);
        hnd1Pane.setStyle("-fx-background-color:tan;-fx-padding:10px;");
        hnd1Pane.getChildren().add(hnd1CloseBtn);

        hnd1Scene = new Scene(hnd1Pane);
        hnd1Stage = new Stage();
        hnd1Stage.setScene(hnd1Scene);
        hnd1Stage.setTitle("Player 1 Hand");

        // Lanca primaryStage
        fieldScene = new Scene(grid);
        primaryStage.setScene(fieldScene);
        primaryStage.show(); 
    }

    public void trataBtnHand1(ActionEvent e){
        hnd1Stage.showAndWait();
    }

    public void trataBtnCloseHand1(ActionEvent e){
        hnd1Stage.close();
    }

    public static void main(String args[]){
        launch(args);
    }    

}