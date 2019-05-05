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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import tetris.Constants;
import tetris.domain.User;

public class SettingsView {
    
    private BorderPane parent;
    private User user;
    
    private GridPane settingsView;
    private Button buttonBackToMenu;
    private Slider sliderVolume;
    
    public SettingsView(BorderPane parent, User user) {
        this.parent = parent;
        this.user = user;
        
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
        
        TextField textFieldPlayerName = new TextField(this.user.getName());
        textFieldPlayerName.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                user.setName(textFieldPlayerName.getText());
            }
        });
        settingsView.add(textFieldPlayerName, 1, 1);
        
        Label labelInfo = new Label("Confirm new name\nwith pressing enter");
        settingsView.add(labelInfo, 2, 1);
        
        Label labelVolume = new Label("Music volume:");
        settingsView.add(labelVolume, 0, 2);
        
        sliderVolume = new Slider(0, 1, Constants.DEFAULT_BG_MUSIC_VOLUME);
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
    
    public void registerHandlerForVolumeSlider(AudioPlayer audioPlayer) {
        sliderVolume.valueProperty().addListener(
                (ObservableValue<? extends Number> observable,
                        Number oldValue, Number newValue) -> {
            audioPlayer.setBackgroundMusicVolume(newValue.doubleValue());
        });
    }
}
