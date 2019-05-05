package logic;

import java.util.ArrayList;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.domain.User;
import tetris.logic.Game;
import tetris.logic.Highscores;

public class GameTest {
    
    int boardHeight;
    int boardWidth;
    Game gameStatus;
    User user;
    Highscores highscores;
    int[][] expectedEmptyBoard;
    
    public GameTest() {
        boardHeight = 4;
        boardWidth = 4;
    }
    
    @Before
    public void setUp() {
        highscores = new Highscores(new ArrayList<>());
        user = new User();
        gameStatus = new Game(boardHeight, boardWidth,
                user, highscores);
        expectedEmptyBoard = new int[boardHeight][boardWidth];
    }
    
    @Test
    public void constructedGameIsAnEmptyBoard() {
        assertArrayEquals(expectedEmptyBoard, gameStatus.getBoardInPlay());
    }
    
    @Test
    public void pauseGameReturnsFalseWhenGameIsNotStarted() {
        assertFalse(gameStatus.pauseGame());
    }
    
    @Test
    public void startGameStartsTheGame() {
        gameStatus.startGame();
        assertTrue(gameStatus.getIsActive());
    }
    
    @Test
    public void pauseGameReturnsTrueWhenPausingActiveGame() {
        gameStatus.startGame();
        assertTrue(gameStatus.pauseGame());
    }
    
    @Test
    public void finishGameStopsTheGame() {
        gameStatus.startGame();
        gameStatus.finishGame();
        assertFalse(gameStatus.getIsActive());
        assertTrue(gameStatus.getIsOver());
    }
    
    @Test
    public void advanceGameChangesGameStatus() {
        gameStatus.startGame();
        gameStatus.advanceGame();
        assertThat(expectedEmptyBoard, IsNot.not(IsEqual.equalTo(gameStatus.getBoardInPlay())));
    }
    
}
