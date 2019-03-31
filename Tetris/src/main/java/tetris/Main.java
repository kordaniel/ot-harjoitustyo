package tetris;

import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
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

public class Main /*extends Application*/ {
    /*
    @Override
    public void start(Stage stage) {
        BorderPane main = new BorderPane();
        
        GameScene game = new GameScene(main);
        MenuScene menu = new MenuScene(main, game);
        game.setMenu(menu);
        
        main.setCenter(menu.getScene());
        
        Scene scene = new Scene(main);
        
        stage.setScene(scene);
        stage.setTitle("TETRIS beta v0.01");

        /* update
        new AnimationTimer() {
            //10^9 ns = 1 sec =>
            //60 updates per second =>
            //one update per 16666667 ns
            private long sleepNanoSeconds = 16666667;
            private long prevNanoTime = System.nanoTime();
            
            @Override
            public void handle(long currentNanoTime) {
                if (currentNanoTime - prevNanoTime < sleepNanoSeconds) return;
                
                if (labelSetName.textProperty().getValue().equals("Set name"))
                    labelSetName.setText("Name is set");
                else
                    labelSetName.setText("Set name");
                
                this.prevNanoTime = currentNanoTime;
            }
        }.start();
        *./
        stage.show();
    }*/
    
    public static void main(String[] args) {
        //launch(args);
        
        Scanner scanner = new Scanner(System.in);
        Userinterface ui = new TextUI(scanner);
        ui.start();



        //Board b = new Board(10,18);
        //System.out.println(b);
        //b.clearRows();
        
        //b.dropRows();
        
        //Game g = new Game(18, 10);
        //g.addPiece();
        
        
        
        /*
        Piece p = new PieceI(3);
        p.print();
        p.rotateLeft();
        p.print();
        p.rotateLeft();
        p.print();
        p.rotateLeft();
        p.print();
        p.rotateLeft();
        p.print();
        p.rotateLeft();
        p.print();
        p.rotateLeft();
        p.print();
        p.rotateLeft();
        p.print();
        System.out.println("****");
        System.out.println("****");
        p = new PieceI(3);
        p.print();
        p.rotateRight();
        p.print();
        p.rotateRight();
        p.print();
        p.rotateRight();
        p.print();
        p.rotateRight();
        p.print();
        p.rotateRight();
        p.print();
        p.rotateRight();
        p.print();
        p.rotateRight();
        p.print();
        */
    }
}
