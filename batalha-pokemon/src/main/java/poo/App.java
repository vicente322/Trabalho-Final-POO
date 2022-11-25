package poo;

import java.nio.file.Paths;

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

        //Cria Cards e suas imagens
        Card aron = new Card("Aron", "aron-card", "aron");
        ImageView aronImg = ImageFactory.getInstance().createImage(aron.getImageId());

        //Cria Scroll Pane 1 e bota a imagem do Card Aron dentro
        ScrollPane sd1 = new ScrollPane();
        sd1.setPrefSize(600, 400);
        sd1.setContent(aronImg);
        grid.add(sd1, 0, 0);

        // Lanca Stage
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }

    public static void main(String args[]){
        launch(args);
    }    

}