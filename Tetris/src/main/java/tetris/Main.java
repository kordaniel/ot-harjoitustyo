package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tetris.domain.Board;
import tetris.domain.Game;
import tetris.domain.Piece;
import tetris.domain.PieceI;
import tetris.domain.PieceT;
import tetris.ui.GameScene;
import tetris.ui.MenuScene;
import tetris.ui.TextUI;
import tetris.ui.Userinterface;

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
        
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT) {
                gameStatus.moveLeft();
            }
            if (event.getCode() == KeyCode.UP) {
                gameStatus.rotatePiece();
            }
            if (event.getCode() == KeyCode.RIGHT) {
                gameStatus.moveRight();
            }
            if (event.getCode() == KeyCode.DOWN) {
                System.out.println("ALAAAAAAS");
            }
        });
        
        
        stage.setScene(scene);
        stage.setTitle("TETRIS beta v0.01");
        
        gameStatus.addPiece();
        new AnimationTimer() {
            //10^9 ns = 1 sec =>
            //60 updates per second =>
            //one update per 16666667 ns
            private long sleepNanoSeconds = 16_666_667;
            private long prevNanoTime = System.nanoTime();
            private int refreshes = 0;
            
            @Override
            public void handle(long currentNanoTime) {
                if (currentNanoTime - prevNanoTime < sleepNanoSeconds) return;
                
                if (refreshes >= 20) {
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
        
        //Game game = new Game(18, 10);
        //Scanner scanner = new Scanner(System.in);
        
        //Userinterface ui = new TextUI(scanner, game);
        //ui.start();
        
    }
}
