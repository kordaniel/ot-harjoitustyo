package tetris.domain.piece;

public class PieceL extends Piece {
    
    private final int SYMBOL;

    public PieceL(int initialX) {
        super("L", 3, 4, initialX);
        this.SYMBOL = 6;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][0][0] = this.SYMBOL;
        super.pieceCoordinates[0][1][0] = this.SYMBOL;
        super.pieceCoordinates[0][2][0] = this.SYMBOL;
        super.pieceCoordinates[0][2][1] = this.SYMBOL;
        
        super.pieceCoordinates[1][1][0] = this.SYMBOL;
        super.pieceCoordinates[1][1][1] = this.SYMBOL;
        super.pieceCoordinates[1][1][2] = this.SYMBOL;
        super.pieceCoordinates[1][2][0] = this.SYMBOL;
        
        super.pieceCoordinates[2][0][0] = this.SYMBOL;
        super.pieceCoordinates[2][0][1] = this.SYMBOL;
        super.pieceCoordinates[2][1][1] = this.SYMBOL;
        super.pieceCoordinates[2][2][1] = this.SYMBOL;
        
        super.pieceCoordinates[3][1][2] = this.SYMBOL;
        super.pieceCoordinates[3][2][0] = this.SYMBOL;
        super.pieceCoordinates[3][2][1] = this.SYMBOL;
        super.pieceCoordinates[3][2][2] = this.SYMBOL;
    }
}
