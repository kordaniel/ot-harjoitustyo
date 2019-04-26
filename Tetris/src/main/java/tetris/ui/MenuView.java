package tetris.ui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import tetris.Constants;

public class MenuView {

    private BorderPane parent;
    
    private VBox menuView;
    private Label labelPlayGame;
    private Label labelSettings;
    private Label labelHighScores;
    
    public MenuView(BorderPane parent) {
        this.parent = parent;

        menuView = new VBox(10);
        menuView.setPadding(new Insets(15, 20, 15, 20));
        menuView.setAlignment(Pos.CENTER);

        labelPlayGame = new Label("Play");
        labelSettings = new Label("Settings");
        labelHighScores = new Label("High Scores");
        Label labelQuitApp = new Label("Quit");

        labelPlayGame.setFont(Constants.DEFAULT_FONT_BOLD);
        labelSettings.setFont(Constants.DEFAULT_FONT_BOLD);
        labelHighScores.setFont(Constants.DEFAULT_FONT_BOLD);
        labelQuitApp.setFont(Constants.DEFAULT_FONT);
        labelQuitApp.setOnMouseClicked(event -> {
            Platform.exit();
        });

        menuView.getChildren().addAll(
                labelPlayGame,
                labelSettings,
                labelHighScores,
                labelQuitApp);
    }

    public void registerHandlerForLabelPlay(Parent gameScene) {
        this.labelPlayGame.setOnMouseClicked(event -> {
            this.parent.setCenter(gameScene);
        });
    }

    public void registerHandlerForLabelSettings(Parent settingsScene) {
        this.labelSettings.setOnMouseClicked(event -> {
            this.parent.setCenter(settingsScene);
        });
    }

    public void registerHandlerForLabelHighScores(Parent highscoresScene) {
        this.labelHighScores.setOnMouseClicked(event -> {
            this.parent.setCenter(highscoresScene);
        });
    }

    public Parent getScene() {
        return menuView;
    }
}
