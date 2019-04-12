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
    private int size = 25;

    private Rectangle[][] rectangleboard;
    private Rectangle[][] rectangleNextPiece;
    private Color[] colors;
    
    public GameScene(BorderPane parent, Game gameStatus) {
        this.gameStatus = gameStatus;

        this.parent = parent;
        this.rectangleboard = new Rectangle[height][width];
        this.rectangleNextPiece = new Rectangle[4][4];
        
        this.colors = new Color[] {
            Color.TEAL, Color.STEELBLUE, Color.SPRINGGREEN, Color.BLUEVIOLET,
            Color.BROWN, Color.CORAL, Color.BISQUE, Color.THISTLE, Color.WHITESMOKE };

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
        
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                rectangleNextPiece[y][x] = new Rectangle();
                rectangleNextPiece[y][x].setX(x * size);
                rectangleNextPiece[y][x].setY(y * size);
                rectangleNextPiece[y][x].setWidth(size);
                rectangleNextPiece[y][x].setHeight(size);

                
                rectangleNextPiece[y][x].setFill(Color.ANTIQUEWHITE);
                rectangleNextPiece[y][x].setStroke(Color.TRANSPARENT);
                rectangleNextPiece[y][x].setStrokeType(StrokeType.INSIDE);
                rectangleNextPiece[y][x].setStrokeWidth(1);
            }
        }
        
    }
    
    public void updateBoard() {
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int coord = this.gameStatus.getBoardInPlay()[y][x];
                if (coord != 0) {
                    rectangleboard[y][x].setFill(this.colors[coord]);
                    continue;
                } 

                if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                    rectangleboard[y][x].setFill(this.colors[0]);
                } else {
                    rectangleboard[y][x].setFill(this.colors[1]);
                }
            }
        }
        
        int[][] nextPieceCoords = this.gameStatus.getNextPieceCoords();
        if (nextPieceCoords == null) return;
        
        for (int y = 0; y < 4; y++) {
            if (y >= nextPieceCoords.length) {
                for (int x = 0; x < 4; x++) {
                    rectangleNextPiece[y][x].setFill(Color.ANTIQUEWHITE);
                }
                continue;
            }
            
            for (int x = 0; x < 4; x++) {
                if (x >= nextPieceCoords[y].length) {
                    for (; x < 4; x++) {
                        rectangleNextPiece[y][x].setFill(Color.ANTIQUEWHITE);
                    }
                    continue;
                }
                if (nextPieceCoords[y][x] == 0) {
                    rectangleNextPiece[y][x].setFill(Color.ANTIQUEWHITE);
                } else {
                    rectangleNextPiece[y][x].setFill(this.colors[nextPieceCoords[y][x]]);
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
        
        GridPane nextPiece = new GridPane();
        nextPiece.setStyle("-fx-grid-lines-visible: true;");
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                /*
                Rectangle r = new Rectangle();
                r.setX(x * size);
                r.setY(y * size);
                r.setWidth(size);
                r.setHeight(size);

                if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                    //switch cols for debugging
                    r.setFill(this.colors[1]);
                } else {
                    r.setFill(this.colors[0]);
                }

                r.setStroke(Color.TRANSPARENT);
                r.setStrokeType(StrokeType.INSIDE);
                r.setStrokeWidth(1);*/
                nextPiece.add(rectangleNextPiece[y][x], x, y);
            }
        }
        
        BorderPane border = new BorderPane();

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Next"));
        vbox.getChildren().add(nextPiece);
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
