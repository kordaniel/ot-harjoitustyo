package tetris.domain;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tetris.Constants;
import tetris.domain.piece.Piece;

public class Game {

    private Board board;
    
    private int height; 
    private int width;
    private int[][] boardInPlay;
    
    private Piece currentPiece;
    private Piece nextPiece;
    
    private boolean isActive;
    private Statistics gameStatistics;
    
    //TEMPORARILY IN THIS CLASS
    //all sounds downloaded from https://freesound.org
    Media sndFxTurn;
    Media sndFxClear;
    MediaPlayer mediaPlayerTurn;
    MediaPlayer mediaPlayerClear;
    
    public Game(int height, int width) {
        sndFxTurn = new Media(
                Constants.FILE_SNDFX_TURN_PIECE.toURI().toString());
        sndFxClear = new Media(
                Constants.FILE_SNDFX_CLEAR_ROWS.toURI().toString());
        mediaPlayerTurn = new MediaPlayer(this.sndFxTurn);
        mediaPlayerClear = new MediaPlayer(this.sndFxClear);
        //mediaPlayerTurn.setCycleCount(Integer.MAX_VALUE);
        //mediaPlayerClear.setCycleCount(Integer.MAX_VALUE);
        
        this.height = height;
        this.width = width;
        this.board = new Board(height, width);
        this.boardInPlay = this.board.getBoardCopy();
        this.isActive = false;
        this.gameStatistics = new Statistics();
    }
    
    public void startGame() {
        System.out.println("game starting");
        initializeGame();
        this.isActive = true;
    }
    
    public void stopGame() {
        System.out.println("game stopping");
        this.isActive = false;
    }
    
    public boolean getIsActive() {
        return this.isActive;
    }

    public void initializeGame() {
        this.setNewPiece();
        this.setNewPiece();
    }
    
    private void setNewPiece() {
        if (this.nextPiece != null
                && !this.board.pieceCanBeSpawned(nextPiece))
            System.out.println("game over MAAN");
        this.currentPiece = this.nextPiece;
        this.nextPiece = Piece.createNewRandomTetrisPiece(4);
        if (this.nextPiece == null) {
            throw new Error("PieceFactory returned null!!");
        }
    }
    
    public void rotatePiece() {
        if (this.currentPiece == null
                || !this.board.pieceCanBeRotated(this.currentPiece)) {
            return;
        }
        //plays only one time, how to reset player to beginning
        //mediaPlayerTurn.play();
        this.currentPiece.rotateRight();
    }
    
    public void moveRight() {
        if (this.currentPiece == null
                || !this.board.pieceCanMoveRight(this.currentPiece)) {
            return;
        }
        
        this.currentPiece.moveRight();
    }
    
    public void moveLeft() {
        if (this.currentPiece == null
                || !this.board.pieceCanMoveLeft(this.currentPiece)) {
            return;
        }
        
        this.currentPiece.moveLeft();
    }
    
    public void moveDown() {
        if (this.currentPiece == null
                || !this.board.pieceCanMoveDown(this.currentPiece)) {
            return;
        }
        
        this.currentPiece.moveDown();
    }
    
    public void dropPiece() {
        if (this.currentPiece == null) {
            return;
        }
        while (this.board.pieceCanMoveDown(this.currentPiece)) {
            this.currentPiece.moveDown();
        }
    }
    
    public void advanceGame() {
        if (this.currentPiece == null) {
            return;
        }
        
        if (this.board.pieceCanMoveDown(currentPiece)) {
            this.currentPiece.moveDown();
        } else {
            this.board.addPieceToBoard(this.currentPiece);
            int rowsCleared = this.board.dropRows();
            gameStatistics.incrementClearedLines(rowsCleared);
            System.out.println("total rows cleared: " + 
                    gameStatistics.getClearedLinesNum());
            
            //plays only one time...
//            if (rowsCleared >= 2) {
//                mediaPlayerClear.play();
//            }
            setNewPiece();
        }
        this.addPieceToBoardInPlay();
    }

    private void addPieceToBoardInPlay() {
        this.boardInPlay = this.board.getBoardCopy();
        int[][] pieceCoords = this.currentPiece.getCoords();
        int py = this.currentPiece.getY();
        int px = this.currentPiece.getX();
        int dim = this.currentPiece.getSize() - 1;
        
        for (int dy = 0; dy <= dim; dy++) {
            for (int dx = 0; dx <= dim; dx++) {
                if (pieceCoords[dy][dx] == 0) {
                    continue;
                }
                this.boardInPlay[py - dim + dy][px + dx] = pieceCoords[dy][dx];
            }
        }
    }
    
    public int[][] getBoardInPlay() {
        return this.boardInPlay;
    }
    
    public int[][] getNextPieceCoords() {
        return this.nextPiece.getCoords();
    }
    
    public Statistics getStatistics() {
        return this.gameStatistics;
    }
    
}
