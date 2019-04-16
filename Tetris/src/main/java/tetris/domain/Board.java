package tetris.domain;

import tetris.domain.piece.Piece;

public class Board {

    private int height;
    private int width;
    private final int[][] board;

    /**
     * Constructor that allows the initializer to pass an 2d-array to be used as
     * the board. This constructor should only be called from within the tests.
     * @param boardArray 2 dimensional int array that holds the symbols on the boards
     * @param height Height of the board
     * @param width  Width of the board
     */
    public Board(int[][] boardArray, int height, int width) {
        this.board = boardArray;
        this.height = height;
        this.width = width;
    }
    
    /**
     * This is the only constructor that should be used from within
     * the game logic.
     * Creates a new empty tetris Board (2d integer array) with the
     * size of the parameters passed to it.
     * @param height Height of the board
     * @param width Width of the board
     */
    public Board(int height, int width) {
        this(new int[height][width], height, width);
    }
    
    public boolean pieceCanMoveLeft(Piece p) {
        return pieceCanGoCoords(p.getCoords(), p.getY(), p.getX() - 1);
    }
    
    public boolean pieceCanMoveRight(Piece p) {
        return pieceCanGoCoords(p.getCoords(), p.getY(), p.getX() + 1);
    }
    
    public boolean pieceCanMoveDown(Piece p) {
        return pieceCanGoCoords(p.getCoords(), p.getY() + 1, p.getX());
    }
    
    public boolean pieceCanBeRotated(Piece p) {
        return pieceCanGoCoords(p.getCoordsForNextOrientation(), p.getY(), p.getX());
    }
    
    private  boolean pieceCanGoCoords(int[][] pieceCoords, int y, int x) {
        int pieceSize = pieceCoords.length;
        
        for (int dy = 0; dy < pieceSize; dy++) {
            for (int dx = 0; dx < pieceSize; dx++) {
                if (pieceCoords[dy][dx] == 0) {
                    continue;
                }
                if (y - pieceSize + dy < 0
                        || x + dx < 0
                        || y - pieceSize + dy >= this.height
                        || x + dx >= this.width) {
                    return false;
                }
                if (this.board[y - pieceSize + dy][x + dx] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Checks all rows starting from the bottom of the board for filled
     * rows. If the row is filled, clears it and moves all coordinates
     * above the row down exactly one row. That is blocks may be
     * left floating.
     * 
     */
    public void dropRows() {
        for (int y = this.height - 1; y >= 0; y--) {
            if (checkAndClearRow(y)) {
                moveRowsAboveYDown(y);
                y++;
            }
        }
    }
    
    /**
     * Move all coords above row y down exactly one row
     * @param y lowest row that will be altered
     */
    private void moveRowsAboveYDown(int y) {
        for (; y > 0; y--) {
            for (int x = 0; x < this.width; x++) {
                this.board[y][x] = this.board[y-1][x];
                this.board[y-1][x] = 0;
            }
        }
        
    }
    
    /**
     * Checks row and if it is an full row clears it
     * @param y row to be checked
     * @return true if row is cleared, false otherwise
     */
    private boolean checkAndClearRow(int y) {
        for (int x = 0; x < this.width; x++) {
            if (this.board[y][x] == 0) {
                return false;
            }
        }
        clearRow(y);
        return true;
    }

    /**
     * Clears one full row. IE set's all of row y:s x-coordinates to 0
     * @param y row to be cleared
     */
    public void clearRow(int y) {
        for (int x = 0; x < this.width; x++) {
            this.board[y][x] = 0;
        }
    }
    
    public int[][] getBoardCopy() {
        int[][] copy = new int[height][width];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                copy[y][x] = this.board[y][x];
            }
        }
        return copy;
    }
    
    public void addPieceToBoard(Piece p) {
        int dim = p.getSize();
        int py = p.getY();
        int px = p.getX();
        int[][] pieceCoords = p.getCoords();
        
        if (!pieceCanGoCoords(pieceCoords, py, px)) {
            return;
        }
        
        for (int dy = 0; dy < dim; dy++) {
            for (int dx = 0; dx < dim; dx++) {
                if (pieceCoords[dy][dx] == 0) {
                    continue;
                } 
                
                this.board[py - dim + dy][px + dx] = pieceCoords[dy][dx];
            }
        }
    }
    
}