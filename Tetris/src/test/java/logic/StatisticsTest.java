package logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.logic.Statistics;

public class StatisticsTest {
    
    Statistics gameStatistics;
    
    public StatisticsTest() {
    }
    
    @Before
    public void setUp() {
        gameStatistics = new Statistics();
    }
    
    @Test
    public void constructedWithScoreZero() {
        assertEquals(0, gameStatistics.getTotalScore());
    }
    
    @Test
    public void constructedWithClearedLinesZero() {
        assertEquals(0, gameStatistics.getTotalClearedLinesNum());
    }
    
    @Test
    public void constructedWithIsSavedFalse() {
        assertFalse(gameStatistics.getIsSaved());
    }
    
    @Test
    public void oneClearedLineIncrementsClearedLines() {
        gameStatistics.incrementClearedLines(1);
        assertEquals(1, gameStatistics.getTotalClearedLinesNum());
    }
    
    @Test
    public void twoClearedLineIncrementsClearedLines() {
        gameStatistics.incrementClearedLines(2);
        assertEquals(2, gameStatistics.getTotalClearedLinesNum());
    }
    
    @Test
    public void threeClearedLineIncrementsClearedLines() {
        gameStatistics.incrementClearedLines(3);
        assertEquals(3, gameStatistics.getTotalClearedLinesNum());
    }
    
    @Test
    public void fourClearedLineIncrementsClearedLines() {
        gameStatistics.incrementClearedLines(4);
        assertEquals(4, gameStatistics.getTotalClearedLinesNum());
    }
    
    @Test
    public void incrementClearedLinesMultipleTimes() {
        gameStatistics.incrementClearedLines(1);
        gameStatistics.incrementClearedLines(2);
        gameStatistics.incrementClearedLines(3);
        gameStatistics.incrementClearedLines(4);
        assertEquals(10, gameStatistics.getTotalClearedLinesNum());
    }
    
    @Test
    public void oneClearedLineIncrementsScore() {
        gameStatistics.incrementClearedLines(1);
        assertEquals(100, gameStatistics.getTotalScore());
    }
    
    @Test
    public void twoClearedLinesIncrementScore() {
        gameStatistics.incrementClearedLines(2);
        assertEquals(200, gameStatistics.getTotalScore());
    }
    
    @Test
    public void threeClearedLineIncrementsScore() {
        gameStatistics.incrementClearedLines(3);
        assertEquals(300, gameStatistics.getTotalScore());
    }
    
    @Test
    public void fourClearedLinesIncrementScore() {
        gameStatistics.incrementClearedLines(4);
        assertEquals(400, gameStatistics.getTotalScore());
    }
    
    @Test
    public void multipleClearedLinesIncrementScore() {
        gameStatistics.incrementClearedLines(1);
        gameStatistics.incrementClearedLines(3);
        gameStatistics.incrementClearedLines(4);
        gameStatistics.incrementClearedLines(1);
        gameStatistics.incrementClearedLines(4);
        gameStatistics.incrementClearedLines(2);
        assertEquals(3200, gameStatistics.getTotalScore());
    }
    
    @Test
    public void getTotalScoreAsString() {
        gameStatistics.incrementClearedLines(4);
        assertEquals("400", gameStatistics.getTotalScoreAsString());
    }
    
    @Test
    public void getClearedLinesAsString() {
        gameStatistics.incrementClearedLines(3);
        assertEquals("3", gameStatistics.getClearedLinesAsString());
    }
    
    @Test
    public void resetClearsStatistics() {
        gameStatistics.incrementClearedLines(1);
        gameStatistics.incrementClearedLines(3);
        gameStatistics.incrementClearedLines(4);
        gameStatistics.incrementClearedLines(1);
        gameStatistics.incrementClearedLines(4);
        gameStatistics.incrementClearedLines(2);
        gameStatistics.setIsSaved(true);
        
        gameStatistics.reset();
        
        assertEquals(0, gameStatistics.getTotalScore());
        assertEquals(0, gameStatistics.getTotalClearedLinesNum());
        assertFalse(gameStatistics.getIsSaved());
        
        //check that lastClearedLinesGetSetToZero
        gameStatistics.incrementClearedLines(3);
        assertEquals(300, gameStatistics.getTotalScore());
    }
}
