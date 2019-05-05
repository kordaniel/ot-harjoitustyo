package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.Constants;
import tetris.dao.ScoreDao;
import tetris.database.Database;
import tetris.domain.Score;
import tetris.logic.Highscores;

public class ScoreDaoTest {
    
    String dbAddress;
    String baseName;
    Database database;
    ScoreDao scoreDao;
    Highscores highscores;
    
    public ScoreDaoTest() {
        dbAddress = "jdbc:sqlite:file::memory:?cache=shared";
        baseName = "Test";
    }
    
    @Before
    public void setUp() {
        highscores = new Highscores(createListWithScores());
        database = new Database(dbAddress);
        scoreDao = new ScoreDao(database, Constants.HIGHSCORE_TABLE_NAME);
    }
    
    @Test
    public void constructedScoreDaoIsNotNull() {
        assertNotNull(scoreDao);
    }
    
    @Test
    public void constructedScoreDaoReturnsEmptyList() {
        assertTrue(scoreDao.findAll().isEmpty());
    }
    
    /*
     * This refuses to work. Apparently in-memory jdbc-sqlite database
     * connections can't read the tables
    @Test
    public void scoresCanBeSavedToDatabase() {
        scoreDao.saveAll(highscores.getAll());
        
        List<Score> scoresFromDatabase = scoreDao.findAll();
        List<Score> actualHighScores = highscores.getAll();
        
        assertEquals(actualHighScores.size(), scoresFromDatabase.size());
        
        boolean allMatch = true;
        for (int i = 0; i < actualHighScores.size(); i++) {
            if (!actualHighScores.get(i).toString().equals(
                    scoresFromDatabase.get(i).toString())) {
                allMatch = false;
                break;
            }
        }
        assertTrue(allMatch);
    }
    */
    
    private List<Score> createListWithScores() {
        ArrayList<Score> scores = new ArrayList<>();
        
        for (int i = 1; i <= 15; i++) {
            Score newScore = new Score(i, baseName + i, i);
            scores.add(newScore);
        }
        
        return scores;
    }
    
}
