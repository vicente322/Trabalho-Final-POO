package poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JavaFX - Batalha Pokemon");

        //Cria Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Tentativa de criar imagem para por no grid
        String bckFile = "file:///C:/Users/vicen/Documents/GitHub/Trabalho-Final-POO/batalha-pokemon/src/main/resources/imagens/Back.png";
        String aronFile = "file:///C:/Users/vicen/Documents/GitHub/Trabalho-Final-POO/batalha-pokemon/src/main/resources/imagens/Aron.png";
        Image bckImg = new Image(bckFile);
        ImageView bckImgV = new ImageView(bckImg);
        grid.add(bckImgV, 0, 0);
        Image aronImg = new Image(aronFile);
        ImageView aronImgV = new ImageView(aronImg);
        grid.add(aronImgV, 1, 0);

        // Lanca Stage
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    public static void main(String args[]){
        launch(args);
    }    

}