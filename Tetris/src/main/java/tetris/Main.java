package tetris;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage window) {
        BorderPane asettelu = new BorderPane();

        VBox menu = new VBox();
        menu.setSpacing(10);
        menu.setPadding(new Insets(15, 20, 15, 20));
        menu.setAlignment(Pos.CENTER);
        
        Label labelStart = new Label("Play");
        Label labelSetName = new Label("Set name");
        Label labelHighSco = new Label("High Scores");
        
        labelStart.setFont(Font.font("Monospaced", 32));
        labelStart.setTextAlignment(TextAlignment.CENTER);
        labelSetName.setFont(Font.font("Monospaced", 32));
        labelSetName.setTextAlignment(TextAlignment.CENTER);
        labelHighSco.setFont(Font.font("Monospaced", 32));
        labelHighSco.setTextAlignment(TextAlignment.CENTER);
        
        Button buttonQuit = new Button("Quit");
        buttonQuit.setFont(Font.font("Monospaced", 32));
        buttonQuit.setOnAction((event) -> {
            System.out.println("Now we will quit");
        });
        
        menu.getChildren().addAll(labelStart, labelSetName, labelHighSco, buttonQuit);
        
        asettelu.setCenter(menu);
        
        Scene nakyma = new Scene(asettelu);
        
        window.setScene(nakyma);
        window.setTitle("TETRIS beta v0.01");
        window.show();
    }
    
    public static void main(String[] args) {
        launch(Main.class);
    }
}
