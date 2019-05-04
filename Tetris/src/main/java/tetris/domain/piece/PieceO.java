package tetris.domain.piece;

public class PieceO extends Piece {
    
    private final int symbol;

    public PieceO(int initialX) {
        super(2, 1, 1, initialX);
        this.symbol = 3;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][0][0] = this.symbol;
        super.pieceCoordinates[0][0][1] = this.symbol;
        super.pieceCoordinates[0][1][0] = this.symbol;
        super.pieceCoordinates[0][1][1] = this.symbol;
    }
}
