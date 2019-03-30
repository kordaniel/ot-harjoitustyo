package tetris.domain;

import java.util.Arrays;

public abstract class Piece {
  
  private String type;
  private int orientation;
  
  private int maxOrientations;
  private int gridSize;
  protected int[][][] coords;

  public Piece(String name, int gridSize, int maxOrientations) {
    this.orientation = 0;
    
    this.type = name;
    this.maxOrientations = maxOrientations;
    this.gridSize = gridSize;
    this.coords = new int[maxOrientations][gridSize][gridSize];
  }
  
  public void rotateLeft() {
    if (this.orientation != 0) {
      this.orientation--;
    } else {
      this.orientation = this.maxOrientations - 1;
    }
  }
  
  public void rotateRight() {
    this.orientation = (this.orientation + 1) % this.maxOrientations;
  }

  public void print() {
    System.out.println("");
    System.out.println("Piece type: " + this.type);
    
    System.out.println("**********-- " + this.orientation + " --**********");
    for (int y = 0; y < this.coords[this.orientation].length; y++) {
      System.out.println(Arrays.toString(this.coords[this.orientation][y]));
    }
  }
}
