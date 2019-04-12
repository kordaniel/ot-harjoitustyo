package piece;



import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.piece.Piece;
import tetris.domain.piece.PieceO;

public class PieceOTest {
    
    int[][] expectedCoords;
    Piece tetrisPiece;
    
    public PieceOTest() {
        expectedCoords = new int[][]
                {{3,3},
                 {3,3}};
    }
    
    @Before
    public void setUp() {
        tetrisPiece = new PieceO(1);
    }
    
    @Test
    public void pieceHasCorrectSize() {
        assertEquals(2, tetrisPiece.getSize());
    }
    
    @Test
    public void constructedPieceHasCorrectYPosition() {
        assertEquals(2, tetrisPiece.getY());
    }
    
    @Test
    public void constructedPieceHasCorrectXPosition() {
        assertEquals(1, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheLeft() {
        tetrisPiece.moveLeft();
        assertEquals(0, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheRight() {
        tetrisPiece.moveRight();
        assertEquals(2, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedDown() {
        tetrisPiece.moveDown();
        assertEquals(3, tetrisPiece.getY());
    }
    
    @Test
    public void pieceIsConstructedWithRightCoords() {
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightOneTime() {
        tetrisPiece.rotateRight();
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightTwoTimes() {
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    /*
    @Test
    public void pieceCanBeRotatedLeftOneTimes() {
        tetrisPiece.rotateLeft();
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftTwoTimes() {
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    */
}
