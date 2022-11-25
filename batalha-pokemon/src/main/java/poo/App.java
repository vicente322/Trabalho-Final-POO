package poo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * App da Batalha de Pokemon
 * 
 * @author vicente322
 * 
 * @version 2022-11-24
 */

public class App extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Batalha Pokemon");
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Card aron = new Card("Aron", "aronTeste", "aron");
        CardView c1 = new CardView(aron);
        ScrollPane sd1 = new ScrollPane();
        sd1.setPrefSize(950, 250);
        sd1.setContent(c1);
        grid.add(sd1, 0, 0);

        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String args[]){
        launch(args);
    }

}