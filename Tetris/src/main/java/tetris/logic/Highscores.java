package tetris.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tetris.Constants;
import tetris.domain.Score;

/**
 * This class holds the current highest ranked scores in memory sorted
 * descending. The amount of scores to hold can be set by modifying the
 * scoreAmountToKeep variables value.
 */
public class Highscores {
    
    private List<Score> highscores;
    private int scoreAmountToKeep;
    
    public Highscores(List<Score> highscores) {
        this.highscores = new ArrayList<>();
        this.scoreAmountToKeep = 10;
        
        AddAllFromList(highscores);
    }
    
    /**
     * This method is used to create a new score. The new score will
     * be saved in the top scores if it is ranked high enough.
     * @param name String, name of the player.
     * @param score integer, score.
     */
    public void newScore(String name, int score) {
        checkAndSaveIfHighEnough(new Score(null, name, score));
    }
    
    /**
     * This method can be used to pass a new score. The score
     * will be saved in the top scores if it is ranked high enough.
     * @param score to be saved if high enough.
     */
    public void checkAndSaveIfHighEnough(Score score) {
        if (scoreIsHighEnoughToFitOnList(score)) {
            trimListSize();
            addHighscoreToList(score);
        }
    }
    
    public List<Score> getAll() {
        return this.highscores;
    }
    
    /**
     * Returns the current highest score.
     * @return Score, the current highest ranked score.
     */
    public Score getHighScore() {
        if (highscores.isEmpty()) {
            return new Score();
        }
        return highscores.get(0);
    }
    
    /**
     * Helper method that processes an list with scores
     * and adds the scores that qualify to this objects list
     * @param scores List with scores
     */
    private void AddAllFromList(List<Score> scores) {
        scores.forEach((score) -> {
            checkAndSaveIfHighEnough(score);
        });
    }
    
    /**
     * Keeps the list sorted.
     * @param score to add to the list.
     */
    private void addHighscoreToList(Score score) {
        highscores.add(score);
        Collections.sort(highscores);
    }
    
    private void trimListSize() {
        while (listIsAtLeastMaxLength()) {
            removeLeastScore();
        }
    }
    
    /**
     * Removes the lowest ranked score from the list.
     */
    private void removeLeastScore() {
        highscores.remove(getIndexForLeastKnownScore());
    }
    
    private boolean scoreIsHighEnoughToFitOnList(Score score) {
        if (!listIsAtLeastMaxLength()) {
            return true;
        }
        return score.isHigher(getLeastScore());
    }
    
    private boolean listIsAtLeastMaxLength() {
        return highscores.size() >= scoreAmountToKeep;
    }
    
    private Score getLeastScore() {
        if (highscores.isEmpty()) {
            return new Score(null, Constants.DEFAULT_ANON_PLAYER_NAME, 0);
        }
        return highscores.get(getIndexForLeastKnownScore());
    }
    
    private int getIndexForLeastKnownScore() {
        return highscores == null || highscores.isEmpty() ? null : highscores.size() - 1;
    }
}
