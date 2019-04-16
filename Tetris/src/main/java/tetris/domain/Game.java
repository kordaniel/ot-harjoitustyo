package tetris.domain;

import java.util.Random;
import tetris.domain.piece.PieceJ;
import tetris.domain.piece.PieceI;
import tetris.domain.piece.Piece;
import tetris.domain.piece.PieceT;
import tetris.domain.piece.PieceL;
import tetris.domain.piece.PieceO;
import tetris.domain.piece.PieceS;
import tetris.domain.piece.PieceZ;

public class Game {

    private Random rand;
    private Board board;
    
    private int height; 
    private int width;
    private int[][] boardInPlay;
    
    private Piece currentPiece;
    private Piece nextPiece;
    
    private boolean isActive;
    
    public Game(int height, int width) {
        this.rand = new Random();
        this.height = height;
        this.width = width;
        this.board = new Board(height, width);
        this.boardInPlay = this.board.getBoardCopy();
        this.isActive = false;
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
        int n = rand.nextInt(7);
        
        this.currentPiece = this.nextPiece;
        
        switch (n) {
            case 0:
                this.nextPiece = new PieceT(4);
                break;
            case 1:
                this.nextPiece = new PieceO(4);
                break;
            case 2:
                this.nextPiece = new PieceI(4);
                break;
            case 3:
                this.nextPiece = new PieceJ(4);
                break;
            case 4:
                this.nextPiece = new PieceL(4);
                break;
            case 5:
                this.nextPiece = new PieceZ(4);
                break;
            case 6:
                this.nextPiece = new PieceS(4);
                break;
            default:
                break;
        }
    }
    
    public void rotatePiece() {
        if (this.currentPiece == null
                || !this.board.pieceCanBeRotated(this.currentPiece)) {
            return;
        }
        
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
            this.board.dropRows();
            //this.board.dropRows();
            //while (this.board.clearRows()) {
            //    this.board.dropRows();
            //}
            setNewPiece();
        }
        this.addPieceToBoardInPlay();
    }

    private void addPieceToBoardInPlay() {
        this.boardInPlay = this.board.getBoardCopy();
        int[][] pieceCoords = this.currentPiece.getCoords();
        int py = this.currentPiece.getY();
        int px = this.currentPiece.getX();
        int dim = this.currentPiece.getSize();
        
        for (int dy = 0; dy < dim; dy++) {
            for (int dx = 0; dx < dim; dx++) {
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
    
}
