package tetris.domain.piece;

public class PieceO extends Piece {
    
    private final int SYMBOL;

    public PieceO(int initialX) {
        super("O", 2, 1, initialX);
        this.SYMBOL = 3;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][0][0] = this.SYMBOL;
        super.pieceCoordinates[0][0][1] = this.SYMBOL;
        super.pieceCoordinates[0][1][0] = this.SYMBOL;
        super.pieceCoordinates[0][1][1] = this.SYMBOL;
    }
}
