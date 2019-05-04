package tetris;

import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tetris.dao.Dao;
import tetris.dao.ScoreDao;
import tetris.database.Database;
import tetris.domain.User;
import tetris.logic.Game;
import tetris.logic.Highscores;
import tetris.ui.GameView;
import tetris.ui.HighscoresView;
import tetris.ui.MenuView;
import tetris.ui.SettingsView;

public class Main extends Application {
    
    //maybe make some of these static and use them in other views?
    Dao scoreDao;
    Highscores highscores;
    User user;
    
    Game gameStatus;
    
    Scene root;

    BorderPane main;
    MenuView menuView;
    GameView gameView;
    SettingsView settingsView;
    HighscoresView highscoresView;
    
    private void createRootScene() {
        main = new BorderPane();
        main.setStyle("-fx-background-color: rgb(210, 192, 174);");
        main.setPadding(new Insets(7, 7, 7, 7));
        
        root = new Scene(main);
        
        root.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                gameStatus.moveLeft();
            }
            if (event.getCode() == KeyCode.RIGHT) {
                gameStatus.moveRight();
            }
            if (event.getCode() == KeyCode.UP) {
                gameStatus.rotatePiece();
            }
            if (event.getCode() == KeyCode.DOWN) {
                gameStatus.moveDown();
            }
            if (event.getCode() == KeyCode.SPACE) {   
                gameStatus.dropPiece();
            }
        });
    }
    
    private void createMenuScene() {
        menuView = new MenuView(main);
    }
    
    private void createGameScene() {
        gameView = new GameView(main, gameStatus, highscores, user);
    }
    
    private void createSettingsScene() {
        settingsView = new SettingsView(main, user);
    }
    
    private void createHighscoresScene() {
        highscoresView = new HighscoresView(main, highscores);
    }
    
    @Override
    public void init() {
        Database db = new Database(Constants.DATABASE_URI);
        scoreDao = new ScoreDao(db, Constants.HIGHSCORE_TABLE_NAME);
        
        user = new User();
        
        highscores = new Highscores(scoreDao.findAll());
        
        gameStatus = new Game(Constants.BOARD_DEFAULT_HEIGHT,
                Constants.BOARD_DEFAULT_WIDTH, user, highscores);
        
        createRootScene();
        createMenuScene();
        createGameScene();
        createSettingsScene();
        createHighscoresScene();
        
        menuView.registerHandlerForLabelPlay(gameView.getScene());
        menuView.registerHandlerForLabelSettings(settingsView.getScene());
        menuView.registerHandlerForLabelHighScores(highscoresView.getScene());
        
        settingsView.registerHandlerForButtonBackToMenu(menuView.getScene());
        settingsView.registerHandlerForVolumeSlider(gameView);
        
        gameView.registerHandlerForLabelBackToMenu(menuView.getScene());
        
        highscoresView.registerHandlerForButtonBackToMenu(menuView.getScene());
        
        main.setCenter(menuView.getScene());
    }
    
    @Override
    public void stop() {
        if (!gameStatus.getStatistics().getIsSaved()) {
            gameStatus.saveGameScore();
        }
        scoreDao.saveAll(highscores.getAll());
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setResizable(false);
        primaryStage.setWidth((Constants.BOARD_DEFAULT_WIDTH + 4) *
                Constants.RECTANGLE_DEFAULT_SIZE + 21);
        primaryStage.setHeight(Constants.BOARD_DEFAULT_HEIGHT *
                Constants.RECTANGLE_DEFAULT_SIZE + 36);
        
        
        primaryStage.setScene(root);
        
        primaryStage.setTitle("TETRIS beta v. " + Constants.VERSION);
        
        
        new AnimationTimer() {
            private final long sleepNanoSeconds = TimeUnit.SECONDS.toNanos(1L) / 60;
            private long prevNanoTime = System.nanoTime();
            
            private int ticks = 0;
            
            @Override
            public void handle(long currentNanoTime) {
                if (!gameStatus.getIsActive()
                        || currentNanoTime - prevNanoTime < sleepNanoSeconds) {
                    return;
                }
                
                if (ticks >= gameStatus.refreshesToWait()) {
                    gameStatus.advanceGame();
                    ticks = 0;
                }
                
                gameView.updateView();
                
                this.prevNanoTime = currentNanoTime;
                ticks++;
            }
        }.start();
        
        primaryStage.show();
        //primaryStage.setOnCloseRequest(e -> {
        //    //check if all done, daos etc
        //    if (false) {
        //        e.consume();
        //    }
        //});
        
    }
    
    public static void main(String[] args) {
        System.out.println();
        launch(args);
    }
}
