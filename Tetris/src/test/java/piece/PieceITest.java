package piece;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.piece.Piece;
import tetris.domain.piece.PieceI;

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
        int[][] expectedCoords = 
           {{0,4,0,0},
            {0,4,0,0},
            {0,4,0,0},
            {0,4,0,0}};

        assertArrayEquals(expectedCoords, tetrisPiece.getPieceCoordinates());
    }
    
    @Test
    public void pieceReturnsCorrectCoordsForNextOrientation() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {4,4,4,4}};
        assertArrayEquals(expectedCoords, tetrisPiece.getCoordinatesForNextOrientation());
    }
    
    @Test
    public void pieceCanBeRotatedRightOneTime() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {4,4,4,4}};
        
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getPieceCoordinates());
    }
    
    @Test
    public void pieceCanBeRotatedRightTwoTimes() {
        int[][] expectedCoords =
            {{0,0,4,0},
             {0,0,4,0},
             {0,0,4,0},
             {0,0,4,0}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getPieceCoordinates());
    }
    
    @Test
    public void pieceCanBeRotatedRightThreeTimes() {
        int[][] expectedCoords =
            {{0,0,0,0},
             {0,0,0,0},
             {0,0,0,0},
             {4,4,4,4}};
        
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getPieceCoordinates());
    }
    
    @Test
    public void pieceCanBeRotatedRightFourTimes() {
        int[][] expectedCoords = 
           {{0,4,0,0},
            {0,4,0,0},
            {0,4,0,0},
            {0,4,0,0}};

        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        tetrisPiece.rotateRight();
        
        assertArrayEquals(expectedCoords, tetrisPiece.getPieceCoordinates());
    }
    
}
