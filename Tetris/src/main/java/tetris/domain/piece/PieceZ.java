package tetris.domain.piece;

public class PieceZ extends Piece {
    
    private final int symbol;
    
    public PieceZ(int initialX) {
        super(3, 2, 1, initialX);
        this.symbol = 7;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][1][0] = this.symbol;
        super.pieceCoordinates[0][1][1] = this.symbol;
        super.pieceCoordinates[0][2][1] = this.symbol;
        super.pieceCoordinates[0][2][2] = this.symbol;
        
        super.pieceCoordinates[1][0][2] = this.symbol;
        super.pieceCoordinates[1][1][1] = this.symbol;
        super.pieceCoordinates[1][1][2] = this.symbol;
        super.pieceCoordinates[1][2][1] = this.symbol;
    }
}
