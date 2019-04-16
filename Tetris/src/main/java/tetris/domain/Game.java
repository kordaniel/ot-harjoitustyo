package tetris.domain;

import tetris.domain.piece.Piece;

public class Game {

    private Board board;
    
    private int height; 
    private int width;
    private int[][] boardInPlay;
    
    private Piece currentPiece;
    private Piece nextPiece;
    
    private boolean isActive;
    
    public Game(int height, int width) {
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
    
}
