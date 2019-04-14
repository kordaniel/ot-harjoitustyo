package tetris.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import tetris.domain.Game;

public class MenuScene {

    private BorderPane parent;
    private GameScene game;
    private SettingScene settings;
    
    public MenuScene(BorderPane parent, GameScene game, SettingScene settings) {
        this.parent = parent;
        this.game = game;
        this.settings = settings;
    }
    
    public Parent getScene() {
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
        
        Button btn = new Button("Game");
        btn.setFont(Font.font("Monospaced", 32));
        btn.setOnAction((event) -> {
            this.parent.setCenter(game.getScene());
        });
        
        Button settingsButton = new Button("Settings");
        settingsButton.setOnAction((event) -> {
            this.parent.setCenter(settings.getScene());
        });
        
        menu.getChildren().addAll(labelStart, labelSetName, labelHighSco, btn, settingsButton);
        
        asettelu.setCenter(menu);
        
        return asettelu;
    }
}
