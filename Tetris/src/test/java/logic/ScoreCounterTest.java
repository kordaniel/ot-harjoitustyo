package logic;

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
        assertEquals(0, scoreCounter.getTotalClearedLinesNum());
    }
    
    @Test
    public void constructeShouldNotBeSaved() {
        assertFalse(scoreCounter.shouldBeSaved());
    }
    
    @Test
    public void oneClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(1);
        assertEquals(1, scoreCounter.getTotalClearedLinesNum());
    }
    
    @Test
    public void twoClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(2);
        assertEquals(2, scoreCounter.getTotalClearedLinesNum());
    }
    
    @Test
    public void threeClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(3);
        assertEquals(3, scoreCounter.getTotalClearedLinesNum());
    }
    
    @Test
    public void fourClearedLineIncrementsClearedLines() {
        scoreCounter.incrementClearedLines(4);
        assertEquals(4, scoreCounter.getTotalClearedLinesNum());
    }
    
    @Test
    public void incrementClearedLinesMultipleTimes() {
        scoreCounter.incrementClearedLines(1);
        scoreCounter.incrementClearedLines(2);
        scoreCounter.incrementClearedLines(3);
        scoreCounter.incrementClearedLines(4);
        assertEquals(10, scoreCounter.getTotalClearedLinesNum());
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
    public void getClearedLinesAsString() {
        scoreCounter.incrementClearedLines(3);
        assertEquals("3", scoreCounter.getClearedLinesAsString());
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
        assertEquals(0, scoreCounter.getTotalClearedLinesNum());
        assertFalse(scoreCounter.shouldBeSaved());
        
        //check that lastClearedLinesGetSetToOne
        scoreCounter.incrementClearedLines(3);
        assertEquals(300, scoreCounter.getTotalScore());
    }
}
