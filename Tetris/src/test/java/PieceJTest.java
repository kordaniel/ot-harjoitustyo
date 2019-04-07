
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import tetris.domain.Piece;
import tetris.domain.PieceJ;


public class PieceJTest {
    
    Piece tetrisPiece;

    public PieceJTest() {
    }
    
    @Before
    public void setUp() {
        tetrisPiece = new PieceJ(6);
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
        assertEquals(6, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheLeft() {
        tetrisPiece.moveLeft();
        assertEquals(5, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedToTheRight() {
        tetrisPiece.moveRight();
        assertEquals(7, tetrisPiece.getX());
    }
    
    @Test
    public void pieceCanBeMovedDown() {
        tetrisPiece.moveDown();
        assertEquals(4, tetrisPiece.getY());
    }

    @Test
    public void pieceIsConstructedWithRightCoords() {
        int[][] expectedCoords = 
           {{0,3,0},
            {0,3,0},
            {3,3,0}};

        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightOneTime() {
        int[][] expectedCoords =
            {{0,0,0},
             {3,0,0},
             {3,3,3}};
        
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightTwoTimes() {
        int[][] expectedCoords =
            {{3,3,0},
             {3,0,0},
             {3,0,0}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightThreeTimes() {
        int[][] expectedCoords =
            {{0,0,0},
             {3,3,3},
             {0,0,3}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightFourTimes() {
        int[][] expectedCoords = 
           {{0,3,0},
            {0,3,0},
            {3,3,0}};

        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }

    @Test
    public void pieceCanBeRotatedLeftOneTime() {
        int[][] expectedCoords =
            {{0,0,0},
             {3,3,3},
             {0,0,3}};
        
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftTwoTimes() {
        int[][] expectedCoords =
            {{3,3,0},
             {3,0,0},
             {3,0,0}};
        
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftThreeTimes() {
        int[][] expectedCoords =
            {{0,0,0},
             {3,0,0},
             {3,3,3}};
        
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftFourTimes() {
        int[][] expectedCoords = 
           {{0,3,0},
            {0,3,0},
            {3,3,0}};

        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
}
