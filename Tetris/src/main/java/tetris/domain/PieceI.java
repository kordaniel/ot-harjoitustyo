package tetris.domain;

public class PieceI extends Piece {
  
  private final int SYMBOL;
  
  public PieceI(int initialX) {
    super("I", 4, 4, initialX);
    this.SYMBOL = 1;
    this.initializeCoords();
  }
  
  private void initializeCoords() {
    super.coords[0][3][1] = this.SYMBOL;
    super.coords[0][2][1] = this.SYMBOL;
    super.coords[0][1][1] = this.SYMBOL;
    super.coords[0][0][1] = this.SYMBOL;
    
    super.coords[1][3][0] = this.SYMBOL;
    super.coords[1][3][1] = this.SYMBOL;
    super.coords[1][3][2] = this.SYMBOL;
    super.coords[1][3][3] = this.SYMBOL;
    
    super.coords[2][3][2] = this.SYMBOL;
    super.coords[2][2][2] = this.SYMBOL;
    super.coords[2][1][2] = this.SYMBOL;
    super.coords[2][0][2] = this.SYMBOL;
    
    super.coords[3][3][0] = this.SYMBOL;
    super.coords[3][3][1] = this.SYMBOL;
    super.coords[3][3][2] = this.SYMBOL;
    super.coords[3][3][3] = this.SYMBOL;
  }
}
