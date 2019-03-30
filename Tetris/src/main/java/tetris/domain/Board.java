package tetris.domain;

public class Board {
  
  private int width;
  private int height;
  private int[][] board;

  public Board(int width, int height) {
    this.width = width;
    this.height = height;

    this.board =  new int[height][width];
    
    //SET INITIAL PIECES FOR TESTING PURPOSES
    for (int i = 0; i < this.width; i++) {
      this.board[i][i] = 1;
      this.board[i][this.width-1-i] = 2;
    }
    for (int x = 0; x < this.width; x++) {
      this.board[4][x] = 3;
    }
  }

  public void dropRows() {
    for (int y = this.height - 1; y >= 0; y--) {
      for (int x = 0; x < this.width; x++) {
        if (this.board[y][x] == 0) continue;
        int oli = this.board[y][x];
        this.board[y][x] = 0;
        this.dropCoordinate(x, y, oli);
        this.clearRows();
      }
    }
  }
  
  public void dropCoordinate(int x, int y, int pieceNum) {
    if (y + 1 == this.height || this.board[y + 1][x] != 0) {
      this.board[y][x] = pieceNum;
      return;
    }
    this.dropCoordinate(x, y + 1, pieceNum);
  }
  
  public void clearRows() {
    for (int y = this.height-1; y >= 0; y--) {
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
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("+");
    for (int i = 0; i < this.width; i++) sb.append("-");
    sb.append("+\n");
    
    for (int y = 0; y < this.height; y++) {
      sb.append("|");
      for (int x = 0; x < this.width; x++) {
        if (this.board[y][x] != 0) sb.append(this.board[y][x]);
        else sb.append(" ");
      }
      sb.append("|\n");
    }
    
    sb.append("+");
    for (int i = 0; i < this.width; i++) sb.append("-");
    sb.append("+");
    return sb.toString();
  }
  
}
