package tetris.domain.piece;

public class PieceJ extends Piece {
    
    private final int symbol;

    public PieceJ(int initialX) {
        super(3, 4, 2, initialX);
        this.symbol = 5;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        this.setCoordsForDefaultOrientation();
        this.setCoordsForRightTiltedOrientation();
        this.setCoordsForUpsidedownOrientation();
        this.setCoordsForLeftTilteddOrientation();
    }
    
    private void setCoordsForDefaultOrientation() {
        super.pieceCoordinates[0][0][1] = this.symbol;
        super.pieceCoordinates[0][1][1] = this.symbol;
        super.pieceCoordinates[0][2][1] = this.symbol;
        super.pieceCoordinates[0][2][0] = this.symbol;
    }
    
    private void setCoordsForRightTiltedOrientation() {
        super.pieceCoordinates[1][1][0] = this.symbol;
        super.pieceCoordinates[1][2][0] = this.symbol;
        super.pieceCoordinates[1][2][1] = this.symbol;
        super.pieceCoordinates[1][2][2] = this.symbol;
    }
    
    private void setCoordsForUpsidedownOrientation() {
        super.pieceCoordinates[2][0][0] = this.symbol;
        super.pieceCoordinates[2][0][1] = this.symbol;
        super.pieceCoordinates[2][1][0] = this.symbol;
        super.pieceCoordinates[2][2][0] = this.symbol;
    }
    
    private void setCoordsForLeftTilteddOrientation() {
        super.pieceCoordinates[3][1][0] = this.symbol;
        super.pieceCoordinates[3][1][1] = this.symbol;
        super.pieceCoordinates[3][1][2] = this.symbol;
        super.pieceCoordinates[3][2][2] = this.symbol;
    }
    
}
