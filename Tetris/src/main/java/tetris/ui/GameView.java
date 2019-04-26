package tetris.ui;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PopupControl;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import tetris.Constants;
import tetris.domain.User;
import tetris.logic.Game;
import tetris.logic.Highscores;

public class GameView {

    private Game gameStatus;
    private BorderPane parent;
    private Highscores highscores;
    private User user;
    
    private int height = Constants.BOARD_DEFAULT_HEIGHT;
    private int width = Constants.BOARD_DEFAULT_WIDTH;
    private int rectangleSize = Constants.RECTANGLE_DEFAULT_SIZE;
    
    private Color[] colors;
    
    private Rectangle[][] rectangleboard;
    private Rectangle[][] rectangleNextPiece;
    
    //Scene gameScene;
    private BorderPane view;
    private GridPane gameRectangle;
    private GridPane nextPieceRectangle;
    private VBox gameViewMenu;
    
    private Label labelRowsCleared;
    private Label labelCurrentScoreShow;
    private Label labelHighScoreShow;
    private Label labelPlayerNameShow;
    private Label labelPauseGame;
    private Label labelBackToMenu;
    
    private Label popupLabel;
    private PopupControl popup;
    
    //TEMP
    Media music;
    MediaPlayer sfxbgMusic;
    public void setVolume(double vol) {
        sfxbgMusic.setVolume(vol);
    }
    //TEMP
    
    public GameView(BorderPane parent, Game gameStatus, Highscores highscores, User user) {
        //TEMP, move to own class
        this.music = new Media(
                Constants.FILE_BG_MUSIC.toURI().toString());
        this.sfxbgMusic  = new MediaPlayer(music);
        sfxbgMusic.setCycleCount(Integer.MAX_VALUE);
        
        sfxbgMusic.setVolume(0.15);
        sfxbgMusic.play();
        //TEMP

        this.parent = parent;
        this.gameStatus = gameStatus;
        this.highscores = highscores;
        this.user = user;
        
        this.rectangleboard = new Rectangle[height][width];
        this.rectangleNextPiece = new Rectangle[4][4];
        
        this.colors = Constants.GAME_DEFAULT_COLORS;
        
        initializeRectangleBoards();
        initializeGameRectangle();
        initializeNextPieceRectangle();
        initializeGameViewMenu();
        initializeView();
        initializePopup();
    }
    
    public void updateView() {
        labelRowsCleared.setText(
                gameStatus.getStatistics().getClearedLinesAsString());
        labelCurrentScoreShow.setText(
                gameStatus.getStatistics().getTotalScoreAsString());
        labelHighScoreShow.setText(highscores.getHighScoreAsString());
        labelPlayerNameShow.setText(user.getName());
        
        if (gameStatus.getIsOver()) {
            showPopup("GAME OVER!");
        }
        
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
        
        for (int y = 0; y < 4; y++) {
            if (y >= nextPieceCoords.length) {
                for (int x = 0; x < 4; x++) {
                    rectangleNextPiece[y][x].setFill(Color.TRANSPARENT);
                }
                continue;
            }
            
            for (int x = 0; x < 4; x++) {
                if (x >= nextPieceCoords[y].length) {
                    for (; x < 4; x++) {
                        rectangleNextPiece[y][x].setFill(Color.TRANSPARENT);
                    }
                    continue;
                }
                
                if (nextPieceCoords[y][x] == 0) {
                    rectangleNextPiece[y][x].setFill(Color.TRANSPARENT);
                } else {
                    rectangleNextPiece[y][x].setFill(this.colors[nextPieceCoords[y][x]]);
                }
            }
        }
        
    }
    
    public Parent getScene() {
        return view;
    }
    
    public void registerHandlerForLabelBackToMenu(Parent menuScene) {
        this.labelBackToMenu.setOnMouseClicked(event -> {
            if (gameStatus.getIsActive()) {
                handlePauseGame();
            }
            this.parent.setCenter(menuScene);
        });
    }
    
    private void initializeRectangleBoards() {
        //CELLS FOR MAIN GAME RECTANGLE
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                rectangleboard[y][x] = new Rectangle();
                rectangleboard[y][x].setX(x * rectangleSize);
                rectangleboard[y][x].setY(y * rectangleSize);
                rectangleboard[y][x].setWidth(rectangleSize);
                rectangleboard[y][x].setHeight(rectangleSize);

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
        
        //CELLS FOR NEXT PIECE RECTANGLE
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                rectangleNextPiece[y][x] = new Rectangle();
                rectangleNextPiece[y][x].setX(x * rectangleSize);
                rectangleNextPiece[y][x].setY(y * rectangleSize);
                rectangleNextPiece[y][x].setWidth(rectangleSize);
                rectangleNextPiece[y][x].setHeight(rectangleSize);

                rectangleNextPiece[y][x].setFill(Color.TRANSPARENT);
                
                rectangleNextPiece[y][x].setStroke(Color.rgb(59, 83, 104));
                rectangleNextPiece[y][x].setStrokeType(StrokeType.INSIDE);
                rectangleNextPiece[y][x].setStrokeWidth(2);
            }
        }
    }
    
    private void initializeGameRectangle() {
        gameRectangle = new GridPane();
        styleGridPane(gameRectangle);
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                gameRectangle.add(rectangleboard[y][x], x, y);
            }
        }
    }
    
    private void initializeNextPieceRectangle() {
        nextPieceRectangle = new GridPane();
        styleGridPane(gameRectangle);
        
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                nextPieceRectangle.add(rectangleNextPiece[y][x], x, y);
            }
        }
    }
    
    private void initializeView() {
        view = new BorderPane();
        
        view.setCenter(gameRectangle);
        view.setRight(gameViewMenu);
    }
    
    private void initializePopup() {
        popupLabel = new Label("ERROR in app"); // error if this text is seen
        popupLabel.setFont(Font.font("Monospaced", FontWeight.BOLD, 64));
        popupLabel.setTextFill(Color.RED);
        popup = new PopupControl();
        popup.getScene().setRoot(popupLabel);
    }
    
    private void initializeGameViewMenu() {
        gameViewMenu = new VBox(10);
        gameViewMenu.setAlignment(Pos.CENTER);
        
        Label labelNextPiece = new Label("Next:");
        styleLabelHeading(labelNextPiece, false);
        
        Label labelLevel = new Label("Level");
        styleLabelHeading(labelLevel, false);
        
        labelRowsCleared = new Label("0");
        styleLabelShowInfo(labelRowsCleared);
        
        Label labelCurrentScore = new Label("Score");
        styleLabelHeading(labelCurrentScore, false);
        
        labelCurrentScoreShow = new Label("0");
        styleLabelShowInfo(labelCurrentScoreShow);
        
        Label labelHighScore = new Label("High Score");
        styleLabelHeading(labelHighScore, false);
        
        labelHighScoreShow = new Label(this.highscores.getHighScoreAsString());
        styleLabelShowInfo(labelHighScoreShow);
        
        Label labelPlayerName = new Label("Player");
        styleLabelHeading(labelPlayerName, false);
        
        labelPlayerNameShow = new Label(user.getName());
        styleLabelShowInfo(labelPlayerNameShow);
        
        Label labelStartNewGame = new Label("Start new\n  game");
        styleLabelHeading(labelStartNewGame, true);
        labelStartNewGame.setOnMouseClicked(event -> {
            if (popup.isShowing()) {
                popup.hide();
            }
            gameStatus.startGame();
        });
        
        labelPauseGame = new Label("PAUSE game");
        styleLabelHeading(labelPauseGame, true);
        labelPauseGame.setOnMouseClicked(event -> handlePauseGame());
        
        labelBackToMenu = new Label("Main Menu");
        styleLabelHeading(labelBackToMenu, true);
        
        gameViewMenu.getChildren().addAll(
                labelNextPiece,
                nextPieceRectangle,
                labelLevel,
                labelRowsCleared,
                labelCurrentScore,
                labelCurrentScoreShow,
                labelHighScore,
                labelHighScoreShow,
                labelPlayerName,
                labelPlayerNameShow,
                labelStartNewGame,
                labelPauseGame,
                labelBackToMenu);
    }
    
    private void styleGridPane(GridPane rectangle) {
        rectangle.setStyle("-fx-grid-lines-visible: true;");
        rectangle.setCursor(Cursor.NONE);
    }
    
    private void handlePauseGame() {
        if (!gameStatus.pauseGame()) {
            return;
        }
        if (gameStatus.getIsActive()) {
            labelPauseGame.setText("PAUSE game");
            if (popup.isShowing()) {
                popup.hide();
            }
        } else {
            labelPauseGame.setText("CONTINUE\n  game");
            showPopup("PAUSED");
        }
    }
    
    private void showPopup(String text) {
        if (!popup.isShowing()) {
            popupLabel.setText(text);
            popup.show(gameRectangle.getScene().getWindow());
        }
    }
    
    private void styleLabelHeading(Label l, boolean setBoldFont) {
        if (setBoldFont) {
            l.setFont(Font.font("Monospaced", FontWeight.BOLD, 20));
        } else {
            l.setFont(Font.font("Monospaced", 20));
        }
    }
    
    private void styleLabelShowInfo(Label l) {
        l.setFont(Font.font("Monospaced", FontWeight.MEDIUM, 24));
    }
    
}
