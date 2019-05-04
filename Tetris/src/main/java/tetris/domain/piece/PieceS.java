package tetris.domain.piece;

public class PieceS extends Piece {
    
    private final int symbol;

    public PieceS(int initialX) {
        super(3, 2, 1, initialX);
        this.symbol = 8;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][1][1] = this.symbol;
        super.pieceCoordinates[0][1][2] = this.symbol;
        super.pieceCoordinates[0][2][0] = this.symbol;
        super.pieceCoordinates[0][2][1] = this.symbol;
        
        super.pieceCoordinates[1][0][0] = this.symbol;
        super.pieceCoordinates[1][1][0] = this.symbol;
        super.pieceCoordinates[1][1][1] = this.symbol;
        super.pieceCoordinates[1][2][1] = this.symbol;
    }
    
}
