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
    
    public Game(int height, int width) {
        this.rand = new Random();
        this.height = height;
        this.width = width;
        this.board = new Board(height, width);
        this.boardInPlay = this.board.getBoardCopy();
    }

    public void addPiece() {
        int n = rand.nextInt(7);
        int xCoord = this.width / 2;
        switch (n) {
            case 0:
                this.currentPiece = new PieceT(4);
                break;
            case 1:
                this.currentPiece = new PieceO(4);
                break;
            case 2:
                this.currentPiece = new PieceI(4);
                break;
            case 3:
                this.currentPiece = new PieceJ(4);
                break;
            case 4:
                this.currentPiece = new PieceL(4);
                break;
            case 5:
                this.currentPiece = new PieceZ(4);
                break;
            case 6:
                this.currentPiece = new PieceS(4);
                break;
            default:
                break;
        }
    }
    
    public void rotatePiece() {
        if (this.currentPiece == null) {
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
    
    public void advanceGame() {
        if (this.currentPiece == null) {
            return;
        }
        
        //System.out.println("**************************");
        //System.out.println("Piece set to y: " + this.currentPiece.getY());
        if (this.board.pieceCanMoveDown(currentPiece)) {
            this.currentPiece.moveDown();
        } else {
            this.board.addPieceToBoard(this.currentPiece);
            while (this.board.clearRows()) {
                this.board.dropRows();
            }
            addPiece();
        }
        //System.out.println("Piece set to y: " + this.currentPiece.getY());
        //System.out.println("**************************");
        
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+");
        for (int i = 0; i < this.width; i++) {
            sb.append("-");
        }
        sb.append("+\n");

        for (int y = 0; y < this.height; y++) {
            sb.append("|");
            for (int x = 0; x < this.width; x++) {
                if (this.boardInPlay[y][x] != 0) {
                    sb.append(this.boardInPlay[y][x]);
                } else {
                    sb.append(" ");
                }
            }
            sb.append("|\n");
        }

        sb.append("+");
        for (int i = 0; i < this.width; i++) {
            sb.append("-");
        }
        sb.append("+");
        return sb.toString();
    }
}
