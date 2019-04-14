package tetris;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tetris.domain.Game;
import tetris.ui.GameScene;
import tetris.ui.MenuScene;
import tetris.ui.SettingScene;

public class Main extends Application {
    
    @Override
    public void init() {
        //suoritetaan ennen start():ia
        //create daos
        System.out.println("Tetris is starting... WELCOME!");
    }
    
    @Override
    public void stop() {
        System.out.println("Shutting down tetris!");
    }
    
    @Override
    public void start(Stage primaryStage) {
        Game gameStatus = new Game(18, 10);
        
        BorderPane main = new BorderPane();
        
        GameScene gameScene = new GameScene(main, gameStatus);
        SettingScene settingsScene = new SettingScene(main);
        MenuScene menu = new MenuScene(main, gameScene, settingsScene);
        gameScene.setMenu(menu);
        
        main.setCenter(menu.getScene());
        
        Scene scene = new Scene(main);
        
        scene.setOnKeyPressed(event -> {
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
            if (event.getCode() == KeyCode.X) {
                gameStatus.dropPiece();
            }
        });
        
        primaryStage.setWidth(14*32);
        primaryStage.setHeight(18*32);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TETRIS beta v0.09");
        
        
        new AnimationTimer() {
            //10^9 ns = 1 sec =>
            //60 updates per second =>
            //one update per 16666667 ns
            private long sleepNanoSeconds = 16_666_667 / 2;
            private long prevNanoTime = System.nanoTime();
            private int refreshes = 0;
            
            @Override
            public void handle(long currentNanoTime) {
                if (!gameStatus.getIsActive()) {
                    return;
                }
                
                if (currentNanoTime - prevNanoTime < sleepNanoSeconds) {
                    return;
                }
                
                if (refreshes >= 15) {
                    gameStatus.advanceGame();
                    refreshes = 0;
                }
                refreshes++;
                
                gameScene.updateBoard();
                this.prevNanoTime = currentNanoTime;
            }
        }.start();
        
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            //check if all done, daos etc
            if (false) {
                e.consume();
            }
        });
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
