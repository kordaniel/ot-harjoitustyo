package tetris.ui;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import tetris.domain.Game;

public class GameScene {

    private Game gameStatus;

    private BorderPane parent;
    private MenuScene menu;
    
    
    private int width = 10;
    private int height = 18;
    private int size = 15;

    private Rectangle[][] rectangleboard;
    private Color[] colors;
    
    public GameScene(BorderPane parent, Game gameStatus) {
        this.gameStatus = gameStatus;

        this.parent = parent;
        this.rectangleboard = new Rectangle[height][width];
        
        this.colors = new Color[] { Color.CYAN, Color.ROYALBLUE, 
            Color.SALMON, Color.TURQUOISE, Color.SPRINGGREEN, Color.BLUEVIOLET,
            Color.BROWN, Color.CORAL, Color.BISQUE };

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                rectangleboard[y][x] = new Rectangle();
                rectangleboard[y][x].setX(x * size);
                rectangleboard[y][x].setY(y * size);
                rectangleboard[y][x].setWidth(size);
                rectangleboard[y][x].setHeight(size);

                if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                    rectangleboard[y][x].setFill(this.colors[0]);
                } else {
                    rectangleboard[y][x].setFill(this.colors[1]);
                }

                rectangleboard[y][x].setStroke(Color.TRANSPARENT);
                rectangleboard[y][x].setStrokeType(StrokeType.INSIDE);
                rectangleboard[y][x].setStrokeWidth(1);
            }
        }
        
    }
    
    public void updateBoard() {        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (gameStatus.getBoardInPlay()[y][x] != 0) {
                    rectangleboard[y][x].setFill(this.colors[7]);
                    continue;
                } 

                if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                    rectangleboard[y][x].setFill(this.colors[0]);
                } else {
                    rectangleboard[y][x].setFill(this.colors[1]);
                }
            }
        }
    }
    

    public void setMenu(MenuScene menu) {
        this.menu = menu;
    }

    public Parent getScene() {
        GridPane game = new GridPane();
        //game.setStyle("-fx-background-color: cyan; -fx-grid-lines-visible: true;");
        game.setStyle("-fx-grid-lines-visible: true;");
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                    game.add(rectangleboard[y][x], x, y);
            }
        }

        
        Button btn = new Button("Back to menu");

        btn.setOnAction((event) -> {
            this.parent.setCenter(this.menu.getScene());
        });

        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Next"));
        vbox.getChildren().add(new Label("****"));
        vbox.getChildren().add(new Label("Level"));
        vbox.getChildren().add(new Label("4"));
        vbox.getChildren().add(new Label("Score"));
        vbox.getChildren().add(new Label("16"));
        vbox.getChildren().add(new Label("High Score"));
        vbox.getChildren().add(new Label("2342"));
        vbox.getChildren().add(new Label("Player"));
        vbox.getChildren().add(new Label("Marjo"));
        vbox.getChildren().add(btn);

        border.setCenter(game);
        border.setRight(vbox);

        return border;
    }
}
