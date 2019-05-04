package tetris.domain;

import tetris.Constants;

/**
 * This class represents one single score. It holds the integer value of
 * the score and also an String for the name who the score belongs to.
 */
public class Score extends AbstractIdObject implements Comparable<Score> {
    
    private String name;
    private int score;

    public Score(Integer id, String name, int score) {
        super(id);
        this.name = name;
        this.score = score;
    }

    public Score() {
        this(null, Constants.DEFAULT_ANON_PLAYER_NAME, 0);
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    /**
     * Checks if this score is higher than the score passed as parameter.
     * @param other score to be compared against.
     * @return true, if this score is higher, false otherwise.
     */
    public boolean isHigher(Score other) {
        return compareTo(other) < 0;
    }
    
    /**
     * This class implements the interface Comparable and this method is
     * used for sorting scores. Higher scores are ranked towards the beginning,
     *  or in other words: higher on the list.
     * @param other score to compare against.
     * @return integer, negative if this is higher than the one compared to,
     *  positive if other is higher. 0 if the scores match.
     */
    @Override
    public int compareTo(Score other) {
        return other.score - this.score;
    }

    @Override
    public String toString() {
        return getName() + ", score: " + getScore();
    }
    
}
