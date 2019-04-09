import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.piece.Piece;
import tetris.domain.piece.PieceS;

public class PieceSTest {
    
    int[][] expectedUprightCoords;
    int[][] expectedTiltedCoords;
    Piece tetrisPiece;
    
    public PieceSTest() {
        expectedUprightCoords = new int[][]
                {{0,0,0},
                 {0,8,8},
                 {8,8,0}};
        expectedTiltedCoords = new int[][]
                {{8,0,0},
                 {8,8,0},
                 {0,8,0}};
    }
    
    @Before
    public void setUp() {
        tetrisPiece = new PieceS(4);
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
    
    @Test
    public void pieceCanBeRotatedRightThreeTimes() {
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        assertArrayEquals(expectedTiltedCoords, tetrisPiece.getCoords());
    }
    
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
}
