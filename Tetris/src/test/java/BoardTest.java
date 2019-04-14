import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Board;
import tetris.domain.piece.PieceI;
import tetris.domain.piece.PieceO;
import tetris.domain.piece.PieceT;

public class BoardTest {
    
    int boardHeight;
    int boardWidth;
    Board tetrisBoard;
    int[][] expectedEmptyBoard;
    
    public BoardTest() {
    }
    
    @Before
    public void setUp() {
        boardHeight = 4;
        boardWidth = 4;
        tetrisBoard = new Board(boardHeight, boardWidth);
        expectedEmptyBoard = new int[boardHeight][boardWidth];
    }
    
    @Test
    public void boardIsCreatedWitCorrectHeight() {
            assertEquals(boardHeight, tetrisBoard.getBoardCopy().length);
    }
    
    @Test
    public void boardIsCreatedWithCorrectWidth() {
        int boardHeight = tetrisBoard.getBoardCopy().length;
        boolean allRowsHaveCorrectWidth = true;
        for (int y = 0; y < boardHeight; y++) {
            if (tetrisBoard.getBoardCopy()[y].length != boardWidth) {
                allRowsHaveCorrectWidth = false;
                break;
            }
        }
        assertEquals(true, allRowsHaveCorrectWidth);
    }
    
    @Test
    public void ConstructedBoardIsEmpty() {
        //int[][] expectedBoard = new int[boardHeight][boardWidth];
        assertArrayEquals(expectedEmptyBoard, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void tetrisPieceCanNotBeAddedOutsideTheBoard() {
        //PieceO width is 2=>half piece go outside the board dimensions
        tetrisBoard.addPieceToBoard(new PieceO(boardWidth-1));
        tetrisBoard.addPieceToBoard(new PieceO(-1));
        assertArrayEquals(expectedEmptyBoard, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void tetrisPieceCanBeAddedToBoard() {
        int[][] expectedResult = {
            {0,3,3,0},
            {0,3,3,0},
            {0,0,0,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceO(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void RowsWithEmptyCoordsAreNotCleared() {
        int[][] expectedResult = {
            {0,0,0,0},
            {0,2,2,2},
            {0,0,2,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceT(1));
        tetrisBoard.clearRows();
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void oneRowIsCleared() {
        PieceI p = new PieceI(0);
        p.rotateRight();
        tetrisBoard.addPieceToBoard(p);
        tetrisBoard.clearRow(3);
        assertArrayEquals(expectedEmptyBoard, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void coordinateCanFallDown() {
        int[][] expectedResult = {
            {0,3,3,0},
            {0,3,3,0},
            {0,0,0,0},
            {0,0,3,0}};
        tetrisBoard.addPieceToBoard(new PieceO(1));
        tetrisBoard.dropCoordinate(1, 2, 3);
        
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    
    /*
    @Test
    public void coordinateFallsOnTopOfNextPiece() {
        int[][] expectedResult = {
            {0,3,3,0},
            {0,3,3,0},
            {0,0,0,0},
            {0,3,0,0},
            {2,2,2,0},
            {0,2,0,0}};
        Board testBoard = new Board(6, 4);
        testBoard.addPieceToBoard(new PieceT(0));
        testBoard.dropRows();
        testBoard.addPieceToBoard(new PieceO(1));
        testBoard.dropCoordinate(1, 1, 3);
        assertArrayEquals(expectedResult, testBoard.getBoardCopy());
    }*/
    
}
