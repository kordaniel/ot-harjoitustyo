import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Piece;
import tetris.domain.PieceT;
public class PieceTTest {

    Piece tetrisPiece;
    
    public PieceTTest() {
    }
    
    @Before
    public void setUp() {
        tetrisPiece = new PieceT(2);
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
        assertEquals(2, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheLeft() {
        tetrisPiece.moveLeft();
        assertEquals(1, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheRight() {
        tetrisPiece.moveRight();
        assertEquals(3, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedDown() {
        tetrisPiece.moveDown();
        assertEquals(4, tetrisPiece.getY());
    }

    @Test
    public void pieceIsConstructedWithRightCoords() {
        int[][] expectedCoords = 
           {{0,0,0},
            {2,2,2},
            {0,2,0}};

        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightOneTime() {
        int[][] expectedCoords =
            {{0,0,2},
             {0,2,2},
             {0,0,2}};
        
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightTwoTimes() {
        int[][] expectedCoords =
            {{0,0,0},
             {0,2,0},
             {2,2,2}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightThreeTimes() {
        int[][] expectedCoords =
            {{2,0,0},
             {2,2,0},
             {2,0,0}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightFourTimes() {
        int[][] expectedCoords = 
           {{0,0,0},
            {2,2,2},
            {0,2,0}};

        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }

    @Test
    public void pieceCanBeRotatedLeftOneTime() {
        int[][] expectedCoords =
            {{2,0,0},
             {2,2,0},
             {2,0,0}};
        
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftTwoTimes() {
        int[][] expectedCoords =
            {{0,0,0},
             {0,2,0},
             {2,2,2}};
        
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftThreeTimes() {
        int[][] expectedCoords =
            {{0,0,2},
             {0,2,2},
             {0,0,2}};
        
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftFourTimes() {
        int[][] expectedCoords = 
           {{0,0,0},
            {2,2,2},
            {0,2,0}};

        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
}
