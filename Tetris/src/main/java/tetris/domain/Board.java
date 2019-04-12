package tetris.domain;

import tetris.domain.piece.Piece;

public class Board {

    private int height;
    private int width;
    private final int[][] board;

    public Board(int height, int width) {
        this.width = width;
        this.height = height;

        this.board = new int[height][width];
    }
    
    public boolean pieceCanMoveLeft(Piece p) {
        return pieceCanGoCoords(p.getCoords(), p.getY(), p.getX() - 1);
        //return this.pieceCanGo(p, p.getY(), p.getX() - 1);
    }
    
    public boolean pieceCanMoveRight(Piece p) {
        return pieceCanGoCoords(p.getCoords(), p.getY(), p.getX() + 1);
        //return this.pieceCanGo(p, p.getY(), p.getX() + 1);
    }
    
    public boolean pieceCanMoveDown(Piece p) {
        return pieceCanGoCoords(p.getCoords(), p.getY() + 1, p.getX());
        //return this.pieceCanGo(p, p.getY() + 1, p.getX());
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
    /*
    private boolean pieceCanGo(Piece p, int y, int x) {
        int dim = p.getSize();
        
        int[][] pieceCoords = p.getCoords();
        
        for (int dy = 0; dy < dim; dy++) {
            for (int dx = 0; dx < dim; dx++) {
                if (pieceCoords[dy][dx] == 0) {
                    continue;
                }
                if (y - dim + dy < 0
                        || (x + dx < 0)
                        || (y - dim + dy >= this.height)
                        || (x + dx >= this.width)
                        || this.board[y - dim + dy][x + dx] != 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    */
    public void dropRows() {
        for (int y = this.height - 1; y >= 0; y--) {
            for (int x = 0; x < this.width; x++) {
                if (this.board[y][x] == 0) {
                    continue;
                }
                int symbol = this.board[y][x];
                this.board[y][x] = 0;
                this.dropCoordinate(x, y, symbol);
                this.clearRows();
            }
        }
    }

    public void dropCoordinate(int x, int y, int symbol) {
        if (y + 1 == this.height || this.board[y + 1][x] != 0) {
            this.board[y][x] = symbol;
            return;
        }
        this.dropCoordinate(x, y + 1, symbol);
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