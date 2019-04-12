package piece;



import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.piece.Piece;
import tetris.domain.piece.PieceZ;

public class PieceZTest {
    
    int[][] expectedUprightCoords;
    int[][] expectedTiltedCoords;
    Piece tetrisPiece;
    
    public PieceZTest() {
        expectedUprightCoords = new int[][]
                {{0,0,0},
                 {7,7,0},
                 {0,7,7}};
        expectedTiltedCoords = new int[][]
                {{0,0,7},
                 {0,7,7},
                 {0,7,0}};
    }
    
    @Before
    public void setUp() {
        tetrisPiece = new PieceZ(4);
    }
    
    @Test
    public void pieceHasCorrectSize() {
        assertEquals(3, tetrisPiece.getSize());
    }
    
    @Test
    public void construcedPieceHasCorrectYPosition() {
        assertEquals(3, tetrisPiece.getY());
    }
    
    @Test
    public void constructedPieceHasCorrectXPosition() {
        assertEquals(4, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheLeft() {
        tetrisPiece.moveLeft();
        assertEquals(3, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheRight() {
        tetrisPiece.moveRight();
        assertEquals(5, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedDown() {
        tetrisPiece.moveDown();
        assertEquals(4, tetrisPiece.getY());
    }

    @Test
    public void pieceIsConstructedWithRightCoords() {
        assertArrayEquals(expectedUprightCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightOneTime() {
        tetrisPiece.rotateRight();
        assertArrayEquals(expectedTiltedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightTwoTimes() {
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        assertArrayEquals(expectedUprightCoords, tetrisPiece.getCoords());
    }
    /*
    @Test
    public void pieceCanBeRotatedLeftOneTime() {
        tetrisPiece.rotateLeft();
        assertArrayEquals(expectedTiltedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftTwoTimes() {
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        assertArrayEquals(expectedUprightCoords, tetrisPiece.getCoords());
    }
    */
}
