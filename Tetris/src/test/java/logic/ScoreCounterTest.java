package logic;

import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.logic.ScoreCounter;

public class ScoreCounterTest {
    
    ScoreCounter scoreCounter;
    
    public ScoreCounterTest() {
    }
    
    @Before
    public void setUp() {
        scoreCounter = new ScoreCounter();
    }
    
    @Test
    public void constructedWithScoreZero() {
        assertEquals(0, scoreCounter.getTotalScore());
    }
    
    @Test
    public void constructedWithClearedLinesZero() {
        assertEquals(0, scoreCounter.getTotalClearedLinesAmount());
    }
    
    @Test
    public void LevelIsCorrectAfterConstruction() {
        assertEquals(1, scoreCounter.getLevel());
    }
    
    @Test
    public void constructedShouldNotBeSaved() {
        assertFalse(scoreCounter.shouldBeSaved());
    }
    
    @Test
    public void oneClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(1);
        assertEquals(1, scoreCounter.getTotalClearedLinesAmount());
    }
    
    @Test
    public void twoClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(2);
        assertEquals(2, scoreCounter.getTotalClearedLinesAmount());
    }
    
    @Test
    public void threeClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(3);
        assertEquals(3, scoreCounter.getTotalClearedLinesAmount());
    }
    
    @Test
    public void fourClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(4);
        assertEquals(4, scoreCounter.getTotalClearedLinesAmount());
    }
    
    @Test
    public void incrementClearedLinesMultipleTimes() {
        scoreCounter.incrementClearedLines(1);
        scoreCounter.incrementClearedLines(2);
        scoreCounter.incrementClearedLines(3);
        scoreCounter.incrementClearedLines(4);
        assertEquals(10, scoreCounter.getTotalClearedLinesAmount());
    }
    
    @Test
    public void oneClearedLineIncrementsScore() {
        scoreCounter.incrementClearedLines(1);
        assertEquals(100, scoreCounter.getTotalScore());
    }
    
    @Test
    public void twoClearedLinesIncrementScore() {
        scoreCounter.incrementClearedLines(2);
        assertEquals(200, scoreCounter.getTotalScore());
    }
    
    @Test
    public void threeClearedLineIncrementsScore() {
        scoreCounter.incrementClearedLines(3);
        assertEquals(300, scoreCounter.getTotalScore());
    }
    
    @Test
    public void fourClearedLinesIncrementScore() {
        scoreCounter.incrementClearedLines(4);
        assertEquals(400, scoreCounter.getTotalScore());
    }
    
    @Test
    public void multipleClearedLinesIncrementScore() {
        scoreCounter.incrementClearedLines(1);
        scoreCounter.incrementClearedLines(3);
        scoreCounter.incrementClearedLines(4);
        scoreCounter.incrementClearedLines(1);
        scoreCounter.incrementClearedLines(4);
        scoreCounter.incrementClearedLines(2);
        assertEquals(3200, scoreCounter.getTotalScore());
    }
    
    @Test
    public void zeroClearedLinesDoesNotChangeObjectState() {
        scoreCounter.incrementClearedLines(3);
        scoreCounter.incrementClearedLines(2);
        scoreCounter.incrementClearedLines(0);
        scoreCounter.incrementClearedLines(2);
        assertEquals(1300, scoreCounter.getTotalScore());
    }
    
    @Test
    public void resetClearsStatistics() {
        scoreCounter.incrementClearedLines(1);
        scoreCounter.incrementClearedLines(3);
        scoreCounter.incrementClearedLines(4);
        scoreCounter.incrementClearedLines(1);
        scoreCounter.incrementClearedLines(4);
        scoreCounter.incrementClearedLines(2);
        scoreCounter.setIsSaved(true);
        
        scoreCounter.reset();
        
        assertEquals(0, scoreCounter.getTotalScore());
        assertEquals(0, scoreCounter.getTotalClearedLinesAmount());
        assertFalse(scoreCounter.shouldBeSaved());
        
        //check that lastClearedLinesGetSetToOne
        scoreCounter.incrementClearedLines(3);
        assertEquals(300, scoreCounter.getTotalScore());
    }
    
    @Test
    public void actualScoreShouldBeSaved() {
        scoreCounter.incrementClearedLines(3);
        assertTrue(scoreCounter.shouldBeSaved());
    }
    
    @Test
    public void savedScoreShouldNotBeSaved() {
        scoreCounter.incrementClearedLines(3);
        scoreCounter.setIsSaved(true);
        assertFalse(scoreCounter.shouldBeSaved());
    }
    
    @Test
    public void levelIsRightAfterFiveClearedLines() {
        scoreCounter.incrementClearedLines(2);
        scoreCounter.incrementClearedLines(3);
        assertEquals(2, scoreCounter.getLevel());
    }
    
    @Test
    public void levelRisesCorrectly() {
        Random r = new Random(1337);
        int totalClearedLines = 0;
        while (totalClearedLines < 3001) {
            int clearedLines = 1 + r.nextInt(4);
            scoreCounter.incrementClearedLines(clearedLines);
            totalClearedLines += clearedLines;
            assertEquals((totalClearedLines / 5) + 1, scoreCounter.getLevel());
        }
    }
}
