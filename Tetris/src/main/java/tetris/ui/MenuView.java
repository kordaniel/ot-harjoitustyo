package tetris.ui;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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

    //TEMP TEST
    Slider sliderVol;
    
    public MenuView(BorderPane parent) {
        this.parent = parent;

        menuView = new VBox(10);
        menuView.setPadding(new Insets(15, 20, 15, 20));
        menuView.setAlignment(Pos.CENTER);

        labelPlayGame = new Label("Play");
        labelSettings = new Label("Set name");
        labelHighScores = new Label("High Scores");
        Label labelQuitApp = new Label("Quit");

        labelPlayGame.setFont(Constants.DEFAULT_FONT_BOLD);
        labelSettings.setFont(Constants.DEFAULT_FONT_BOLD);
        labelHighScores.setFont(Constants.DEFAULT_FONT_BOLD);
        labelQuitApp.setFont(Constants.DEFAULT_FONT);
        labelQuitApp.setOnMouseClicked(event -> {
            Platform.exit();
        });
        
        //MOVE TO SETTINGS, with handler
        sliderVol = new Slider(0, 1, 0.2);
        //sliderVol.setMin(0);
        //sliderVol.setMax(1);
        //sliderVol.setValue(1);
        sliderVol.setShowTickLabels(true);
        sliderVol.setShowTickMarks(true);
        sliderVol.setMajorTickUnit(0.5);
        sliderVol.setMinorTickCount(5);
        sliderVol.setBlockIncrement(0.02);
        
        menuView.getChildren().addAll(
                labelPlayGame,
                labelSettings,
                labelHighScores,
                sliderVol,
                labelQuitApp);
    }

    public void registerVolumeHandler(GameView gv) {
        sliderVol.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, 
                    Number oldValue, Number newValue) {
                gv.setVolume(newValue.doubleValue());
            }
        });
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

    public void registerHandlerForLabelHighScores(Parent highScoreScene) {
        this.labelHighScores.setOnMouseClicked((MouseEvent event) -> {
            System.out.println("ei ole tuloksia, ei missään näin");
        });
    }

    public Parent getScene() {
        return menuView;
    }
}
