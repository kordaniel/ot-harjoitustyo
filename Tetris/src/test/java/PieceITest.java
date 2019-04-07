import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Piece;
import tetris.domain.PieceI;


public class PieceITest {
    
    Piece tetrisPiece;
    
    public PieceITest() {
    }
    
    @Before
    public void setUp() {
        tetrisPiece = new PieceI(4);
    }
    
    @Test
    public void pieceHasCorrectSize() {
        assertEquals(4, tetrisPiece.getSize());
    }
    @Test
    public void construcedPieceHasCorrectYPosition() {
        assertEquals(4, tetrisPiece.getY());
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
        assertEquals(5, tetrisPiece.getY());
    }

    @Test
    public void pieceIsConstructedWithRightCoords() {
        int[][] expectedCoords = 
           {{0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}};

        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightOneTime() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {1,1,1,1}};
        
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightTwoTimes() {
        int[][] expectedCoords =
            {{0,0,1,0},
             {0,0,1,0},
             {0,0,1,0},
             {0,0,1,0}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightThreeTimes() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {1,1,1,1}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedRightFourTimes() {
        int[][] expectedCoords = 
           {{0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}};

        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }

    @Test
    public void pieceCanBeRotatedLeftOneTime() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {1,1,1,1}};
        
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftTwoTimes() {
        int[][] expectedCoords =
            {{0,0,1,0},
             {0,0,1,0},
             {0,0,1,0},
             {0,0,1,0}};
        
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftThreeTimes() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {1,1,1,1}};
        
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceCanBeRotatedLeftFourTimes() {
        int[][] expectedCoords = 
           {{0,1,0,0},
            {0,1,0,0},
            {0,1,0,0},
            {0,1,0,0}};

        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        tetrisPiece.rotateLeft();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getCoords());
    }
    
    public boolean deepArraysEqual(int[][] arr1, int[][] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        
        if (arr1.length != arr2.length) {
            return false;
        }
        
        for (int y = 0; y < arr1.length; y++) {
            if (arr1[y].length != arr2[y].length ) {
                return false;
            }
            
            for (int x = 0; x < arr1[y].length; x++) {
                if (arr1[y][x] != arr2[y][x]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
