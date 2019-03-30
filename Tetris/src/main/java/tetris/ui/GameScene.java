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

public class GameScene {
    
    private BorderPane parent;
    private MenuScene menu;
    private int width = 10;
    private int height = 18;
    private int size = 25;
    
    private Rectangle[][] rectangleboard;
    
    public GameScene(BorderPane parent) {
        this.parent = parent;
        this.rectangleboard = new Rectangle[height][width];
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                rectangleboard[y][x] = new Rectangle();
                rectangleboard[y][x].setX(x * size);
                rectangleboard[y][x].setY(y * size);
                rectangleboard[y][x].setWidth(size);
                rectangleboard[y][x].setHeight(size);
                rectangleboard[y][x].setStroke(Color.TRANSPARENT);
                rectangleboard[y][x].setStrokeType(StrokeType.INSIDE);
                rectangleboard[y][x].setStrokeWidth(1);
            }
        }
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                    rectangleboard[y][x].setFill(Color.DARKCYAN);
                } else {
                    rectangleboard[y][x].setFill(Color.DARKKHAKI);
                }
            }
        }
        //TEST
        for (int i = 0; i < width; i++) {
            rectangleboard[i][i].setFill(Color.TRANSPARENT);
            rectangleboard[i][width - 1 - i].setFill(Color.TRANSPARENT);
        }
    }
    
    public void setMenu(MenuScene menu) {
        this.menu = menu;
    }
    
    public Parent getScene() {
        GridPane game = new GridPane();
        
        game.setStyle("-fx-background-color: cyan; -fx-grid-lines-visible: true;");
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                //game.add(new Label("" + x + "," + y), x, y);
                game.add(rectangleboard[y][x], x, y);
            }
        }
        
        //Label text = new Label("HIENO PELI TÄSSÄ NÄIN");
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
