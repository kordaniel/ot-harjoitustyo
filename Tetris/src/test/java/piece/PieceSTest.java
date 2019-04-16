package piece;

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
        assertEquals(1, tetrisPiece.getY());
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
        assertEquals(2, tetrisPiece.getY());
    }

    @Test
    public void pieceIsConstructedWithRightCoords() {
        assertArrayEquals(expectedUprightCoords, tetrisPiece.getCoords());
    }
    
    @Test
    public void pieceReturnsCorrectCoordsForNextOrientation() {
        assertArrayEquals(expectedTiltedCoords, tetrisPiece.getCoordsForNextOrientation());
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
}
