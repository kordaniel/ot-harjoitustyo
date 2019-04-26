package tetris.ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import tetris.Constants;

public class SettingsView {
    
    private BorderPane parent;
    
    private GridPane settingsView;
    private Button buttonBackToMenu;
    private Slider sliderVolume;
    
    public SettingsView(BorderPane parent) {
        this.parent = parent;
        
        settingsView = new GridPane();
        settingsView.setAlignment(Pos.CENTER);
        settingsView.setHgap(10);
        settingsView.setVgap(10);
        settingsView.setPadding(new Insets(25));
        
        Text textTitle = new Text("Tetris settings");
        textTitle.setFont(Constants.DEFAULT_FONT_BOLD);
        settingsView.add(textTitle, 0, 0, 2, 1);
        
        Label labelPlayerName = new Label("Name:");
        settingsView.add(labelPlayerName, 0, 1);
        
        TextField textFieldPlayerName = new TextField();
        settingsView.add(textFieldPlayerName, 1, 1);
        
        Label labelVolume = new Label("Music volume:");
        settingsView.add(labelVolume, 0, 2);
        
        sliderVolume = new Slider(0, 1, 0.15);
        sliderVolume.setShowTickLabels(true);
        sliderVolume.setShowTickMarks(true);
        sliderVolume.setMajorTickUnit(0.5);
        sliderVolume.setMinorTickCount(5);
        sliderVolume.setBlockIncrement(0.02);
        settingsView.add(sliderVolume, 1, 2);
        
        buttonBackToMenu = new Button("Back to menu");
        settingsView.add(buttonBackToMenu, 1, 3, 1, 1);
        
    }
    
    public Parent getScene() {
        return settingsView;
    }
    
    public void registerHandlerForButtonBackToMenu(Parent mainMenu) {
        this.buttonBackToMenu.setOnAction(event -> {
            this.parent.setCenter(mainMenu);
        });
    }
    
    public void registerHandlerForVolumeSlider(GameView gameView) {
        sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                gameView.setVolume(newValue.doubleValue());
            }
        });
    }
}
