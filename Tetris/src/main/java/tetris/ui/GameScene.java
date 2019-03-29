package tetris.ui;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class GameScene {
    
    private BorderPane parent;
    
    public GameScene(BorderPane parent) {
        this.parent = parent;
    }
    
    public Parent getScene() {
        BorderPane asettelu = new BorderPane();
        
        Label text = new Label("HIENO PELI TÄSSÄ NÄIN");
        
        asettelu.setCenter(text);
        
        return asettelu;
    }
}
