package tetris.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import tetris.Constants;
import tetris.domain.Score;
import tetris.logic.Highscores;

public class HighscoresView {
    
    private Highscores highscores;
    private BorderPane parent;

    private VBox highScoresView;
    private TableView highscoresTable;
    private Button buttonBackToMenu;
    
    public HighscoresView(BorderPane parent, Highscores highscores) {
        this.parent = parent;
        this.highscores = highscores;
        
        highScoresView = new VBox();
        highScoresView.setPadding(new Insets(15, 20, 15, 20));
        highScoresView.setSpacing(10);
        highScoresView.setAlignment(Pos.CENTER);
        
        highscoresTable = new TableView();
        highscoresTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        TableColumn<String, Score> column1 = new TableColumn("Player");
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<String, Score> column2 = new TableColumn<>("Score");
        column2.setCellValueFactory(new PropertyValueFactory<>("score"));
        
        highscoresTable.getColumns().add(column1);
        highscoresTable.getColumns().add(column2);
        
        highscoresTable.getItems().addAll(this.highscores.getAll());
        
        Label labelHighScores = new Label("High Scores");
        labelHighScores.setFont(Constants.DEFAULT_FONT_BOLD);
        
        buttonBackToMenu = new Button("Back to menu");
        
        highScoresView.getChildren().addAll(labelHighScores, highscoresTable, buttonBackToMenu);
    }
    
    public Parent getScene() {
        return highScoresView;
    }
    
    public void registerHandlerForButtonBackToMenu(Parent mainMenu) {
        this.buttonBackToMenu.setOnAction(event -> {
            this.parent.setCenter(mainMenu);
        });
    }
}
