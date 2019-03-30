package tetris.domain;

import java.util.Arrays;

public abstract class Piece {
  
  private String type;
  private int orientation;
  
  private int maxOrientations;
  private int dimension;
  protected int[][][] coords;
  
  private int y;
  private int x;

  public Piece(String name, int dimension, int maxOrientations, int initialX) {
    this.orientation = 0;
    
    this.type = name;
    this.maxOrientations = maxOrientations;
    this.dimension = dimension;
    this.coords = new int[maxOrientations][dimension][dimension];
    
    this.y = dimension;
    this.x = initialX;
  }
  
  public int[][] getCoords() {
    return this.coords[this.orientation];
  }
  
  public void moveDown() {
    this.y++;
  }
  
  public void moveLeft() {
    this.x--;
  }
  
  public void moveRight() {
    this.x++;
  }
  
  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
  
  public int getDimension() {
    return this.dimension;
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
    System.out.println("y/x: (" + y + "," + x + ")");
    
    System.out.println("**********-- " + this.orientation + " --**********");
    for (int y = 0; y < this.coords[this.orientation].length; y++) {
      System.out.println(Arrays.toString(this.coords[this.orientation][y]));
    }
  }
}
