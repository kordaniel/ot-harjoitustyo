package tetris.domain.piece;

public class PieceJ extends Piece {
    
    private final int SYMBOL;

    public PieceJ(int initialX) {
        super("J", 3, 4, initialX);
        this.SYMBOL = 5;
        this.initializeCoords();
    }
    
    private void initializeCoords() {
        this.setCoordsForDefaultOrientation();
        this.setCoordsForRightTiltedOrientation();
        this.setCoordsForUpsidedownOrientation();
        this.setCoordsForLeftTilteddOrientation();
    }
    
    private void setCoordsForDefaultOrientation() {
        super.pieceCoordinates[0][0][1] = this.SYMBOL;
        super.pieceCoordinates[0][1][1] = this.SYMBOL;
        super.pieceCoordinates[0][2][1] = this.SYMBOL;
        super.pieceCoordinates[0][2][0] = this.SYMBOL;
    }
    
    private void setCoordsForRightTiltedOrientation() {
        super.pieceCoordinates[1][1][0] = this.SYMBOL;
        super.pieceCoordinates[1][2][0] = this.SYMBOL;
        super.pieceCoordinates[1][2][1] = this.SYMBOL;
        super.pieceCoordinates[1][2][2] = this.SYMBOL;
    }
    
    private void setCoordsForUpsidedownOrientation() {
        super.pieceCoordinates[2][0][0] = this.SYMBOL;
        super.pieceCoordinates[2][0][1] = this.SYMBOL;
        super.pieceCoordinates[2][1][0] = this.SYMBOL;
        super.pieceCoordinates[2][2][0] = this.SYMBOL;
    }
    
    private void setCoordsForLeftTilteddOrientation() {
        super.pieceCoordinates[3][1][0] = this.SYMBOL;
        super.pieceCoordinates[3][1][1] = this.SYMBOL;
        super.pieceCoordinates[3][1][2] = this.SYMBOL;
        super.pieceCoordinates[3][2][2] = this.SYMBOL;
    }
    
}
