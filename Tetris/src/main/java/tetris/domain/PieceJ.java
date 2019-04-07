package tetris.domain;

public class PieceJ extends Piece {
    
    private final int SYMBOL;

    public PieceJ(int initialX) {
        super("J", 3, 4, initialX);
        this.SYMBOL = 3;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][0][1] = this.SYMBOL;
        super.pieceCoordinates[0][1][1] = this.SYMBOL;
        super.pieceCoordinates[0][2][1] = this.SYMBOL;
        super.pieceCoordinates[0][2][0] = this.SYMBOL;

        super.pieceCoordinates[1][1][0] = this.SYMBOL;
        super.pieceCoordinates[1][2][0] = this.SYMBOL;
        super.pieceCoordinates[1][2][1] = this.SYMBOL;
        super.pieceCoordinates[1][2][2] = this.SYMBOL;

        super.pieceCoordinates[2][0][0] = this.SYMBOL;
        super.pieceCoordinates[2][0][1] = this.SYMBOL;
        super.pieceCoordinates[2][1][0] = this.SYMBOL;
        super.pieceCoordinates[2][2][0] = this.SYMBOL;

        super.pieceCoordinates[3][1][0] = this.SYMBOL;
        super.pieceCoordinates[3][1][1] = this.SYMBOL;
        super.pieceCoordinates[3][1][2] = this.SYMBOL;
        super.pieceCoordinates[3][2][2] = this.SYMBOL;
    }
    
}
