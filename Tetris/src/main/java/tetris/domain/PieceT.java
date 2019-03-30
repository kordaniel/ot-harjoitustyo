package tetris.domain;

public class PieceT extends Piece {

  private final int SYMBOL;
  
  public PieceT(int initialX) {
    super("T", 3, 4, initialX);
    this.SYMBOL = 2;
    this.initializeCoords();
  }
  
  private void initializeCoords() {
    super.coords[0][1][0] = this.SYMBOL;
    super.coords[0][1][1] = this.SYMBOL;
    super.coords[0][1][2] = this.SYMBOL;
    super.coords[0][2][1] = this.SYMBOL;
    
    super.coords[1][0][2] = this.SYMBOL;
    super.coords[1][1][1] = this.SYMBOL;
    super.coords[1][1][2] = this.SYMBOL;
    super.coords[1][2][2] = this.SYMBOL;
    
    super.coords[2][1][1] = this.SYMBOL;
    super.coords[2][2][0] = this.SYMBOL;
    super.coords[2][2][1] = this.SYMBOL;
    super.coords[2][2][2] = this.SYMBOL;
    
    super.coords[3][0][0] = this.SYMBOL;
    super.coords[3][1][0] = this.SYMBOL;
    super.coords[3][1][1] = this.SYMBOL;
    super.coords[3][2][0] = this.SYMBOL;
  }
}
