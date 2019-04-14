package tetris.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SettingScene {
    
    private BorderPane parent;
    private MenuScene menu;
    
    public SettingScene(BorderPane parent) {
        this.parent = parent;
        //this.menu = menu;
    }
    
    public Parent getScene() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        
        Text scenetitle = new Text("Tetris settings");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        Label nickname = new Label("Nickname:");
        grid.add(nickname, 0, 1);
        
        TextField nicknameTextField = new TextField();
        grid.add(nicknameTextField, 1, 1);
        
        Button menuButton = new Button("Back to menu");
        menuButton.setOnAction((event) -> {
            this.parent.setCenter(grid);
        });
        
        return grid;
    }
}
