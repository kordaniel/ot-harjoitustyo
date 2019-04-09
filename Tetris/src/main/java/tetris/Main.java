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

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        Game gameStatus = new Game(18, 10);
        BorderPane main = new BorderPane();
        
        GameScene gameScene = new GameScene(main, gameStatus);
        MenuScene menu = new MenuScene(main, gameScene);
        gameScene.setMenu(menu);
        
        main.setCenter(menu.getScene());
        
        Scene scene = new Scene(main);
        /*
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
        
        
        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });
        
        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });
        */
        
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
        });
        stage.setScene(scene);
        stage.setTitle("TETRIS beta v0.01");
        
        gameStatus.setNewPiece();
        new AnimationTimer() {
            //10^9 ns = 1 sec =>
            //60 updates per second =>
            //one update per 16666667 ns
            private long sleepNanoSeconds = 16_666_667 / 2;
            private long prevNanoTime = System.nanoTime();
            private int refreshes = 0;
            
            @Override
            public void handle(long currentNanoTime) {
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
        
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
