package tetris.logic;

import java.util.Collections;
import java.util.List;
import tetris.domain.Score;

public class Highscores {
    
    private List<Score> highscores;
    private int scoreAmountToKeep;
    
    public Highscores(List<Score> highscores) {
        this.highscores = highscores;
        this.scoreAmountToKeep = 10;
    }
    
    public void saveIfHighEnough(Score score) {
        if (scoreIsHighEnoughToFitOnList(score)) {
            trimListSize();
            addHighscoreToList(score);
        }
    }
    
    public List<Score> getAll() {
        return this.highscores;
    }
    
    private void addHighscoreToList(Score score) {
        highscores.add(score);
        Collections.sort(highscores);
    }
    
    private void trimListSize() {
        while (listIsAtLeastMaxLength()) {
            removeLeastScore();
        }
    }
    
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
        return highscores.get(getIndexForLeastKnownScore());
    }
    
    private int getIndexForLeastKnownScore() {
        return highscores.size() - 1;
    }
}
