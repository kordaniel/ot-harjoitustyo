package tetris.domain;

import tetris.domain.piece.Piece;

/**
 * Game domain class that represents the current state of the tetrisboard.
 * That is it has an int[][]-array that holds all the cells values. An value
 * of 0 represents an empty cell, and other values are symbols of different
 * tetris pieces.
 * @author DanielKor
 */
public class Board {

    private int height;
    private int width;
    private final int[][] board;

    /**
     * Constructor that allows the initializer to pass an 2d-array to be used as
     * the board. This constructor should only be called from within the tests.
     * @param boardArray - 2 dimensional int array that holds the symbols on the boards.
     * @param height - Height of the board.
     * @param width - Width of the board.
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
     * @param height - Height of the board.
     * @param width - Width of the board.
     */
    public Board(int height, int width) {
        this(new int[height][width], height, width);
    }
    
    /**
     * This method takes one parameter of the type Piece. It simply checks
     * if the piece can go to the current coords that the piece holds.
     * @param p - Piece.
     * @return - true if piece can go to it's current coords, false otherwise.
     */
    public boolean pieceCanBeSpawned(Piece p) {
        return pieceCanGoCoords(p.getPieceCoordinates(), p.getY(), p.getX());
    }
    
    /**
     * This method takes one parameter of the type Piece and checks if the
     * piece can be moved to the left on the board.
     * @param p - Piece, that will be tested.
     * @return - true, if the piece can go to the left, false otherwise.
     */
    public boolean pieceCanMoveLeft(Piece p) {
        return pieceCanGoCoords(p.getPieceCoordinates(), p.getY(), p.getX() - 1);
    }
    
    /**
     * This method takes one parameter of the type Piece and checks if the
     * piece can be moved to the right on the board.
     * @param p - Piece, that will be tested.
     * @return - true, if the piece can go to the right, false otherwise.
     */
    public boolean pieceCanMoveRight(Piece p) {
        return pieceCanGoCoords(p.getPieceCoordinates(), p.getY(), p.getX() + 1);
    }
    
    /**
     * This method takes one parameter of the type Piece and checks if the
     * piece can be moved down on the board.
     * @param p - Piece, that will be tested.
     * @return - true, if the piece can go down, false otherwise.
     */
    public boolean pieceCanMoveDown(Piece p) {
        return pieceCanGoCoords(p.getPieceCoordinates(), p.getY() + 1, p.getX());
    }
    
    /**
     * This method takes one parameter of the type Piece and checks if the
     * piece can be rotated at the current coordinates of the piece.
     * @param p - Piece, that will be tested.
     * @return - true, if the piece can be rotated, false otherwise.
     */
    public boolean pieceCanBeRotated(Piece p) {
        return pieceCanGoCoords(p.getCoordinatesForNextOrientation(), p.getY(), p.getX());
    }
    
    /**
     * Resets board status to empty board by filling all cells with
     * the int value of 0.
     */
    public void reset() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.board[y][x] = 0;
            }
        }
    }
    
    /**
     * Helper method, that takes an int[][] array and int coordinates y and x,
     * representing piece-coordinates. Checks if the piece can go to these
     * coordinates. That is all cells have the value of 0.
     * @param pieceCoords - int[][] array with the coordinates of the piece.
     * @param y - basecoordinate y.
     * @param x - basecoordinate x.
     * @return - true if all checked cells are empty, false otherwise
     */
    private  boolean pieceCanGoCoords(int[][] pieceCoords, int y, int x) {
        int pieceSize = pieceCoords.length - 1;
        
        for (int dy = 0; dy <= pieceSize; dy++) {
            for (int dx = 0; dx <= pieceSize; dx++) {
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
     * @return - total amount of rows cleared.
     */
    public int dropRows() {
        int clearedRows = 0;
        for (int y = this.height - 1; y >= 0; y--) {
            if (checkAndClearRow(y)) {
                clearedRows++;
                moveRowsAboveYDown(y);
                y++;
            }
        }
        return clearedRows;
    }
    
    /**
     * Move all coords above row y down exactly one row.
     * @param y - lowest row that will be altered.
     */
    private void moveRowsAboveYDown(int y) {
        for (; y > 0; y--) {
            for (int x = 0; x < this.width; x++) {
                this.board[y][x] = this.board[y - 1][x];
                this.board[y - 1][x] = 0;
            }
        }
        
    }
    
    /**
     * Checks row and if it is an full row clears it
     * @param y - row to be checked
     * @return - true if row is cleared, false otherwise
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
     * Clears one full row. IE set's all of row y:s x-coordinates to 0.
     * @param y - row to be cleared
     */
    public void clearRow(int y) {
        for (int x = 0; x < this.width; x++) {
            this.board[y][x] = 0;
        }
    }
    
    /**
     * Returns an (deep) copy of the current state of the board.
     * @return - int[][] copy of the board.
     */
    public int[][] getBoardCopy() {
        int[][] copy = new int[height][width];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                copy[y][x] = this.board[y][x];
            }
        }
        return copy;
    }
    
    /**
     * Checks if the piece can be added to the board with the current
     * coordinates of the piece. If yes, then adds the pieces symbols
     * to the current state of the board.
     * @param p - Piece class representing an tetris piece.
     */
    public void addPieceToBoard(Piece p) {
        int dim = p.getSize() - 1;
        int py = p.getY();
        int px = p.getX();
        int[][] pieceCoords = p.getPieceCoordinates();
        
        if (!pieceCanGoCoords(pieceCoords, py, px)) {
            return;
        }
        
        for (int dy = 0; dy <= dim; dy++) {
            for (int dx = 0; dx <= dim; dx++) {
                if (pieceCoords[dy][dx] == 0) {
                    continue;
                } 
                this.board[py - dim + dy][px + dx] = pieceCoords[dy][dx];
            }
        }
    }
    
}