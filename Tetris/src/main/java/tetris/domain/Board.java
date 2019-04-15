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
     * Creates an new empty tetris Board (2d integer array) with the
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
    
    public void dropRows() {
        do {            
            for (int y = this.height - 1; y >= 0; y--) {
                for (int x = 0; x < this.width; x++) {
                    if (this.board[y][x] == 0) {
                        continue;
                    }
                    int symbol = this.board[y][x];
                    this.board[y][x] = 0;
                    this.dropCoordinate(y, x, symbol);
                }
            }
        } while (this.clearRows());
    }

    public void dropCoordinate(int y, int x, int symbol) {
        if (y + 1 == this.height || this.board[y + 1][x] != 0) {
            this.board[y][x] = symbol;
            return;
        }
        this.dropCoordinate(y + 1, x, symbol);
    }

    public boolean clearRows() {
        boolean boardChanged = false;
        
        for (int y = this.height - 1; y >= 0; y--) {
            for (int x = 0; x < this.width; x++) {
                if (this.board[y][x] == 0) {
                    break;
                } else if (x == this.width - 1) {
                    clearRow(y);
                    boardChanged = true;
                }
            }
        }
        return boardChanged;
    }

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