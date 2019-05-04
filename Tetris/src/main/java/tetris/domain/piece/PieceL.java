package tetris.domain.piece;

public class PieceL extends Piece {
    
    private final int symbol;

    public PieceL(int initialX) {
        super(3, 4, 2, initialX);
        this.symbol = 6;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][0][0] = this.symbol;
        super.pieceCoordinates[0][1][0] = this.symbol;
        super.pieceCoordinates[0][2][0] = this.symbol;
        super.pieceCoordinates[0][2][1] = this.symbol;
        
        super.pieceCoordinates[1][1][0] = this.symbol;
        super.pieceCoordinates[1][1][1] = this.symbol;
        super.pieceCoordinates[1][1][2] = this.symbol;
        super.pieceCoordinates[1][2][0] = this.symbol;
        
        super.pieceCoordinates[2][0][0] = this.symbol;
        super.pieceCoordinates[2][0][1] = this.symbol;
        super.pieceCoordinates[2][1][1] = this.symbol;
        super.pieceCoordinates[2][2][1] = this.symbol;
        
        super.pieceCoordinates[3][1][2] = this.symbol;
        super.pieceCoordinates[3][2][0] = this.symbol;
        super.pieceCoordinates[3][2][1] = this.symbol;
        super.pieceCoordinates[3][2][2] = this.symbol;
    }
}
