package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Constants;
import tetris.domain.Score;

public class ScoreTest {
    
    Score score;
    String name;
    String scoreToStringBase;
    String anonScoreToStringBase;
    
    public ScoreTest() {
        name = "Test";
        scoreToStringBase = ", score: ";
        anonScoreToStringBase = Constants.DEFAULT_ANON_PLAYER_NAME + scoreToStringBase;
    }
    
    @Before
    public void setUp() {
        score = new Score();
    }
    
    @Test
    public void constructedScoreIsEmpty() {
        assertEquals(anonScoreToStringBase + "0", score.toString());
    }
    
    @Test
    public void constructedGetScoreReturnsZero() {
        assertEquals(0, score.getScore());
    }
    
    @Test
    public void setAndGetScore() {
        score.setScore(2500);
        assertEquals(2500, score.getScore());
    }
    
    @Test
    public void setAndGetName() {
        score.setName(name);
        assertEquals(name, score.getName());
    }
    
    @Test
    public void scoreWithValuesReturnCorrect() {
        score.setName(name);
        score.setScore(1);
        assertEquals(name + scoreToStringBase + 1, score.toString());
    }
    
    @Test
    public void compareToWhenEqual() {
        Score first = new Score();
        Score second = new Score();
        first.setScore(500);
        second.setScore(500);
        
        assertEquals(0, first.compareTo(second));
    }
    
    @Test
    public void compareToWhenOtherIsLower() {
        Score first = new Score();
        Score second = new Score();
        first.setScore(100);
        second.setScore(99);
        
        assertEquals(-1, first.compareTo(second));
    }
    
    @Test
    public void compareToWhenOtherIsHigher() {
        Score first = new Score();
        Score second = new Score();
        first.setScore(100);
        second.setScore(101);
        
        assertEquals(1, first.compareTo(second));
    }
    
    @Test
    public void isHigherWhenEqual() {
        Score first = new Score();
        Score second = new Score();
        first.setScore(3000);
        second.setScore(3000);
        assertFalse(first.isHigher(second));
    }
    
    @Test
    public void isHigherWhenOtherIsLower() {
        Score first = new Score();
        Score second = new Score();
        first.setScore(9000);
        second.setScore(200);
        assertTrue(first.isHigher(second));
    }
    
    @Test
    public void isHigherWhenOtherIsHigher() {
        Score first = new Score();
        Score second = new Score();
        second.setScore(53100);
        assertFalse(first.isHigher(second));
    }
}
