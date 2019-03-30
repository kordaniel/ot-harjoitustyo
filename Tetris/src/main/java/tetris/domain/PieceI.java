package tetris.domain;

public class PieceI extends Piece {
  
  public PieceI() {
    super("I", 4, 4);
    this.initializeCoords();
  }
  
  private void initializeCoords() {
    super.coords[0][3][1] = 1;
    super.coords[0][2][1] = 1;
    super.coords[0][1][1] = 1;
    super.coords[0][0][1] = 1;
    
    super.coords[1][3][0] = 1;
    super.coords[1][3][1] = 1;
    super.coords[1][3][2] = 1;
    super.coords[1][3][3] = 1;
    
    super.coords[2][3][2] = 1;
    super.coords[2][2][2] = 1;
    super.coords[2][1][2] = 1;
    super.coords[2][0][2] = 1;
    
    super.coords[3][3][0] = 1;
    super.coords[3][3][1] = 1;
    super.coords[3][3][2] = 1;
    super.coords[3][3][3] = 1;
  }
}
