package tetris.domain.piece;

public class PieceI extends Piece {

    private final int symbol;

    public PieceI(int initialX) {
        super(4, 4, 3, initialX);
        this.symbol = 4;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        super.pieceCoordinates[0][3][1] = this.symbol;
        super.pieceCoordinates[0][2][1] = this.symbol;
        super.pieceCoordinates[0][1][1] = this.symbol;
        super.pieceCoordinates[0][0][1] = this.symbol;

        super.pieceCoordinates[1][3][0] = this.symbol;
        super.pieceCoordinates[1][3][1] = this.symbol;
        super.pieceCoordinates[1][3][2] = this.symbol;
        super.pieceCoordinates[1][3][3] = this.symbol;

        super.pieceCoordinates[2][3][2] = this.symbol;
        super.pieceCoordinates[2][2][2] = this.symbol;
        super.pieceCoordinates[2][1][2] = this.symbol;
        super.pieceCoordinates[2][0][2] = this.symbol;

        super.pieceCoordinates[3][3][0] = this.symbol;
        super.pieceCoordinates[3][3][1] = this.symbol;
        super.pieceCoordinates[3][3][2] = this.symbol;
        super.pieceCoordinates[3][3][3] = this.symbol;
    }
}
