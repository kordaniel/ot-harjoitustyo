package tetris.domain.piece;

public class PieceS extends Piece {
    
    private final int SYMBOL;

    /**
     * 
     * @param initialX Initial X-coordinate of the constructed piece
     */
    public PieceS(int initialX) {
        super("S", 3, 2, 1, initialX);
        this.SYMBOL = 8;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][1][1] = this.SYMBOL;
        super.pieceCoordinates[0][1][2] = this.SYMBOL;
        super.pieceCoordinates[0][2][0] = this.SYMBOL;
        super.pieceCoordinates[0][2][1] = this.SYMBOL;
        
        super.pieceCoordinates[1][0][0] = this.SYMBOL;
        super.pieceCoordinates[1][1][0] = this.SYMBOL;
        super.pieceCoordinates[1][1][1] = this.SYMBOL;
        super.pieceCoordinates[1][2][1] = this.SYMBOL;
    }
}
