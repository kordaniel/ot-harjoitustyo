package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.Board;
import tetris.domain.piece.PieceI;
import tetris.domain.piece.PieceJ;
import tetris.domain.piece.PieceL;
import tetris.domain.piece.PieceO;
import tetris.domain.piece.PieceS;
import tetris.domain.piece.PieceT;
import tetris.domain.piece.PieceZ;

public class BoardTest {
    
    int boardHeight;
    int boardWidth;
    Board tetrisBoard;
    int[][] expectedEmptyBoard;
    
    public BoardTest() {
        boardHeight = 4;
        boardWidth = 4;
    }
    
    @Before
    public void setUp() {
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
        assertTrue(allRowsHaveCorrectWidth);
    }
    
    @Test
    public void ConstructedBoardIsEmpty() {
        assertArrayEquals(expectedEmptyBoard, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void tetrisPieceCanNotBeAddedOutsideTheBoard() {
        //PieceO width is 2 => half piece go outside the board dimensions
        tetrisBoard.addPieceToBoard(new PieceO(boardWidth-1));
        tetrisBoard.addPieceToBoard(new PieceO(-1));
        assertArrayEquals(expectedEmptyBoard, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceTIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,2,2,2},
            {0,0,2,0},
            {0,0,0,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceT(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceOIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,3,3,0},
            {0,3,3,0},
            {0,0,0,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceO(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,0,4,0},
            {0,0,4,0},
            {0,0,4,0},
            {0,0,4,0}};
        tetrisBoard.addPieceToBoard(new PieceI(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceJIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,0,5,0},
            {0,0,5,0},
            {0,5,5,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceJ(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceLIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,6,0,0},
            {0,6,0,0},
            {0,6,6,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceL(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceZIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,7,7,0},
            {0,0,7,7},
            {0,0,0,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceZ(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceSIsSpawnedAtRightCoords() {
        int[][] expectedResult = {
            {0,0,8,8},
            {0,8,8,0},
            {0,0,0,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceS(1));
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
    }
    
    @Test
    public void pieceCanMoveDownReturnsTrueWhenPieceCanGoDown() {
        PieceO tetrisPiece = new PieceO(0);
        assertTrue(tetrisBoard.pieceCanMoveDown(tetrisPiece));
    }
    
    @Test
    public void pieceCanMoveDownReturnsFalseWhenPieceIsAtBottom() {
        PieceO tetrisPiece = new PieceO(0);
        tetrisPiece.moveDown();
        tetrisPiece.moveDown();
        assertFalse(tetrisBoard.pieceCanMoveDown(tetrisPiece));
    }
    
    @Test
    public void pieceCanMoveDownReturnsFalseWhenPieceIsOnTopOfAnother() {
        PieceO tetrisPiece = new PieceO(1);
        tetrisPiece.moveDown();
        tetrisPiece.moveDown();
        tetrisBoard.addPieceToBoard(tetrisPiece);
        tetrisPiece = new PieceO(1);
        assertFalse(tetrisBoard.pieceCanMoveDown(tetrisPiece));
    }
    
    @Test
    public void oneRowIsCleared() {
        PieceI p = new PieceI(0);
        p.rotateRight();
        tetrisBoard.addPieceToBoard(p);
        tetrisBoard.clearRow(3);
        assertArrayEquals(expectedEmptyBoard, tetrisBoard.getBoardCopy());
    }
    /*
    @Test
    public void RowsWithEmptyCoordsAreNotCleared() {
        int[][] expectedResult = {
            {0,0,0,0},
            {0,2,2,2},
            {0,0,2,0},
            {0,0,0,0}};
        tetrisBoard.addPieceToBoard(new PieceT(1));
        boolean boardChanged = tetrisBoard.clearRows();
        assertArrayEquals(expectedResult, tetrisBoard.getBoardCopy());
        assertFalse(boardChanged);
    }
    
    @Test
    public void onlyRowsWithNoEmptyCoordsAreCleared() {
        int[][] boardState = {
            {0,0,1,0},
            {3,3,3,3},
            {0,2,2,2},
            {0,0,2,0}};
        int[][] expectedResult = {
            {0,0,1,0},
            {0,0,0,0},
            {0,2,2,2},
            {0,0,2,0}};
        Board boardInstance = new Board(boardState, 4, 4);
        boolean boardChanged = boardInstance.clearRows();
        assertArrayEquals(expectedResult, boardInstance.getBoardCopy());
        assertTrue(boardChanged);
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
    
    
    
    @Test
    public void coordinateFallsOnTopOfNextPiece() {
        int[][] boardState = {
            {0,3,3,0},
            {0,3,3,0},
            {0,0,0,0},
            {0,0,0,0},
            {2,2,2,0},
            {0,2,0,0}};
        int[][] expectedResult = {
            {0,3,3,0},
            {0,3,3,0},
            {0,0,0,0},
            {0,3,0,0},
            {2,2,2,0},
            {0,2,0,0}};
        Board boardInstance = new Board(boardState, 6, 4);
        boardInstance.dropCoordinate(1, 1, 3);
        assertArrayEquals(expectedResult, boardInstance.getBoardCopy());
    }
    */
    
    @Test
    public void dropRowsDoesNotChangeBoardWhenThereIsNoFullRows() {
        int[][] boardState = {
            {0,4,4,4,4,0},
            {0,0,4,0,0,0},
            {0,0,4,0,0,0},
            {3,3,4,0,0,0},
            {3,3,4,0,0,0}};
        int[][] expectedCoords = {
            {0,4,4,4,4,0},
            {0,0,4,0,0,0},
            {0,0,4,0,0,0},
            {3,3,4,0,0,0},
            {3,3,4,0,0,0}};
        Board boardInstance = new Board(boardState, 5, 6);
        int clearedRows = boardInstance.dropRows();
        assertArrayEquals(expectedCoords, boardInstance.getBoardCopy());
        assertEquals(0, clearedRows);
    }
    
    @Test
    public void dropRowsClearsOneFullRow() {
        int[][] boardState = {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {4,4,4,4}};
        Board boardInstance = new Board(boardState, 4, 4);
        int clearedRows = boardInstance.dropRows();
        assertArrayEquals(expectedEmptyBoard, boardInstance.getBoardCopy());
        assertEquals(1, clearedRows);
    }
    
    @Test
    public void dropRowsClearsTheBoardWhenAllRowsAreFull() {
        int[][] boardState = {
            {3,3,3,3},
            {3,3,3,3},
            {3,3,3,3},
            {3,3,3,3}};
        Board boardInstance = new Board(boardState, 4, 4);
        int clearedRows = boardInstance.dropRows();
        assertArrayEquals(expectedEmptyBoard, boardInstance.getBoardCopy());
        assertEquals(4, clearedRows);
    }
    
    @Test
    public void dropRowsClearsTheFullRowAndDropsTheOnesAbove() {
        int[][] boardState = {
            {0,7,7,7},
            {6,6,0,0},
            {4,5,3,0},
            {1,2,3,4}};
        int[][] expectedCoords = {
            {0,0,0,0},
            {0,7,7,7},
            {6,6,0,0},
            {4,5,3,0}};
        Board boardInstance = new Board(boardState, 4, 4);
        int clearedRows = boardInstance.dropRows();
        assertArrayEquals(expectedCoords, boardInstance.getBoardCopy());
        assertEquals(1, clearedRows);
    }
    
    @Test
    public void dropRowsClearsAllFullRowsAndDropsTheOneAbove() {
        int[][] boardState = {
            {0,7,7,7},
            {6,6,2,2},
            {4,5,3,0},
            {1,2,3,4}};
        int[][] expectedCoords = {
            {0,0,0,0},
            {0,0,0,0},
            {0,7,7,7},
            {4,5,3,0}};
        Board boardInstance = new Board(boardState, 4, 4);
        int clearedRows = boardInstance.dropRows();
        assertArrayEquals(expectedCoords, boardInstance.getBoardCopy());
        assertEquals(2, clearedRows);
    }
}
