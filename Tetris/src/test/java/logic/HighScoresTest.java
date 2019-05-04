package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Constants;
import tetris.domain.Score;
import tetris.logic.Highscores;

public class HighScoresTest {
    
    Highscores highscores;
    String name;
    String scoreToStringBase;
    String anonScoreToStringBase;
    int scoresToKeep;
    
    public HighScoresTest() {
        name = "Test";
        scoreToStringBase = ", score: ";
        anonScoreToStringBase = Constants.DEFAULT_ANON_PLAYER_NAME + scoreToStringBase;
        scoresToKeep = 10;
    }
    
    @Before
    public void setUp() {
        highscores = new Highscores(new ArrayList<>());
    }
    
    @Test
    public void constructedWithEmptyList() {
        assertTrue(highscores.getAll().isEmpty());
    }
    
    @Test
    public void getHighScoreReturnsEmptyScoreAfterConstruction() {
        assertEquals(anonScoreToStringBase + 0,
                highscores.getHighScore().toString());
    }
    
    @Test
    public void newScoreSavesScore() {
        highscores.newScore(name, 200);
        assertEquals(name + scoreToStringBase + 200,
                highscores.getHighScore().toString());
    }
    
    @Test
    public void newScoreSavesCorrectAmountOfScores() {
        for (int i = 0; i < scoresToKeep*5; i++) {
            highscores.newScore(name + i, i*100);
        }
        assertEquals(scoresToKeep, highscores.getAll().size());
    }
    
    /**
     * Checks that the actual top-scores are stored inside the
     * highscores-object.
     */
    @Test
    public void newScoreSavesCorrectHighScores() {
        int[] actualTopScores = populateHighScores();

        //Highscores keeps right amount of scores
        assertEquals(scoresToKeep, highscores.getAll().size());
        
        //all scores match the actual top-scores
        List<Score> savedHighScores = highscores.getAll();
        boolean allEquals = true;
        for (int i = 0; i < scoresToKeep; i++) {
            if (!savedHighScores.get(i).toString().equals(
                    name + actualTopScores[i] + scoreToStringBase + actualTopScores[i])) {
                allEquals = false;
                break;
            }
        }
        assertTrue(allEquals);
    }
    
    // These two tests are not good, should compare current top-score after
    // each iteration of creating a new score
    @Test
    public void getHighScoreReturnsCorrectScore() {
        int[] actualTopScores = populateHighScores();
        assertEquals(actualTopScores[0], highscores.getHighScore().getScore());
    }
    
    @Test
    public void getHighScoreAsStringRetrunsCorrectScore() {
        int[] actualTopScores = populateHighScores();
        assertEquals("" + actualTopScores[0],
                highscores.getHighScoreAsString());
    }
    
    /**
     * Creates 50 times the amount of scores that the Highscores-class
     * keeps and then tries to append them all to the Highscore-object.
     * @return array with the created scores in descending order.
     */
    private int[] populateHighScores() {
        Random r = new Random(1337);
        int[] actualTopScores = new int[scoresToKeep];
        
        // Create random top scores
        for (int scoreN = 0; scoreN < scoresToKeep*50; scoreN++) {
            int score = r.nextInt(100_000);

            highscores.newScore(name + score, score);
            
            // Check if new score is high enough to fit in
            // TopScores-array
            int i;
            boolean scoreIsHighEnoughToFitInTopScores = false;

            for (i = 0; i < actualTopScores.length; i++) {
                if (score > actualTopScores[i]) {
                    scoreIsHighEnoughToFitInTopScores = true;
                    break;
                }
            }
            
            // Set the new score in right position and
            // move all lesser scores down
            if (!scoreIsHighEnoughToFitInTopScores) {
                continue;
            }
            
            for (int j = actualTopScores.length -1; j >= i; j--) {
                if (j == i) {
                    actualTopScores[j] = score;
                } else {
                    actualTopScores[j] = actualTopScores[j-1];
                }
            }
        }
        return actualTopScores;
    }
    
}
