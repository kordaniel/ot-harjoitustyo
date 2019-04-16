package tetris.domain.piece;

public class PieceZ extends Piece {
    
    private final int SYMBOL;
    
    /**
     * 
     * @param initialX Initial X-coordinate of the constructed piece
     */
    public PieceZ(int initialX) {
        super("Z", 3, 2, 1, initialX);
        this.SYMBOL = 7;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][1][0] = this.SYMBOL;
        super.pieceCoordinates[0][1][1] = this.SYMBOL;
        super.pieceCoordinates[0][2][1] = this.SYMBOL;
        super.pieceCoordinates[0][2][2] = this.SYMBOL;
        
        super.pieceCoordinates[1][0][2] = this.SYMBOL;
        super.pieceCoordinates[1][1][1] = this.SYMBOL;
        super.pieceCoordinates[1][1][2] = this.SYMBOL;
        super.pieceCoordinates[1][2][1] = this.SYMBOL;
    }
}
