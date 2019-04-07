package tetris.domain;

import java.util.Random;

public class Game {

    private int height, width;
    private Board board;
    private int[][] boardInPlay;
    private Piece currentPiece;

    public Game(int height, int width) {
        this.height = height;
        this.width = width;
        this.board = new Board(height, width);
        this.boardInPlay = this.board.getBoardCopy();
    }

    public void addPiece() {
        Random r = new Random();
        int n = r.nextInt(2);
        if (n == 0) {
            this.currentPiece = new PieceI(4);
        } else if (n == 1) {
            this.currentPiece = new PieceT(4);
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
    
    public void advanceGame() {
        if (this.currentPiece == null) {
            return;
        }
        
        System.out.println("**************************");
        System.out.println("Piece set to y: " + this.currentPiece.getY());
        if (this.board.pieceCanMoveDown(currentPiece)) {
            this.currentPiece.moveDown();
        } else {
            this.board.addPieceToBoard(this.currentPiece);
            addPiece();
        }
        System.out.println("Piece set to y: " + this.currentPiece.getY());
        System.out.println("**************************");
        
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
        /*
        boolean whichOn = false;
        if (whichOn) {
            this.boardInPlay[3][2] = 2;
            this.boardInPlay[3][3] = 2;
            this.boardInPlay[3][4] = 2;
            this.boardInPlay[4][3] = 2;
            
            this.boardInPlay[14][7] = 0;
            this.boardInPlay[15][7] = 0;
            this.boardInPlay[16][7] = 0;
            this.boardInPlay[17][7] = 0;
        } else {
            this.boardInPlay[3][2] = 0;
            this.boardInPlay[3][3] = 0;
            this.boardInPlay[3][4] = 0;
            this.boardInPlay[4][3] = 0;
            
            
            this.boardInPlay[14][7] = 1;
            this.boardInPlay[15][7] = 1;
            this.boardInPlay[16][7] = 1;
            this.boardInPlay[17][7] = 1;
        }
        whichOn = !whichOn;
        */
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
