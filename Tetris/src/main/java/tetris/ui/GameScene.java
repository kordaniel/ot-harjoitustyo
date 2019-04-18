package tetris.ui;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import tetris.Constants;
import tetris.domain.Game;

public class GameScene {

    private Game gameStatus;

    private BorderPane parent;
    private MenuScene menu;
    
    
    private int width = 10;
    private int height = 18;
    private int size = 30;
    
    private Color[] colors;
    
    private Rectangle[][] rectangleboard;
    private Rectangle[][] rectangleNextPiece;
    private Label rowsCleared;
    
    //TEMP
    Media music;
    MediaPlayer sfxbgMusic;
    
    
    public GameScene(BorderPane parent, Game gameStatus) {
        this. music = new Media(
                Constants.FILE_BG_MUSIC.toURI().toString());
        this.sfxbgMusic  = new MediaPlayer(music);
        sfxbgMusic.setCycleCount(Integer.MAX_VALUE);
        sfxbgMusic.play();
        this.gameStatus = gameStatus;

        this.parent = parent;
        this.rectangleboard = new Rectangle[height][width];
        this.rectangleNextPiece = new Rectangle[4][4];
        
        this.colors = Constants.GAME_DEFAULT_COLORS;
        
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

                rectangleboard[y][x].setStroke(Color.rgb(59, 83, 104));
                rectangleboard[y][x].setStrokeType(StrokeType.INSIDE);
                rectangleboard[y][x].setStrokeWidth(2);
            }
        }
        
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                rectangleNextPiece[y][x] = new Rectangle();
                rectangleNextPiece[y][x].setX(x * size);
                rectangleNextPiece[y][x].setY(y * size);
                rectangleNextPiece[y][x].setWidth(size);
                rectangleNextPiece[y][x].setHeight(size);
                
                if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                    rectangleboard[y][x].setFill(this.colors[0]);
                } else {
                    rectangleboard[y][x].setFill(this.colors[1]);
                }
                
                rectangleNextPiece[y][x].setStroke(Color.rgb(59, 83, 104));
                rectangleNextPiece[y][x].setStrokeType(StrokeType.INSIDE);
                rectangleNextPiece[y][x].setStrokeWidth(2);
            }
        }
        
    }
    
    public void updateBoard() {
        rowsCleared.setText(
                gameStatus.getStatistics().getClearedLinesAsString());
        
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
                    if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                        rectangleNextPiece[y][x].setFill(this.colors[0]);
                    } else {
                        rectangleNextPiece[y][x].setFill(this.colors[1]);
                    }
                }
                continue;
            }
            
            for (int x = 0; x < 4; x++) {
                if (x >= nextPieceCoords[y].length) {
                    for (; x < 4; x++) {
                        if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                            rectangleNextPiece[y][x].setFill(this.colors[0]);
                        } else {
                            rectangleNextPiece[y][x].setFill(this.colors[1]);
                        }
                    }
                    continue;
                }
                if (nextPieceCoords[y][x] == 0) {
                    if ((y % 2 == 0 && x % 2 == 1) || (y % 2 == 1 && x % 2 == 0)) {
                        rectangleNextPiece[y][x].setFill(this.colors[0]);
                    } else {
                        rectangleNextPiece[y][x].setFill(this.colors[1]);
                    }
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
        
        game.setStyle("-fx-grid-lines-visible: true;");
        game.setCursor(Cursor.NONE);
        //game.setRotate(180);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                game.add(rectangleboard[y][x], x, y);
            }
        }

        
        Button btn = new Button("Back to menu");

        btn.setOnAction((event) -> {
            this.gameStatus.stopGame();
            this.parent.setCenter(this.menu.getScene());
        });
        
        GridPane nextPiece = new GridPane();
        nextPiece.setStyle("-fx-grid-lines-visible: true;");
        nextPiece.setCursor(Cursor.NONE);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                nextPiece.add(rectangleNextPiece[y][x], x, y);
            }
        }
        
        BorderPane border = new BorderPane();
        rowsCleared = new Label("0");
        VBox vbox = new VBox();
        vbox.getChildren().add(new Label("Next"));
        vbox.getChildren().add(nextPiece);
        vbox.getChildren().add(new Label("Level"));
        vbox.getChildren().add(rowsCleared);
        vbox.getChildren().add(new Label("Score"));
        vbox.getChildren().add(new Label("16"));
        vbox.getChildren().add(new Label("High Score"));
        vbox.getChildren().add(new Label("2342"));
        vbox.getChildren().add(new Label("Player"));
        vbox.getChildren().add(new Label("Marjo"));
        vbox.getChildren().add(btn);

        border.setCenter(game);
        border.setRight(vbox);

        gameStatus.startGame();
        return border;
    }
}
