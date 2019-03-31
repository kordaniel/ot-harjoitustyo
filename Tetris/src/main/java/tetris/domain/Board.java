package tetris.domain;

import java.util.Arrays;

public class Board {

    private int height;
    private int width;
    private final int[][] board;

    public Board(int height, int width) {
        this.width = width;
        this.height = height;

        this.board = new int[height][width];

    /*
    //SET INITIAL PIECES FOR TESTING PURPOSES
    for (int i = 0; i < this.width; i++) {
      this.board[i][i] = 1;
      this.board[i][this.width-1-i] = 2;
    }
    for (int x = 0; x < this.width; x++) {
      this.board[4][x] = 3;
    }
    */
    }
    
    /*
    public void resetBoard() {
        this.board = new int[this.height][this.width];
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

    public void clearRows() {
        for (int y = this.height - 1; y >= 0; y--) {
            for (int x = 0; x < this.width; x++) {
                if (this.board[y][x] == 0) {
                    break;
                } else if (x == this.width - 1) {
                    clearRow(y);
                }
            }
        }
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
                if (this.board[y][x] != 0) {
                    sb.append(this.board[y][x]);
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
